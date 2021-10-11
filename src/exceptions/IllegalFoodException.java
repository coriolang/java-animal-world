package exceptions;

public class IllegalFoodException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Животное не ест такую еду!";

    public IllegalFoodException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalFoodException(String message) {
        super(message);
    }
}
