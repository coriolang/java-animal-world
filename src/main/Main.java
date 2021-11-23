package main;

import exceptions.*;
import model.Animal;
import model.Grass;
import model.Herbivore;
import model.Predator;
import repository.Forest;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static ResourceBundle settings;

    public static void main(String[] args) {
        startApp();

        Forest forest = Forest.getInstance();

        System.out.println("Привет, Java Animal World!");

        int selectedMenu = -1;

        while (selectedMenu != 0) {
            System.out.println("\n1 - Создать" +
                    "\n2 - Убить какое-либо животное" +
                    "\n3 - Покормить какое-либо животное" +
                    "\n4 - Список всех животных" +
                    "\n5 - Список всех травоядных" +
                    "\n6 - Список всех хищников" +
                    "\n7 - Список всей травы" +
                    "\n8 - Список всех живых животных" +
                    "\n9 - Список всех живых травоядных" +
                    "\n10 - Список всех живых хищников" +
                    "\n11 - Информация о выбранном животном" +
                    "\n0 - Завершить");

            selectedMenu = getUserInputInt();

            int selectedAnimal = -1;
            Animal animal;
            switch (selectedMenu) {
                case (1):
                    System.out.println("\n1 - Создать травоядное" +
                            "\n2 - Создать хищника" +
                            "\n3 - Создать траву" +
                            "\n0 - Назад");

                    selectedMenu = getUserInputInt();

                    String name;
                    float weight;
                    switch (selectedMenu) {
                        case 1:
                            System.out.println("Следует ввести имя травоядного: ");
                            name = getUserInputString();
                            System.out.println("Следует ввести массу травоядного: ");
                            weight = getUserInputFloat();

                            try {
                                Herbivore herbivore = new Herbivore(name, weight);
                                forest.create(herbivore);
                            } catch (IllegalWeightException e) {
                                printExceptionMessage(e);
                            }

                            break;
                        case 2:
                            System.out.println("Следует ввести имя хищника: ");
                            name = getUserInputString();
                            System.out.println("Следует ввести массу хищника: ");
                            weight = getUserInputFloat();

                            try {
                                Predator predator = new Predator(name, weight);
                                forest.create(predator);
                            } catch (IllegalWeightException e) {
                                printExceptionMessage(e);
                            }

                            break;
                        case 3:
                            System.out.println("Следует ввести название травы: ");
                            name = getUserInputString();
                            System.out.println("Следует ввести массу травы: ");
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
                    System.out.println("Следует выбрать жертву по идентификатору!");
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
                    System.out.println("\n1 - Покормить травоядное" +
                            "\n2 - Покормить хищника" +
                            "\n0 - Назад");

                    selectedMenu = getUserInputInt();

                    int selectedFood = -1;
                    Animal eater;
                    switch (selectedMenu) {
                        case 1:
                            System.out.println("Следует выбрать животное по идентификатору!");
                            printHerbivores(forest.getAllLiveHerbivores());

                            selectedAnimal = getUserInputInt();

                            System.out.println("Теперь нужно выбрать еду по идентификатору!");
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
                            System.out.println("Следует выбрать хищника по идентификатору!");
                            printPredators(forest.getAllLivePredators());

                            selectedAnimal = getUserInputInt();

                            System.out.println("Теперь нужно выбрать еду по идентификатору!");
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
                    System.out.println("Следует ввести идентификатор животного!");
                    selectedAnimal = getUserInputInt();

                    try {
                        animal = forest.findAnimalById(selectedAnimal);

                        System.out.println(animal.getInfo());
                        System.out.println();
                    } catch (NullPointerException e) {
                        printExceptionMessage(e);
                    }

                    break;
            }
        }

        try {
            Forest.save(settings.getString("REPOSITORY_FILE"));
        } catch (IOException e) {
            printExceptionMessage(e);
        }

        in.close();
    }

    private static void startApp() {
        settings = ResourceBundle.getBundle("Settings");

        boolean defaultInitialization = settings.getString("DEFAULT_INITIALIZATION").equals("true");

        if (!defaultInitialization) {
            try {
                Forest.load(settings.getString("REPOSITORY_FILE"));
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            Forest.defaultInit();
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
