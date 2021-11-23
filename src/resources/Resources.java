package resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resources {

    private static ResourceBundle configs = ResourceBundle.getBundle("resources.Settings");
    private static ResourceBundle strings = ResourceBundle
            .getBundle("resources.Strings", new Locale(configs.getString("LOCALE")));

    public static ResourceBundle getConfigs() {
        return configs;
    }

    public static ResourceBundle getStrings() {
        return strings;
    }
}
