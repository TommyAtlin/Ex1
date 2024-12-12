// All the Ex1 numberbase manipulation methods
public class Ex1 {
    // number2Int Converts a string representation of a number in a given base to a valid integer
    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) return -1; // Handle null or empty input

        int baseIndex = num.indexOf('b'); // Find the letter b
        if (baseIndex == -1) return Integer.parseInt(num); // If no base value the number as it is

        String numberPart = num.substring(0, baseIndex); // Extract the number part
        String basePart = num.substring(baseIndex + 1); // Extract the base part

        if (basePart.length() != 1) return -1; // Base should be a single character if not return -1
        char baseChar = basePart.charAt(0);
        int base = baseValidation(baseChar); // Validate the base character
        if (base == -1) return -1; // Return -1 for invalid base

        if (numberPart.equals("0")) return 0; // Zero number case, Individual case

        int result = 0; // create parameter result
        for (char c : numberPart.toCharArray()) {
            int digit = digitValidation(c, base); // Validate each digit
            if (digit == -1) return -1; // Return -1 for invalid digit
            result = result * base + digit; // Convert to integer
        }
        return result; // Return the  integer value after conversion
    }

    // baseValidation validates the base character and returns its integer value
    private static int baseValidation(char c) {
        if (c >= '2' && c <= '9') {
            return c - '0'; // Convert character to integer for bases 2-9
        } else if (c >= 'A' && c <= 'G') {
            return c - 'A' + 10; // Convert character to integer for bases 10-16
        } else {
            return -1; // Return -1 for invalid base
        }
    }

    // Validates a digit character as for specified base
    private static int digitValidation(char c, int base) {
        if (c >= '0' && c <= '9') {
            int digit = c - '0'; // Convert character to digit
            return digit < base ? digit : -1; // Check if digit is valid for the base
        } else if (c >= 'A' && c <= 'G') {
            int digit = c - 'A' + 10; // Convert character to digit for bases 10-16
            return digit < base ? digit : -1; // Check if digit is valid for base
        } else {
            return -1; // Return -1 for invalid character
        }
    }

    // Converts integer to a string representation in a specified base
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            throw new IllegalArgumentException("Invalid input: number must be non-negative and base must be between 2 and 16"); //Error Handling for invalid base
        }
        if (num == 0) return "0b" + base; // Special case for zero

        StringBuilder result = new StringBuilder(); // Use StringBuilder function for optimal string representation
        while (num > 0) {
            int remain = num % base; // Get the remain(%)
            char digit = (char) (remain < 10 ? '0' + remain : 'A' + remain - 10); // Convert to character
            result.append(digit); // Append digit to result
            num /= base; // Reduce num
        }
        result.reverse(); // Reverse the result to get the right order
        String baseNumberToLetter = ""; // Prepare to append base letter

        // Showcase the right num to base valuation
        if (base == 10) {
            baseNumberToLetter = "A"; // Base 10
        } else if (base == 11) {
            baseNumberToLetter = "B"; // Base 11
        } else if (base == 12) {
            baseNumberToLetter = "C"; // Base 12
        } else if (base == 13) {
            baseNumberToLetter = "D"; // Base 13
        } else if (base == 14) {
            baseNumberToLetter = "E"; // Base 14
        } else if (base == 15) {
            baseNumberToLetter = "F"; // Base 15
        } else if (base == 16) {
            baseNumberToLetter = "G"; // Base 16
        } else {
            baseNumberToLetter = Integer.toString(base); // For bases 2-10
        }

        // Append the base letter at the end
        return result.toString() + "b" + baseNumberToLetter;
    }

    // maxIndex finds the index of the maximum value in an array of number strings
    public static int maxIndex(String[] arr) {
        int maxIndex = -1; // Start with an invalid index
        int maxValue = number2Int(arr[0]);  // use the first string as an integer

        // Iterate through the array to find the maximum value
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]); // Convert string to integer
            if (value > maxValue) {
                maxValue = value; // Update maximum value and index
                maxIndex = i;
            }
        }

        return maxIndex; // Return the index of the maximum value
    }

    // isNumber checks if a string is a valid number representation
    public static boolean isNumber(String num) {
        if (num == null || num.isEmpty()) return false; // Check for null or empty

        // Allow "0" and "1" as valid inputs
        if (num.equals("0") || num.equals("1")) {
            return true;
        }

        int baseIndex = num.indexOf('b'); // Find  base indicator
        if (baseIndex == -1) return false; // Handle Missing base indicator

        String numberPart = num.substring(0, baseIndex); // Extract number part
        String basePart = num.substring(baseIndex + 1); // Extract base part

        // Validate base part
        if (basePart.length() != 1) return false; // Base must be a single character
        char baseChar = basePart.charAt(0);
        int base = baseValidation(baseChar); // Validate the base character
        if (base == -1) return false; // Invalid base

        // Validate number part
        if (numberPart.isEmpty()) return false; // Number part cannot be empty

        for (char c : numberPart.toCharArray()) {
            if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'G')) {
                return false; // Invalid character
            }
            int digit = digitValidation(c, base); // Validate digit for base
            if (digit == -1) return false; // Invalid digit for base
        }
        return true;
    }

    // Compares two number strings for equality
    public static boolean equals(String num1, String num2) {
        return number2Int(num1) == number2Int(num2); // Compare integer values
    }
}