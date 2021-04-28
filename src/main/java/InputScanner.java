import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    public static void main(String[] args) {

        int[] numbers = new int[3];

        int i = 0;
        Scanner scanner = null;
        try {
            System.out.println("Please enter numbers");
            scanner = new Scanner(System.in);
            for (i = 0; i < numbers.length; i++) {
                numbers[i] = scanner.nextInt();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Caught exception "+ex.getMessage());
            numbers[i] = 0;
        }
        int total = 0;
        System.out.println("Entered numbers are :");
        for (int number : numbers) {
            System.out.println(number);
            total += (number * number);
        }
        System.out.println("Total value of givem 3 numbers" +total);
    }
}
