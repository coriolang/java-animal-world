package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleController {

    private static Scanner in = new Scanner(System.in);

    public static void createHerbivore() {
        System.out.println(MainController.stringResources.getString("ENTER_HERB_NAME"));
        String name = ConsoleController.getUserInputString();

        System.out.println(MainController.stringResources.getString("ENTER_HERB_WEIGHT"));
        float weight = ConsoleController.getUserInputFloat();

        String creationStatus = null;
        try {
            creationStatus = MainController.create(0, name, weight);
        } catch (IOException e) {
            creationStatus = e.getMessage();
        }

        System.out.println(creationStatus);
    }

    public static void createPredator() {
        System.out.println(MainController.stringResources.getString("ENTER_PRED_NAME"));
        String name = ConsoleController.getUserInputString();

        System.out.println(MainController.stringResources.getString("ENTER_PRED_WEIGHT"));
        float weight = ConsoleController.getUserInputFloat();

        String creationStatus = null;
        try {
            creationStatus = MainController.create(1, name, weight);
        } catch (IOException e) {
            creationStatus = e.getMessage();
        }

        System.out.println(creationStatus);
    }

    public static void createGrass() {
        System.out.println(MainController.stringResources.getString("ENTER_GRASS_NAME"));
        String name = ConsoleController.getUserInputString();

        System.out.println(MainController.stringResources.getString("ENTER_GRASS_WEIGHT"));
        float weight = ConsoleController.getUserInputFloat();

        String creationStatus = null;
        try {
            creationStatus = MainController.create(2, name, weight);
        } catch (IOException e) {
            creationStatus = e.getMessage();
        }

        System.out.println(creationStatus);
    }

    public static void killAnimal() {
        System.out.println(MainController.stringResources.getString("SELECT_ANIMAL_TO_KILL"));

        try {
            MainController.setAnimalToKillHashMap(MainController.getLiveAnimals());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        ConsoleController.printList(MainController.getAnimalToKillHashMap());

        int animalId = ConsoleController.getUserInputInt();
        String murderStatus = null;
        try {
            murderStatus = MainController.kill(animalId);
        } catch (IOException e) {
            murderStatus = e.getMessage();
        }

        System.out.println(murderStatus);
    }

    public static void feedHerbivore() {
        System.out.println(MainController.stringResources.getString("SELECT_HERB"));

        try {
            MainController.setAnimalToFeedHashMap(MainController.getLiveHerbivores());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        ConsoleController.printList(MainController.getAnimalToFeedHashMap());

        int herbivoreId = ConsoleController.getUserInputInt();

        System.out.println(MainController.stringResources.getString("SELECT_GRASS"));

        try {
            MainController.setFoodsHashMap(MainController.getAllGrasses());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        ConsoleController.printList(MainController.getFoodsHashMap());

        int grassId = ConsoleController.getUserInputInt();

        String feedingStatus = null;
        try {
            feedingStatus = MainController.feed(herbivoreId, grassId);
        } catch (IOException e) {
            feedingStatus = e.getMessage();
        }

        System.out.println(feedingStatus);
    }

    public static void feedPredator() {
        System.out.println(MainController.stringResources.getString("SELECT_PREDATOR"));

        try {
            MainController.setAnimalToFeedHashMap(MainController.getLivePredators());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        ConsoleController.printList(MainController.getAnimalToFeedHashMap());

        int predatorId = ConsoleController.getUserInputInt();

        System.out.println(MainController.stringResources.getString("SELECT_HERB"));

        try {
            MainController.setFoodsHashMap(MainController.getLiveHerbivores());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        ConsoleController.printList(MainController.getFoodsHashMap());

        int herbivoreId = ConsoleController.getUserInputInt();

        String feedingStatus = null;
        try {
            feedingStatus = MainController.feed(predatorId, herbivoreId);
        } catch (IOException e) {
            feedingStatus = e.getMessage();
        }

        System.out.println(feedingStatus);
    }

    public static void printList(HashMap<Integer, String> list) {
        for (String element : list.values()) {
            System.out.println(element);
        }
        System.out.println();
    }

    public static void setLanguage(int selectedLanguage) {
        String languageStatus = null;

        try {
            languageStatus = MainController.applyConfig(selectedLanguage);
        } catch (IOException ex) {
            languageStatus = ex.getMessage();
        }

        System.out.println(languageStatus);
    }

    public static int getUserInputInt() {
        int input = -1;

        try {
            String tmp = in.nextLine().trim();
            input = Integer.parseInt(tmp);
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return input;
    }

    public static String getUserInputString() {
        return in.nextLine().trim();
    }

    public static float getUserInputFloat() {
        float input = 0.0F;

        try {
            String tmp = in.nextLine().trim();
            input = Float.parseFloat(tmp);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        return input;
    }

    public static void closeDialog() {
        try {
            in.close();
            MainController.closeApp();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
