package exceptions;

public class IllegalWeightException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Масса не может быть отрицательной или нулевой!";

    public IllegalWeightException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalWeightException(String message) {
        super(message);
    }
}
