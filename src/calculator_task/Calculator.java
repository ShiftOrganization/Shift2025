package calculator_task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static final int maxOperationsNumber = 10;
    private static final int[] operationResults = new int[maxOperationsNumber];
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

    public static int divideNumbers(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            DivideByZeroException e = new DivideByZeroException("Ошибка деления на ноль");
            logExceptionToFile(e);
            throw e;
        }
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

    public static void addOperationToHistory(String operation) {
        try (FileWriter fileWriter = new FileWriter("history.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(LocalDateTime.now() + " : " + operation);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл history.txt: " + e.getMessage());
        }
    }

    public static void printHistoryFromFile() {
        Path path = Paths.get("history.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла history.txt: " + e.getMessage());
        }
    }

    public static void logExceptionToFile(Exception exception) {
        try (FileWriter fileWriter = new FileWriter("log.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("[" + LocalDateTime.now() + "] " + "Тип: " + exception.getClass().getName() +
                    ", Сообщение: " + exception.getMessage());
            for (StackTraceElement elem : exception.getStackTrace()) {
                printWriter.println("\t" + elem.toString());
            }
            printWriter.println();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл log.txt: " + e.getMessage());
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
        addOperationToHistory(a + " + " + b + " = " + result1);

        int result2 = subtractNumbers(a, b);
        saveOperationResult(result2);
        printResult(result2);
        addOperationToHistory(a + " - " + b + " = " + result2);

        int result3 = multiplyNumbers(a, b);
        saveOperationResult(result3);
        printResult(result3);
        addOperationToHistory(a + " * " + b + " = " + result3);

        try {
            int result4 = divideNumbers(a, b);
            saveOperationResult(result4);
            printResult(result4);
            addOperationToHistory(a + " / " + b + " = " + result4);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            addOperationToHistory(a + " / " + b + " = " + e.getMessage());
        }

        int result5 = addNumbers(a, b);
        saveOperationResult(result5);
        printResult(result5);
        addOperationToHistory(a + " + " + b + " = " + result5);

        int result6 = subtractNumbers(a, b);
        saveOperationResult(result6);
        printResult(result6);
        addOperationToHistory(a + " - " + b + " = " + result6);

        int result7 = multiplyNumbers(a, b);
        saveOperationResult(result7);
        printResult(result7);
        addOperationToHistory(a + " * " + b + " = " + result7);

        try {
            int result8 = divideNumbers(a, b);
            saveOperationResult(result8);
            printResult(result8);
            addOperationToHistory(a + " / " + b + " = " + result8);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            addOperationToHistory(a + " / " + b + " = " + e.getMessage());
        }

        int result9 = addNumbers(a, b);
        saveOperationResult(result9);
        printResult(result9);
        addOperationToHistory(a + " + " + b + " = " + result9);

        int result10 = subtractNumbers(a, b);
        saveOperationResult(result10);
        printResult(result10);
        addOperationToHistory(a + " - " + b + " = " + result10);

        int result11 = multiplyNumbers(a, b);
        saveOperationResult(result11);
        printResult(result11);
        addOperationToHistory(a + " * " + b + " = " + result11);

        try {
            int result12 = divideNumbers(a, b);
            saveOperationResult(result12);
            printResult(result12);
            addOperationToHistory(a + " / " + b + " = " + result12);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            addOperationToHistory(a + " / " + b + " = " + e.getMessage());
        }

        int result13 = addNumbers(a, b);
        saveOperationResult(result13);
        printResult(result13);
        addOperationToHistory(a + " + " + b + " = " + result13);

        int result14 = subtractNumbers(a, b);
        saveOperationResult(result14);
        printResult(result14);
        addOperationToHistory(a + " - " + b + " = " + result14);

        int result15 = multiplyNumbers(a, b);
        saveOperationResult(result15);
        printResult(result15);
        addOperationToHistory(a + " * " + b + " = " + result15);

        printLastOperations();
        printHistoryFromFile();
    }
}