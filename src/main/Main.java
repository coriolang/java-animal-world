package main;

import exceptions.*;
import model.Animal;
import model.Grass;
import model.Herbivore;
import model.Predator;
import repository.Forest;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.*;

public class Main {

    private static final String CONFIGS_FILE = FileSystems.getDefault()
            .getPath("src", "resources", "configs.properties").toString();

    private static Properties properties;
    private static int iniType;
    private static String repositoryFile;

    public static ResourceBundle stringResources;

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            startApp();
        } catch (FileNotFoundException e) {
            System.out.println("File with configs not found!");
            return;
        }

        Forest forest = Forest.getInstance();

        System.out.println(stringResources.getString("HELLO_WORLD"));

        int selectedMenu = -1;

        while (selectedMenu != 0) {
            System.out.println(stringResources.getString("MAIN_MENU"));

            selectedMenu = getUserInputInt();

            int selectedAnimal = -1;
            Animal animal;
            switch (selectedMenu) {
                case (1):
                    System.out.println(stringResources.getString("CREATE_MENU"));

                    selectedMenu = getUserInputInt();

                    String name;
                    float weight;
                    switch (selectedMenu) {
                        case 1:
                            System.out.println(stringResources.getString("ENTER_HERB_NAME"));
                            name = getUserInputString();
                            System.out.println(stringResources.getString("ENTER_HERB_WEIGHT"));
                            weight = getUserInputFloat();

                            try {
                                Herbivore herbivore = new Herbivore(name, weight);
                                forest.create(herbivore);
                            } catch (IllegalWeightException e) {
                                printExceptionMessage(e);
                            }

                            break;
                        case 2:
                            System.out.println(stringResources.getString("ENTER_PRED_NAME"));
                            name = getUserInputString();
                            System.out.println(stringResources.getString("ENTER_PRED_WEIGHT"));
                            weight = getUserInputFloat();

                            try {
                                Predator predator = new Predator(name, weight);
                                forest.create(predator);
                            } catch (IllegalWeightException e) {
                                printExceptionMessage(e);
                            }

                            break;
                        case 3:
                            System.out.println(stringResources.getString("ENTER_GRASS_NAME"));
                            name = getUserInputString();
                            System.out.println(stringResources.getString("ENTER_GRASS_WEIGHT"));
                            weight = getUserInputFloat();

                            try {
                                Grass grass = new Grass(name, weight);
                                forest.create(grass);
                            } catch (IllegalWeightException e) {
                                printExceptionMessage(e);
                            }

                            break;
                        case 0:
                            selectedMenu = -1;
                            break;
                    }

                    break;
                case (2):
                    System.out.println(stringResources.getString("SELECT_ANIMAL_TO_KILL"));
                    printAnimals(forest.getAllLiveAnimals());

                    selectedAnimal = getUserInputInt();

                    try {
                        animal = forest.findAnimalById(selectedAnimal);
                        animal.die();
                        forest.update(animal);

                        System.out.println(animal.getInfo());
                    } catch (NullPointerException
                            | IllegalDeathException
                            | IllegalArgumentException e) {

                        printExceptionMessage(e);
                    }

                    break;
                case (3):
                    System.out.println(stringResources.getString("FEED_MENU"));

                    selectedMenu = getUserInputInt();

                    int selectedFood = -1;
                    Animal eater;
                    switch (selectedMenu) {
                        case 1:
                            System.out.println(stringResources.getString("SELECT_HERB"));
                            printHerbivores(forest.getAllLiveHerbivores());

                            selectedAnimal = getUserInputInt();

                            System.out.println(stringResources.getString("SELECT_GRASS"));
                            printGrasses(forest.getAllGrasses());

                            selectedFood = getUserInputInt();

                            Grass foodGrass;
                            try {
                                eater = forest.findAnimalById(selectedAnimal);
                                foodGrass = forest.findGrassById(selectedFood);

                                eater.eat(foodGrass);

                                forest.update(eater);
                                forest.update(foodGrass);

                                System.out.println(forest.findGrassById(selectedFood).getInfo());
                                System.out.println(forest.findAnimalById(selectedAnimal).getInfo());
                            } catch (NullPointerException
                                    | IllegalArgumentException
                                    | IllegalFoodException
                                    | IllegalFeedingDeadException e) {

                                printExceptionMessage(e);
                            }

                            break;
                        case 2:
                            System.out.println(stringResources.getString("SELECT_PREDATOR"));
                            printPredators(forest.getAllLivePredators());

                            selectedAnimal = getUserInputInt();

                            System.out.println(stringResources.getString("SELECT_HERB"));
                            printHerbivores(forest.getAllLiveHerbivores());

                            selectedFood = getUserInputInt();

                            Herbivore food;
                            try {
                                eater = forest.findAnimalById(selectedAnimal);
                                food = (Herbivore) forest.findAnimalById(selectedFood);

                                eater.eat(food);

                                forest.update(eater);
                                forest.update(food);

                                System.out.println(forest.findAnimalById(selectedFood).getInfo());
                                System.out.println(forest.findAnimalById(selectedAnimal).getInfo());
                            } catch (NullPointerException
                                    | IllegalArgumentException
                                    | IllegalFoodException
                                    | IllegalFeedingDeadException
                                    | IllegalCarrionException e) {

                                printExceptionMessage(e);
                            }

                            break;
                        case 0:
                            selectedMenu = -1;
                            break;
                    }

                    break;
                case 4:
                    printAnimals(forest.getAllAnimals());
                    break;
                case 5:
                    printHerbivores(forest.getAllHerbivores());
                    break;
                case 6:
                    printPredators(forest.getAllPredators());
                    break;
                case 7:
                    printGrasses(forest.getAllGrasses());
                    break;
                case 8:
                    printAnimals(forest.getAllLiveAnimals());
                    break;
                case 9:
                    printHerbivores(forest.getAllLiveHerbivores());
                    break;
                case 10:
                    printPredators(forest.getAllLivePredators());
                    break;
                case 11:
                    System.out.println(stringResources.getString("SELECT_ANIMAL"));
                    selectedAnimal = getUserInputInt();

                    try {
                        animal = forest.findAnimalById(selectedAnimal);

                        System.out.println(animal.getInfo());
                        System.out.println();
                    } catch (NullPointerException e) {
                        printExceptionMessage(e);
                    }

                    break;
                case 12:
                    System.out.println(stringResources.getString("SETTINGS_MENU"));

                    selectedMenu = getUserInputInt();

                    switch (selectedMenu) {
                        case 1:
                            System.out.println(stringResources.getString("LANGUAGE_MENU"));

                            selectedMenu = getUserInputInt();

                            switch (selectedMenu) {
                                case 1:
                                    properties.setProperty("LOCALE", "ru");
                                    saveConfigs();
                                    stringResources = ResourceBundle.getBundle(
                                            "resources.strings",
                                            new Locale(properties.getProperty("LOCALE"))
                                    );
                                    break;
                                case 2:
                                    properties.setProperty("LOCALE", "en");
                                    saveConfigs();
                                    stringResources = ResourceBundle.getBundle(
                                            "resources.strings",
                                            new Locale(properties.getProperty("LOCALE"))
                                    );
                                    break;
                                case 0:
                                    selectedMenu = -1;
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println(stringResources.getString("INITIALIZATION_TYPE_MENU"));

                            selectedMenu = getUserInputInt();

                            switch (selectedMenu) {
                                case 1:
                                    properties.setProperty("INITIALIZATION_TYPE", "0");
                                    saveConfigs();
                                    break;
                                case 2:
                                    properties.setProperty("INITIALIZATION_TYPE", "1");
                                    saveConfigs();
                                    break;
                                case 3:
                                    properties.setProperty("INITIALIZATION_TYPE", "2");
                                    saveConfigs();
                                    break;
                                case 0:
                                    selectedMenu = -1;
                                    break;
                            }
                            break;
                        case 0:
                            selectedMenu = -1;
                            break;
                    }
                    break;
            }
        }

        try {
            Forest.save(repositoryFile);
        } catch (IOException e) {
            printExceptionMessage(e);
        }

        in.close();
    }

    private static void startApp() throws FileNotFoundException {
        try(FileInputStream fis = new FileInputStream(CONFIGS_FILE)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

        iniType = Integer.parseInt(
                properties.getProperty("INITIALIZATION_TYPE")
        );
        repositoryFile = properties.getProperty("REPOSITORY_FILE");

        stringResources = ResourceBundle.getBundle(
                "resources.strings",
                new Locale(properties.getProperty("LOCALE"))
        );

        switch (iniType) {
            case 0:
                Forest.emptyInit();
                break;
            case 1:
                Forest.defaultInit();
                break;
            case 2:
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
    }

    private static void saveConfigs() {
        try(FileOutputStream fos = new FileOutputStream(CONFIGS_FILE)) {
            properties.store(fos, null);
            System.out.println(stringResources.getString("CONFIGS_SAVE"));
        } catch (IOException e) {
            printExceptionMessage(e);
        }
    }

    private static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage() + "\n");
        e.printStackTrace();
    }

    private static int getUserInputInt() {
        int input = -1;

        try {
            String tmp = in.nextLine().trim();
            input = Integer.parseInt(tmp);
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            printExceptionMessage(e);
        }

        return input;
    }

    private static String getUserInputString() {
        return in.nextLine().trim();
    }

    private static float getUserInputFloat() {
        float input = 0.0F;

        try {
            String tmp = in.nextLine().trim();
            input = Float.parseFloat(tmp);
        } catch (StringIndexOutOfBoundsException e) {
            printExceptionMessage(e);
        }

        return input;
    }

    private static void printAnimals(HashMap<Integer, Animal> animals) {
        for (Animal animal : animals.values()) {
            System.out.println(animal.getInfo());
        }
        System.out.println();
    }

    private static void printHerbivores(HashMap<Integer, Herbivore> herbivores) {
        for (Herbivore herbivore : herbivores.values()) {
            System.out.println(herbivore.getInfo());
        }
        System.out.println();
    }

    private static void printPredators(HashMap<Integer, Predator> predators) {
        for (Predator predator : predators.values()) {
            System.out.println(predator.getInfo());
        }
        System.out.println();
    }

    private static void printGrasses(HashMap<Integer, Grass> grasses) {
        for (Grass grass : grasses.values()) {
            System.out.println(grass.getInfo());
        }
        System.out.println();
    }
}
