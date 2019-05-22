import java.util.*;

public class Lotto {

    public static void main(String[] args) {

        int[] pcArray = pcRandom();

        int[] enteredNumbers = new int[6];

        System.out.println("Enter 6 numbers");
        for (int i = 0; i < enteredNumbers.length; i++) {
            int number;
            do {
                number = checkString();
                if (useLoop(enteredNumbers, number) || (!arrValidation(enteredNumbers, number))) {
                    System.out.println("Number not in range or entered already. Pls enter again");
                }
            }
            while (!arrValidation(enteredNumbers, number));
            enteredNumbers[i] = number;
        }
        List<Integer> matchList = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < enteredNumbers.length; i++) {
            for (int j = 0; j < enteredNumbers.length; j++) {
                if (enteredNumbers[i] == pcArray[j]) {
                    counter++;
                    matchList.add(enteredNumbers[i]);
                }
            }
        }
        System.out.println("Pc numbers");
        Arrays.sort(pcArray);
        arrToString(pcArray);
        System.out.println("Your numbers");
        Arrays.sort(enteredNumbers);
        arrToString(enteredNumbers);
        System.out.println("Matching numbers: " + counter);
        for (int i : matchList) {
            System.out.println(i + "\t");
        }
        System.out.println();
    }


    private static boolean arrValidation(int[] enteredNumbers, int number) {   //Walidacja
        for (int i = 0; i < enteredNumbers.length; i++) {
            if ((enteredNumbers[i] == 0) && (!useLoop(enteredNumbers, number)) && (number >= 1 && number <= 49)) {
                return true;
            }
        }
        return false;
    }

    private static int checkString() {  //Tylko cyfry

        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Enter numbers only");
        }
        return scan.nextInt();
    }

    private static boolean useLoop(int arr[], int number) {  // Sprawdza czy cyfra jest w array
        for (int i : arr) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    private static int[] pcRandom() {   //Losuje randomowe liczby
        int[] psArr = new int[6];
        Random r = new Random();
        for (int i = 0; i < psArr.length; i++) {
            psArr[i] = r.nextInt(48) + 1;
        }
        return psArr;
    }

    private static void arrToString(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}



