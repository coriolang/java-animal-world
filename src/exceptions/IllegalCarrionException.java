package exceptions;

import resources.Resources;

public class IllegalCarrionException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Resources.getStrings().getString("CARRION_EXCEPTION");

    public IllegalCarrionException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalCarrionException(String message) {
        super(message);
    }
}
