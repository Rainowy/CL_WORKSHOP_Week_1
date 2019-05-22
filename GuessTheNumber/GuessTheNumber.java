import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        Random r = new Random();

        int pcNumber = r.nextInt(99) + 1;

        System.out.println("Enter the number");

        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Enter numbers only");
        }

        int userNumber = scan.nextInt();

        while (true) {

            if (userNumber < pcNumber) {
                System.out.println("To low.Enter number");

                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("Enter numbers only");
                }
                userNumber = scan.nextInt();
            } else if (userNumber > pcNumber) {
                System.out.println("To high. Enter number");

                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("Enter numbers only");
                }
                userNumber = scan.nextInt();
            } else if (userNumber == pcNumber) {
                System.out.println("You got it !");
                break;
            }
        }
    }
}
