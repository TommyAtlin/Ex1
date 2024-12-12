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

            // Check if the first input number is valid
            if (num1Value == -1) {
                System.out.println("num1 = " + num1 + " is not a valid number.");
                continue; // Restart loop if invalid
            }
            System.out.println("num1 = " + num1 + " is valid with value: " + num1Value);

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            String num2 = scanner.nextLine();
            if (num2.equals("quit")) {
                System.out.println("Quitting now...");
                break; // Exit loop if user types 'quit'
            }

            int num2Value = Ex1.number2Int(num2);

            // Check if the second input number is valid
            if (num2Value == -1) {
                System.out.println("num2 = " + num2 + " is not a valid number.");
                continue; // Restart loop if invalid
            }
            System.out.println("num2 = " + num2 + " is valid with value: " + num2Value);

            // Ask the user for a base value
            int baseNum = 0; // Declare baseNum outside the loop
            while (true) {
                System.out.print("Enter a base for output (between 2 and 16): ");
                String baseInput = scanner.nextLine();

                try {
                    baseNum = Integer.parseInt(baseInput); // Convert input to integer
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    continue; // Prompt the user to type the base again
                }

                // Validate baseNum range
                if (baseNum >= 2 && baseNum <= 16) {
                    break; // Exit the loop if the base is valid
                } else {
                    System.out.println("Base must be between 2 and 16. Please try again.");
                }
            }

            // Convert sum and product to the chosen base after validation loop
            String sumInBase = Ex1.int2Number(num1Value + num2Value, baseNum);
            String prodInBase = Ex1.int2Number(num1Value * num2Value, baseNum);

            // Display the sum and product
            System.out.println(num1 + " + " + num2 + " = " + sumInBase);
            System.out.println(num1 + " * " + num2 + " = " + prodInBase);

            // State the array of numbers for comparison
            String[] allNumbers = {num1, num2, sumInBase, prodInBase};
            int maxIndex = Ex1.maxIndex(allNumbers); // Find the maximum number
            System.out.println("Max number over " + String.join(", ", allNumbers) + " is: " + allNumbers[maxIndex]);

            break; // Exit after the base conversion and comparison
        }

        scanner.close(); // Close the scanner
    }
}