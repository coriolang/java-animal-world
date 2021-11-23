package exceptions;

import resources.Resources;

public class IllegalDeathException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Resources.getStrings().getString("DEATH_EXCEPTION");

    public IllegalDeathException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalDeathException(String message) {
        super(message);
    }
}
