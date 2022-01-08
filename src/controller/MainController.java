package controller;

import exceptions.IllegalWeightException;
import model.Grass;
import model.Herbivore;
import model.Predator;
import repository.Forest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController {

    private static final String CONFIGS_FILE = FileSystems.getDefault()
            .getPath("src", "resources", "configs.properties").toString();

    private static Properties properties;
    public static String repositoryFile;

    public static final int EMPTY_INIT_MODE = 0;
    public static final int DEFAULT_INIT_MODE = 1;
    public static final int FILE_INIT_MODE = 2;

    public static ResourceBundle stringResources;

    private static Forest forest;

    public static void startApp() throws FileNotFoundException {
        try(FileInputStream fis = new FileInputStream(CONFIGS_FILE)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

        int iniType = Integer.parseInt(
                properties.getProperty("INITIALIZATION_TYPE")
        );

        String currentOSName = System.getProperty("os.name");

        if (currentOSName.contains("Windows")) {
            repositoryFile = properties.getProperty("REPOSITORY_FILE_WINDOWS");
        } else if (currentOSName.contains("Linux")) {
            repositoryFile = properties.getProperty("REPOSITORY_FILE_LINUX");
        } else if (currentOSName.contains("Mac")) {
            repositoryFile = properties.getProperty("REPOSITORY_FILE_MACOS");
        } else {
            repositoryFile = FileSystems.getDefault().getPath("forest.dat").toString();
            iniType = 1;
            System.out.println("Operating system not defined. Default initialization.");
        }

        stringResources = ResourceBundle.getBundle(
                "resources.strings",
                new Locale(properties.getProperty("LOCALE"))
        );

        switch (iniType) {
            case EMPTY_INIT_MODE:
                Forest.emptyInit();
                break;
            case DEFAULT_INIT_MODE:
                Forest.defaultInit();
                break;
            case FILE_INIT_MODE:
                try {
                    Forest.load(repositoryFile);
                } catch (IOException | ClassNotFoundException e) {
                    if (e instanceof FileNotFoundException) {
                        System.out.println(stringResources.getString("FILE_NOT_FOUND"));
                        Forest.defaultInit();
                    } else {
                        System.out.println(e.getMessage());
                    }
                }
                break;
        }

        forest = Forest.getInstance();
    }

    public static void closeApp() throws IOException {
        Forest.save(MainController.repositoryFile);
        System.exit(0);
    }

    private static void saveConfigs() throws IOException {
        try(FileOutputStream fos = new FileOutputStream(CONFIGS_FILE)) {
            properties.store(fos, null);
        } catch (IOException e) {
            throw e;
        }
    }

    public static String applyConfig(int selectedLanguage) throws IOException {
        String languageStatus = stringResources.getString("LANGUAGE_NOT_SELECTED");

        if (selectedLanguage == 0) {
            properties.setProperty("LOCALE", "ru");
        } else if (selectedLanguage == 1) {
            properties.setProperty("LOCALE", "en");
        }

        saveConfigs();

        stringResources = ResourceBundle.getBundle(
                "resources.strings",
                new Locale(properties.getProperty("LOCALE"))
        );

        if (selectedLanguage == 0) {
            languageStatus = stringResources.getString("SELECTED_RUSSIAN");
        } else if (selectedLanguage == 1) {
            languageStatus = stringResources.getString("SELECTED_ENGLISH");
        }

        return languageStatus;
    }

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

    public static ArrayList<String> getAllAnimalsList() {
        ArrayList<String> animalList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            animalList.add("Animal " + i);
        }

        return animalList;
    }

    public static ArrayList<String> getAllHerbivoresList() {
        ArrayList<String> herbivoreList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            herbivoreList.add("Herbivore " + i);
        }

        return herbivoreList;
    }

    public static ArrayList<String> getAllPredatorsList() {
        ArrayList<String> predatorList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            predatorList.add("Predator " + i);
        }

        return predatorList;
    }

    public static ArrayList<String> getGrassesList() {
        ArrayList<String> grassList = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            grassList.add("Grass " + i);
        }

        return grassList;
    }

    public static ArrayList<String> getLiveAnimalsList() {
        ArrayList<String> animalList = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            animalList.add("Live Animal " + i);
        }

        return animalList;
    }

    public static ArrayList<String> getLiveHerbivoresList() {
        ArrayList<String> herbivoreList = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            herbivoreList.add("Live Herbivore " + i);
        }

        return herbivoreList;
    }

    public static ArrayList<String> getLivePredatorsList() {
        ArrayList<String> predatorList = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            predatorList.add("Live Predator " + i);
        }

        return predatorList;
    }

    public static String getAnimalById(int id) {
        ArrayList<String> animalList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            animalList.add("Animal " + i);
        }

        String animal = animalList.get(id);

        return animal;
    }

    public static String createItem(String type, String name, float weight) {
        String creationStatus = "Created: " + type + " " + name + " weight = " + weight;
        return creationStatus;
    }

    public static String createHerbivore(String name, float weight) {
        String creationStatus = null;

        try {
            Herbivore herbivore = new Herbivore(name, weight);
            forest.create(herbivore);
            creationStatus = "Created: " + herbivore.getInfo();
        } catch (IllegalWeightException e) {
            creationStatus = e.getMessage();
        }

        return creationStatus;
    }

    public static String createPredator(String name, float weight) {
        String creationStatus = null;

        try {
            Predator predator = new Predator(name, weight);
            forest.create(predator);
            creationStatus = "Created: " + predator.getInfo();
        } catch (IllegalWeightException e) {
            creationStatus = e.getMessage();
        }

        return creationStatus;
    }

    public static String createGrass(String name, float weight) {
        String creationStatus = null;

        try {
            Grass grass = new Grass(name, weight);
            forest.create(grass);
            creationStatus = "Created: " + grass.getInfo();
        } catch (IllegalWeightException e) {
            creationStatus = e.getMessage();
        }

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
