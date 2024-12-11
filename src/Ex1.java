
public class Ex1 {

    // Convert the given number
    public static int number2Int(String num) {
        // If input is null, empty, or doesn't contain the character 'b', return -1 which indicates an invalid input
        if (num == null || num.isEmpty()) return -1;

        // Take the b index and separate b from the number
        int baseIndex = num.indexOf('b');
        if (baseIndex == -1) return Integer.parseInt(num);
        ;
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

    public static boolean equals(String num1, String num2) {
        return number2Int(num1) == number2Int(num2);
    }
}


