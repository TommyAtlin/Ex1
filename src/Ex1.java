
public class Ex1 {

    // Convert the given number
    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) return -1;

        int baseIndex = num.indexOf('b');
        if (baseIndex == -1) return Integer.parseInt(num);

        String numberPart = num.substring(0, baseIndex);
        char basePart = num.charAt(baseIndex + 1);

        int base = baseValidation(basePart);
        if (base == -1) return -1;

        int result = 0;
        for (char c : numberPart.toCharArray()) {
            int digit = digetValidation(c, base);
            if (digit == -1) return -1; // invalid digit
            result = result * base + digit;
        }
        return result;
    }

    private static int baseValidation(char c) {    // private method for base validation
        if (c >= '2' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'G') {
            return c - 'A' + 10;
        } else {
            return -1;
        }
    }

    private static int digetValidation(char c, int base) {    // private method for digit validation
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'G') {
            return c - 'A' + 10;
        } else {
            return -1;
        }
    }

    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            System.out.println("Invalid input: number must be non-negative and base must be between 2 and 16");
        }

        StringBuilder result = new StringBuilder(); // for number storage
        while (num > 0) {
            int remainder = num % base;
            char digit = (char) ('0' + remainder);
            if (remainder >= 10) {
                digit = (char) ('A' + remainder - 10);
            }
            result.insert(0, digit);
            num /= base;
        }
        return result.toString() + "b" + base;
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

    public static boolean equals(String num1, String num2) {
        return number2Int(num1) == number2Int(num2);
    }
}