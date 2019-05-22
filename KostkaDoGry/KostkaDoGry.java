import java.util.Arrays;
import java.util.Random;

public class KostkaDoGry {

    public static void main(String[] args) {


        String code = "2D50-12"; //OPIS KODU: Liczba przed D oznacza ilość wyrzuceń kostki np: 3 oznacza 3 rzuty. Liczba za D oznacza wielkość kostki, np: 10 oznacza dziesięciościenna. Plus lub minus oznacza dodaną lub odjętą ilość punktów od wyniku


        String[] arr = code.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])"); //Dzieli String na osobne litery i cyfry i wsadza do listy

        Random r = new Random();

        int sum = 0;
        int rNr = 0;

        if (arr[0].equalsIgnoreCase("D")) {
            sum = getSum(code, arr, r);
            System.out.println("Wynik to" + sum);

        } else {
            sum = getMultiSum(code, arr, r);
            System.out.println("Wynik to " + sum);
        }
    }

    private static int getMultiSum(String code, String[] arr, Random r) {
        int sum = 0;
        int rNr;
        for (int i = 1; i <= Integer.parseInt(arr[0]); i++) {
            rNr = (r.nextInt(Integer.parseInt(arr[2])) + 1);
            sum += rNr;
        }
        if (code.contains("+")) {
            sum += Integer.parseInt(arr[3]);
        } else if (code.contains("-")) {
            sum -= Integer.parseInt(arr[3]);
        }
        return sum;
    }

    private static int getSum(String code, String[] arr, Random r) {
        int rNr;
        int sum;
        if (code.contains("+")) {
            rNr = (r.nextInt(Integer.parseInt(arr[1])) + 1);
            sum = rNr + Integer.parseInt(arr[2]);
        } else if (code.contains("-")) {
            rNr = (r.nextInt(Integer.parseInt(arr[1])) + 1);
            sum = rNr - Integer.parseInt(arr[2]);
        } else {
            sum = (r.nextInt(Integer.parseInt(arr[1])) + 1);
        }
        return sum;
    }
}

