package exceptions;

import resources.Resources;

public class IllegalFeedingDeadException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Resources.getStrings().getString("FEEDING_DEAD_EXCEPTION");

    public IllegalFeedingDeadException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalFeedingDeadException(String message) {
        super(message);
    }
}
