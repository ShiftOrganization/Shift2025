import java.util.Scanner;

public class Calculator {
    private static int maxOperationsNumber = 10;
    private static int[] operationResults = new int[maxOperationsNumber];
    private static int operationCount = 0;

    public static int addNumbers(int a, int b) {
        return a + b;
    }

    public static int subtractNumbers(int a, int b) {
        return a - b;
    }

    public static int multiplyNumbers(int a, int b) {
        return a * b;
    }

    public static int divideNumbers(int a, int b) {
        return a / b;
    }

    public static void printResult(int result) {
        System.out.println("Результат операции: " + result);
    }

    public static void saveOperationResult(int result) {
        if (operationCount >= maxOperationsNumber) {
            for (int i = 1; i < maxOperationsNumber; i++) {
                operationResults[i - 1] = operationResults[i];
            }
            operationCount--;
        }
        operationResults[operationCount] = result;
        operationCount++;
    }

    public static void printLastOperations() {
        System.out.println("Последние " + operationCount + " операций:");
        for (int i = 0; i < operationCount; i++) {
            System.out.println("Операция " + (i + 1) + ": " + operationResults[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите два числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result1 = addNumbers(a, b);
        saveOperationResult(result1);
        printResult(result1);

        int result2 = subtractNumbers(a, b);
        saveOperationResult(result2);
        printResult(result2);

        int result3 = multiplyNumbers(a, b);
        saveOperationResult(result3);
        printResult(result3);

        int result4 = divideNumbers(a, b);
        saveOperationResult(result4);
        printResult(result4);

        int result5 = addNumbers(a, b);
        saveOperationResult(result5);
        printResult(result5);

        int result6 = subtractNumbers(a, b);
        saveOperationResult(result6);
        printResult(result6);

        int result7 = multiplyNumbers(a, b);
        saveOperationResult(result7);
        printResult(result7);

        int result8 = divideNumbers(a, b);
        saveOperationResult(result8);
        printResult(result8);

        int result9 = addNumbers(a, b);
        saveOperationResult(result9);
        printResult(result9);

        int result10 = subtractNumbers(a, b);
        saveOperationResult(result10);
        printResult(result10);

        int result11 = multiplyNumbers(a, b);
        saveOperationResult(result11);
        printResult(result11);

        int result12 = divideNumbers(a, b);
        saveOperationResult(result12);
        printResult(result12);

        int result13 = addNumbers(a, b);
        saveOperationResult(result13);
        printResult(result13);

        int result14 = subtractNumbers(a, b);
        saveOperationResult(result14);
        printResult(result14);

        int result15 = multiplyNumbers(a, b);
        saveOperationResult(result15);
        printResult(result15);

        printLastOperations();
    }
}