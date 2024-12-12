import java.util.Scanner;
public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            String num1 = scanner.nextLine();
            if (num1.equals("quit")) {
                System.out.println("Quitting now...");
                break; // Exit loop if user types 'quit'
            }
            int num1Value = Ex1.number2Int(num1);
            if (num1Value == -1) {
                System.out.println("num1 = " + num1 + " is not a valid number.");
                continue;
            }
            System.out.println("num1 = " + num1 + " is valid with value: " + num1Value);

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            String num2 = scanner.nextLine();
            if (num2.equals("quit")) {
                System.out.println("Quitting now...");
                break;
            }
            int num2Value = Ex1.number2Int(num2);
            if (num2Value == -1) {
                System.out.println("num2 = " + num2 + " is not a valid number.");
                continue; // Restart loop if the input is invalid
            }
            System.out.println("num2 = " + num2 + " is valid with value: " + num2Value);
            int baseNum = 0;
            while (true) {
                System.out.print("Enter a base for output (between 2 and 16): ");
                String baseInput = scanner.nextLine();

                try {
                    baseNum = Integer.parseInt(baseInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    continue;
                }
                if (baseNum >= 2 && baseNum <= 16) {
                    break;
                } else {
                    System.out.println("Base must be between 2 and 16. Please try again.");
                }
            }

            // Convert the sum and product to the chosen base after validation
            String sumInBase = Ex1.int2Number(num1Value + num2Value, baseNum); // Calculate and convert sum
            String prodInBase = Ex1.int2Number(num1Value * num2Value, baseNum); // Calculate and convert product

            // Display the results of the sum and product
            System.out.println(num1 + " + " + num2 + " = " + sumInBase);
            System.out.println(num1 + " * " + num2 + " = " + prodInBase);

            // Create an array and store the numbers
            String[] allNumbers = {num1, num2, sumInBase, prodInBase};
            int maxIndex = Ex1.maxIndex(allNumbers); // Find the index of the maximum number
            System.out.println("Max number over " + String.join(", ", allNumbers) + " is: " + allNumbers[maxIndex]);

            break; // Exit after processing the numbers
        }
    }
}