public class Ex1 {

    // Convert the given number
    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) return -1;

        int baseIndex = num.indexOf('b');
        if (baseIndex == -1) return Integer.parseInt(num);

        String numberPart = num.substring(0, baseIndex);
        String basePart = num.substring(baseIndex + 1);

        if (basePart.length() != 1) return -1; // Base should be one character
        char baseChar = basePart.charAt(0);
        int base = baseValidation(baseChar);
        if (base == -1) return -1; // Invalid base

        if (numberPart.equals("0")) return 0; // Special case for zero

        int result = 0;
        for (char c : numberPart.toCharArray()) {
            int digit = digitValidation(c, base);
            if (digit == -1) return -1; // Invalid digit for the given base
            result = result * base + digit;
        }
        return result;
    }


    private static int baseValidation(char c) { // Private method for base validation
        if (c >= '2' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'G') {
            return c - 'A' + 10;
        } else {
            return -1;
        }
    }

    private static int digitValidation(char c, int base) { // Private method for digit validation
        if (c >= '0' && c <= '9') {
            int digit = c - '0';
            return digit < base ? digit : -1;
        } else if (c >= 'A' && c <= 'G') {
            int digit = c - 'A' + 10;
            return digit < base ? digit : -1;
        } else {
            return -1;
        }
    }

    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            throw new IllegalArgumentException("Invalid input: number must be non-negative and base must be between 2 and 16");
        }
        if (num == 0) return "0b" + base;

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int remain = num % base;
            char digit = (char) (remain < 10 ? '0' + remain : 'A' + remain - 10);
            result.append(digit);
            num /= base;
        }
        result.reverse();
        String baseNumberToLetter = "";
        if (base == 11) {
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

    // Find the maximum value number from the number array
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
        if (num == null || num.isEmpty()) return false; // Check for null or empty

        // Check for baseless numbers
        if (num.equals("0") || num.equals("1")) {
            return true; // Allow "0" and "1" as valid inputs
        }

        int baseIndex = num.indexOf('b');
        if (baseIndex == -1) return false; // Missing base indicator

        String numberPart = num.substring(0, baseIndex);
        String basePart = num.substring(baseIndex + 1);

        // Validate base part
        if (basePart.length() != 1) return false; // Base must be a single character
        char baseChar = basePart.charAt(0);
        int base = baseValidation(baseChar);
        if (base == -1) return false; // Invalid base

        // Validate number part
        if (numberPart.isEmpty()) return false; // Number part cannot be empty

        for (char c : numberPart.toCharArray()) {
            if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'G')) {
                return false; // Invalid character
            }
            int digit = digitValidation(c, base);
            if (digit == -1) return false; // Invalid digit for base
        }
        return true; // All checks passed
    }
        public static boolean equals (String num1, String num2){
            return number2Int(num1) == number2Int(num2);
        }
    }