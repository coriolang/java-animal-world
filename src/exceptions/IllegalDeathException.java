package exceptions;

public class IllegalDeathException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Нельзя убить мертвое животное!";

    public IllegalDeathException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalDeathException(String message) {
        super(message);
    }
}
