package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleController {

    private static Scanner in = new Scanner(System.in);

    public static void createHerbivore() {
        System.out.println(MainController.stringResources.getString("ENTER_HERB_NAME"));
        String name = ConsoleController.getUserInputString();

        System.out.println(MainController.stringResources.getString("ENTER_HERB_WEIGHT"));
        float weight = ConsoleController.getUserInputFloat();

        String creationStatus = MainController.createHerbivore(name, weight);

        System.out.println(creationStatus);
    }

    public static void createPredator() {
        System.out.println(MainController.stringResources.getString("ENTER_PRED_NAME"));
        String name = ConsoleController.getUserInputString();

        System.out.println(MainController.stringResources.getString("ENTER_PRED_WEIGHT"));
        float weight = ConsoleController.getUserInputFloat();

        String creationStatus = MainController.createPredator(name, weight);

        System.out.println(creationStatus);
    }

    public static void createGrass() {
        System.out.println(MainController.stringResources.getString("ENTER_GRASS_NAME"));
        String name = ConsoleController.getUserInputString();

        System.out.println(MainController.stringResources.getString("ENTER_GRASS_WEIGHT"));
        float weight = ConsoleController.getUserInputFloat();

        String creationStatus = MainController.createGrass(name, weight);

        System.out.println(creationStatus);
    }

    public static void killAnimal() {
        System.out.println(MainController.stringResources.getString("SELECT_ANIMAL_TO_KILL"));

        ArrayList<String> animals = MainController.getLiveAnimalsList();

        ConsoleController.printList(animals);

        int animalId = ConsoleController.getUserInputInt();
        String selectedAnimal = animals.get(animalId);
        String murderStatus = MainController.killAnimal(selectedAnimal);

        System.out.println(murderStatus);
    }

    public static void feedHerbivore() {
        System.out.println(MainController.stringResources.getString("SELECT_HERB"));

        ArrayList<String> herbivores = MainController.getLiveHerbivoresList();
        ConsoleController.printList(herbivores);

        int herbivoreId = ConsoleController.getUserInputInt();
        String selectedHerbivore = herbivores.get(herbivoreId);

        System.out.println(MainController.stringResources.getString("SELECT_GRASS"));

        ArrayList<String> grasses = MainController.getGrassesList();
        ConsoleController.printList(grasses);

        int grassId = ConsoleController.getUserInputInt();
        String selectedGrass = grasses.get(grassId);

        String feedStatus = MainController.feedAnimal(selectedHerbivore, selectedGrass);
        System.out.println(feedStatus);
    }

    public static void feedPredator() {
        System.out.println(MainController.stringResources.getString("SELECT_PREDATOR"));

        ArrayList<String> predators = MainController.getLivePredatorsList();
        ConsoleController.printList(predators);

        int predatorId = ConsoleController.getUserInputInt();
        String selectedPredator = predators.get(predatorId);

        System.out.println(MainController.stringResources.getString("SELECT_HERB"));

        ArrayList<String> herbivores = MainController.getLiveHerbivoresList();
        ConsoleController.printList(herbivores);

        int herbivoreId = ConsoleController.getUserInputInt();
        String selectedHerbivore = herbivores.get(herbivoreId);

        String feedStatus = MainController.feedAnimal(selectedPredator, selectedHerbivore);
        System.out.println(feedStatus);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage() + "\n");
        e.printStackTrace();
    }

    public static void printList(ArrayList<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
        System.out.println();
    }

    public static void printSelectedAnimal() {
        System.out.println(MainController.stringResources.getString("SELECT_ANIMAL"));

        int animalId = ConsoleController.getUserInputInt();
        String selectedAnimal = MainController.getAnimalById(animalId);

        System.out.println(selectedAnimal);
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
            printExceptionMessage(e);
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
            printExceptionMessage(e);
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
