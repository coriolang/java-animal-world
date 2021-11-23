package exceptions;

import resources.Resources;

public class IllegalWeightException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Resources.getStrings().getString("WEIGHT_EXCEPTION");

    public IllegalWeightException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalWeightException(String message) {
        super(message);
    }
}
