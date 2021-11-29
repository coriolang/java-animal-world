package exceptions;

import main.Main;

public class IllegalFeedingDeadException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Main.stringResources.getString("FEEDING_DEAD_EXCEPTION");

    public IllegalFeedingDeadException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalFeedingDeadException(String message) {
        super(message);
    }
}
