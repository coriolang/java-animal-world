package exceptions;

public class IllegalFeedingDeadException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Нельзя кормить мертвое животное!";

    public IllegalFeedingDeadException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalFeedingDeadException(String message) {
        super(message);
    }
}
