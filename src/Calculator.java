import java.util.Scanner;

public class Calculator {

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите два числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result1 = addNumbers(a, b);
        int result2 = subtractNumbers(a, b);
        int result3 = multiplyNumbers(a, b);
        int result4 = divideNumbers(a, b);

        printResult(result1);
        printResult(result2);
        printResult(result3);
        printResult(result4);
    }
}
