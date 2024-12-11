import java.util.Scanner;

public class Ex1Main {

    // Convert the given number
    public static int number2Int(String num) {
        // If input is null, empty, or doesn't contain the character 'b', return -1 which indicates an invalid input
        if (num == null || num.isEmpty() || !num.contains("b")) return -1;

        // Take the b index and separate b from the number
        int baseIndex = num.indexOf('b');
        String numberPart = num.substring(0, baseIndex); // Extract the number
        String basePart = num.substring(baseIndex + 1); // Extract the base

        // Validate the base part
        if (basePart.length() != 1 || basePart.charAt(0) < '2' || basePart.charAt(0) > 'G') {
            return -1; // Invalid base
        }

        // Ensure the number part isn't empty
        if (numberPart.isEmpty()) {
            return -1;
        }

        int base = 0;
        char baseChar = basePart.charAt(0);
        // Determine the numerical base value ('2'-'9' or 'A'-'G')
        if (baseChar >= '2' && baseChar <= '9') {
            base = baseChar - '0';
        } else if (baseChar >= 'A' && baseChar <= 'G') { // in this case the diff between G to A is the same as binary numbers
            base = baseChar - 'A' + 10;
        } else {
            return -1; // Invalid base character
        }

        // Convert the number part into a decimal integer value
        int result = 0;
        for (int i = 0; i < numberPart.length(); i++) {
            char digitChar = numberPart.charAt(i);
            int digitValue = 0;

            // Check the number value that it is valid as per the template
            if (digitChar >= '0' && digitChar <= '9') {
                digitValue = digitChar - '0'; // Subtracting The number by 0 equals to Subtracting it by 48, as the char stored with a different value due to its type
            } else if (digitChar >= 'A' && digitChar <= 'G') {
                digitValue = digitChar - 'A' + 10;
            } else {
                return -1; // Invalid character in the number part
            }

            result = result * base + digitValue; // Calculate the result by converting to decimal
        }
        return result;
    }

    // Convert the number to a given base between 2 and 16
    public static String int2Number(int num, int base) {
        // If invalid number or base, return an empty string
        if (num < 0 || base < 2 || base > 16) return "";
        return Integer.toString(num, base); // Usage of the Java Builtin converter
    }

    // Find the maximum value number from the number Array
    public static int maxIndex(String[] arr) {
        int maxIndex = -1; // Start with invalid index
        int maxValue = Integer.MIN_VALUE; // Initialize maximum value

        // Loop through the array to find the maximum value
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]); // Convert string to integer value
            if (value > maxValue) {
                maxValue = value; // Update maximum value and index
                maxIndex = i;
            }
        }

        return maxIndex; // Return index of the maximum value
    }

    public static boolean isNumber(String num) {
        if (num == null || num.isEmpty()) return false;
        int baseIndex = num.indexOf('b');
        if (baseIndex == -1) return false; // the letter 'b' is missing
        String numberPart = num.substring(0, baseIndex);
        String basePart = num.substring(baseIndex + 1);

        // Validate the base part
        if (basePart.length() != 1 || (basePart.charAt(0) < '2' || (basePart.charAt(0) > '9' && basePart.charAt(0) < 'A') || basePart.charAt(0) > 'G')) {
            return false;
        }
        // Validate number part
        for (char c : numberPart.toCharArray()) {
            if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'G')) {
                return false; // Invalid character in number part
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            String num1 = scanner.nextLine();
            if (num1.equals("quit")) {
                System.out.println("quitting now...");
                break; // Exit loop if user types 'quit'
            }

            int num1Value = number2Int(num1);

            // Check if the first input number is valid
            if (num1Value == -1) {
                System.out.println("num1 = " + num1 + " is not a valid number.");
                continue; // Restart loop if invalid
            }
            System.out.println("num1 = " + num1 + " is valid with value: " + num1Value);

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            String num2 = scanner.nextLine();
            if (num2.equals("quit")) {
                System.out.println("quitting now...");
                break; // Exit loop if user types 'quit'
            }

            int num2Value = number2Int(num2);

            // Check if the second input number is valid
            if (num2Value == -1) {
                System.out.println("num2 = " + num2 + " is not a valid number.");
                continue; // Restart loop if invalid
            }
            System.out.println("num2 = " + num2 + " is valid with value: " + num2Value);

            // Exit if either of the numbers is invalid
            if (num1Value == -1 || num2Value == -1) {
                System.out.println("One or both numbers are invalid. Please check the format.");
                continue; // Restart loop if either is invalid
            }

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
            String sumInBase = int2Number(num1Value + num2Value, baseNum);
            String prodInBase = int2Number(num1Value * num2Value, baseNum);

// Display the sum and product
            System.out.println(num1 + " + " + num2 + " = " + sumInBase);
            System.out.println(num1 + " * " + num2 + " = " + prodInBase);

// Create valid representations of results for comparison
            String sumAsNumber = sumInBase + "b" + baseNum;
            String prodAsNumber = prodInBase + "b" + baseNum;

// State the array of numbers for comparison
            String[] allNumbers = {num1, num2, sumAsNumber, prodAsNumber};
            int maxIndex = maxIndex(allNumbers); // Find the maximum number
            System.out.println("Max number over " + String.join(", ", allNumbers) + " is: " + allNumbers[maxIndex]);


            break; // Exit after the base conversion and comparison
        }
    }
}
