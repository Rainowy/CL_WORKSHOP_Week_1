import java.util.Scanner;

public class GuessTheNumber2 {

    public static void main(String[] args) {


        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max 10 próbach");

        String answer;
        int min = 0;
        int max = 1000;
        int guess = ((max - min) / 2) + min;
        System.out.println("Zgaduję " + guess);
        answer = getString();


        int counter = 0;
        while (true) {
            counter++;
            if (counter > 10) {
                System.out.println("TY OSZUŚCIE !!!!");
                return;
            }
            switch (answer) {
                case "z":
                    System.out.println("WYGRAŁEM za " + counter + " razem");
                    return;
                case "d":
                    max = guess;
                    guess = ((max - min) / 2) + min;
                    System.out.println("Zgaduję " + guess);
                    answer = getString();
                    break;
                case "m":
                    min = guess;
                    guess = ((max - min) / 2) + min;
                    System.out.println("Zgaduję " + guess);
                    answer = getString();
                    break;
            }
        }
    }

    private static String getString() {
        String answer;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Za dużo - wpisz d, za mało - wpisz m, jeśli zgadł wpisz z");
            answer = scan.next();
        }
        while (!(answer.equalsIgnoreCase("d") || (answer.equalsIgnoreCase("m")) || (answer.equalsIgnoreCase("z"))));
        return answer;
    }
}
