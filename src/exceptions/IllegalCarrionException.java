package exceptions;

public class IllegalCarrionException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Хищник не ест падаль!";

    public IllegalCarrionException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalCarrionException(String message) {
        super(message);
    }
}
