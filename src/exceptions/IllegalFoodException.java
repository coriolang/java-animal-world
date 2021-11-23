package exceptions;

import resources.Resources;

public class IllegalFoodException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = Resources.getStrings().getString("FOOD_EXCEPTION");

    public IllegalFoodException() {
        super(DEFAULT_MESSAGE);
    }

    public IllegalFoodException(String message) {
        super(message);
    }
}
