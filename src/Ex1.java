public class Ex1 {

    // Convert the given number
    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) return -1;

        if (num.charAt(0) == '-') return -1;  // Reject negative numbers for now

        int baseIndex = num.indexOf('b');
        if (baseIndex == -1) {
            try {
                return Integer.parseInt(num); // Handle as base-10 number
            } catch (NumberFormatException e) {
                return -1; // Invalid decimal number
            }
        }

        String numberPart = num.substring(0, baseIndex);
        char basePart = num.charAt(baseIndex + 1);
        int base = baseValidation(basePart);
        if (base == -1) return -1;

        int result = 0;
        for (char c : numberPart.toCharArray()) {
            int digit = digitValidation(c, base);
            if (digit == -1) return -1;
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
            int remainder = num % base;
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + remainder - 10);
            result.append(digit);
            num /= base;
        }
        return result.reverse().toString() + "b" + base;
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
        if (num == null || num.isEmpty()) return false;
        int baseIndex = num.indexOf('b');
        if (baseIndex == -1) return false; // The letter 'b' is missing

        String numberPart = num.substring(0, baseIndex);
        String basePart = num.substring(baseIndex + 1);

        // Validate the base part
        if (basePart.length() != 1) return false;
        char baseChar = basePart.charAt(0);
        if (!(baseChar >= '2' && baseChar <= '9' || baseChar >= 'A' && baseChar <= 'G')) {
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

    public static boolean equals(String num1, String num2) {
        return number2Int(num1) == number2Int(num2);
    }
}