package exceptions;

import main.Main;

public class IllegalDeathException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Main.stringResources.getString("DEATH_EXCEPTION");

    public IllegalDeathException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalDeathException(String message) {
        super(message);
    }
}
