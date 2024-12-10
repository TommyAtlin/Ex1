import java.util.Scanner;

public class Ex1 {

    public static int number2Int(String num) {
        if (num == null || !num.contains("b")) return -1;


        int baseIndex = num.indexOf('b');
        String numberPart = num.substring(0, baseIndex);
        String basePart = num.substring(baseIndex + 1);


        int base = 0;
        char baseChar = basePart.charAt(0);
        if (baseChar >= '2' && baseChar <= '9') {
            base = baseChar - '0';
        } else if (baseChar >= 'A' && baseChar <= 'G') {
            base = baseChar - 'A' + 10;
        } else {
            return -1;
        }


        int result = 0;
        for (int i = 0; i < numberPart.length(); i++) {
            char digitChar = numberPart.charAt(i);
            int digitValue = 0;

            if (digitChar >= '0' && digitChar <= '9') {
                digitValue = digitChar - '0';
            } else if (digitChar >= 'A' && digitChar <= 'G') {
                digitValue = digitChar - 'A' + 10;
            } else {
                return -1;
            }

            result = result * base + digitValue;
        }
        return result;
    }


    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return "";
        return Integer.toString(num, base);
    }


    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string as number#1  (or \"quit\" to end the program): ");
            String num1 = scanner.nextLine();
            if (num1.equals("quit")) break;
            int num1Value = number2Int(num1);
            boolean numberChecker;
            if (number2Int(num1) == -1) {
                numberChecker = false;
            } else {
                numberChecker = true;
            }

            System.out.print("num1 = "+ num1 + " is number : " + numberChecker + " value : " + num1Value + "\n");

            // Get second number input
            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            String num2 = scanner.nextLine();
            if (num2.equals("quit")) break;
            int num2Value = number2Int(num2);
            if (number2Int(num2) == -1) {
                numberChecker = false;
            } else {
                numberChecker = true;
            }

            System.out.print("num2 = "+ num2 + " is number : " + numberChecker + " value : " + num2Value + "\n");



            if (num1Value == -1 || num2Value == -1) {
                System.out.println("One or both numbers are invalid. Please check the format.");
                continue;
            }

            // Get base input
            System.out.print("Enter a base for output (between 2 and 16): ");
            int base = scanner.nextInt();
            scanner.nextLine();


            String sumInBase = int2Number(num1Value + num2Value, base);
            String prodInBase = int2Number(num1Value * num2Value, base);

            System.out.println(num1 + " + " + num2 + " = " + sumInBase);
            System.out.println(num1 + " * " + num2 + " = " + prodInBase);


            String sumAsNumber = sumInBase + "b" + base;
            String prodAsNumber = prodInBase + "b" + base;

            String[] allNumbers = {num1, num2, sumAsNumber, prodAsNumber};
            int maxIndex = maxIndex(allNumbers);
            System.out.println("Max number over " + String.join(", ", allNumbers) + " is: " + allNumbers[maxIndex]);
        }

        scanner.close();
    }
}