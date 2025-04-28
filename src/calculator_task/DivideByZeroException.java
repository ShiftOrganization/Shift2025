package calculator_task;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException(String message) {
        super(message);
    }
}