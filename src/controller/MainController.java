package controller;

import main.Main;

import java.util.ArrayList;

public class MainController {

    public static ArrayList<String> getFoodList(boolean isPredator) {
        String food;

        if (isPredator) {
            food = "Herbivore ";
        } else {
            food = "Grass ";
        }

        ArrayList<String> foodList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            foodList.add(food + i);
        }

        return foodList;
    }

    public static String applyConfig(int selectedLanguage) {
        String languageStatus = Main.getStringResources().getString("LANGUAGE_NOT_SELECTED");

        if (selectedLanguage == 0) {
            languageStatus = Main.getStringResources().getString("SELECTED_RUSSIAN");
        } else if (selectedLanguage == 1) {
            languageStatus = Main.getStringResources().getString("SELECTED_ENGLISH");
        }

        return languageStatus;
    }

    public static void closeApp() {
        System.exit(0);
    }

    public static String createItem(String type, String name, float weight) {
        String creationStatus = "Created: " + type + " " + name + " weight = " + weight;
        return creationStatus;
    }

    public static String feedAnimal(String animal, String food) {
        String feedStatus = "Animal to feed: " + animal + "\nFood: " + food;
        return feedStatus;
    }

    public static String killAnimal(String animal) {
        String murderStatus = "Killed: " + animal;
        return murderStatus;
    }

    public static ArrayList<String> getSelectedList(String list) {
        ArrayList<String> selectedList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            selectedList.add(i + " " + list);
        }

        return selectedList;
    }
}
