package exceptions;

import main.Main;

public class IllegalCarrionException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Main.stringResources.getString("CARRION_EXCEPTION");

    public IllegalCarrionException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalCarrionException(String message) {
        super(message);
    }
}
