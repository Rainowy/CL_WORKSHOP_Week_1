import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WyszukiwarkaSłów {

    public static void main(String[] args) {


        String url = "https://www.onet.pl";

        Connection connect = Jsoup.connect(url);

//        String[] split = new String[0];
//        List<String> lista = new ArrayList<>();

        try {
            Document doc = connect.get();
            Elements words = doc.select("span.title");
            for (Element elem : words) {
                String[] split = elem.text().split(" ");
                for (String s : split) {
                    if (s.length() > 3) {
                        writeToFile(s);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            filterWords();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeToFile(String elem) throws IOException {

        FileWriter fileWriter = new FileWriter("/home/tomasz/CL_WORKSHOPS/CL_WORKSHOP_Week_1/WyszukiwarkaSłów/popular_words.txt", true);
        fileWriter.append(elem + "\n");
        fileWriter.close();
    }

    private static void filterWords() throws IOException {

        LinkedHashSet<String> nonFiltered = new LinkedHashSet<>();
        List<String> whiteList = new ArrayList<>();
        whiteList.add("znamy");
        whiteList.add("Plejady");
        whiteList.add("Wielka");
        whiteList.add("Gwiazd");
        whiteList.add("2019:");
        whiteList.add("Byłem");
        whiteList.add("Czyste");
        whiteList.add("Fakt");
        whiteList.add("1500");
        whiteList.add("Aleppo");


        Path path = Paths.get("/home/tomasz/CL_WORKSHOPS/CL_WORKSHOP_Week_1/WyszukiwarkaSłów/popular_words.txt");

        if (Files.exists(path)) {

            for (String line : Files.readAllLines(path)) {


                nonFiltered.add(line);
            }//
        } else {
            System.out.println("File doesn't exist");
        }

        List<String> newList = new ArrayList<>();
        newList.addAll(nonFiltered);
        Collections.sort(newList);
        Collections.sort(whiteList);



        for (int i = 0; i < newList.size(); i++) {
            for (int j = 0; j < whiteList.size(); j++) {
                if (newList.get(i).equals(whiteList.get(j))) {
                    newList.remove(newList.get(i));
                }
            }
        }

        for (String s : newList) {
            System.out.println(s);
        }
        createFile(newList);
    }

    private static void createFile(List<String> list){

        Path path = Paths.get("/home/tomasz/CL_WORKSHOPS/CL_WORKSHOP_Week_1/WyszukiwarkaSłów/popular_words2.txt");

        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.write(path,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
