package main;

import exceptions.IllegalCarrionException;
import exceptions.IllegalDeathException;
import exceptions.IllegalFeedingDeadException;
import exceptions.IllegalFoodException;
import model.Animal;
import model.Grass;
import model.Herbivore;
import model.Predator;
import repository.Forest;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Forest forest = new Forest();

        Grass grass = new Grass("Свежая трава", 250.0F);
        Grass grass2 = new Grass("Зеленая трава", 250.0F);
        Grass grass3 = new Grass("Вкусная трава", 250.0F);
        Grass grass4 = new Grass("Высокая трава", 250.0F);

        forest.create(grass);
        forest.create(grass2);
        forest.create(grass3);
        forest.create(grass4);

        Herbivore beaver = new Herbivore("Бобр", 30.0F);
        Herbivore rabbit = new Herbivore("Кролик", 2.0F);
        Herbivore horse = new Herbivore("Лошадь", 500.0F);
        Herbivore deer = new Herbivore("Олень", 400.0F);

        forest.create(beaver);
        forest.create(rabbit);
        forest.create(horse);
        forest.create(deer);

        Predator wolf = new Predator("Волк", 60.0F);
        Predator bear = new Predator("Медведь", 200.0F);

        forest.create(wolf);
        forest.create(bear);

        System.out.println("Привет, Java Animal World!");

        int selectedMenu = -1;

        while (selectedMenu != 0) {
            System.out.println("1 - Создать новое животное" +
                    "\n2 - Убить какое-либо животное" +
                    "\n3 - Покормить какое-либо животное" +
                    "\n0 - Завершить");

            selectedMenu = getUserInputInt();

            int selectedAnimal = -1;
            switch (selectedMenu) {
                case (1):
                    System.out.println("1 - Создать травоядное" +
                            "\n2 - Создать хищника" +
                            "\n0 - Завершить");

                    selectedMenu = getUserInputInt();

                    String name;
                    float weight;
                    switch (selectedMenu) {
                        case 1:
                            System.out.println("Следует ввести имя травоядного: ");
                            name = getUserInputString();
                            System.out.println("Следует ввести массу травоядного: ");
                            weight = getUserInputFloat();

                            Herbivore herbivore = new Herbivore(name, weight);
                            forest.create(herbivore);

                            break;
                        case 2:
                            System.out.println("Следует ввести имя хищника: ");
                            name = getUserInputString();
                            System.out.println("Следует ввести массу хищника: ");
                            weight = getUserInputFloat();

                            Predator predator = new Predator(name, weight);
                            forest.create(predator);

                            break;
                    }

                    break;
                case (2):
                    System.out.println("Следует выбрать жертву по идентификатору!");
                    printAnimals(forest.getAllLiveAnimals());

                    selectedAnimal = getUserInputInt();
                    Animal animal = forest.findAnimalById(selectedAnimal);

                    try {
                        animal.die();
                        forest.update(animal);
                    } catch (IllegalDeathException e) {
                        printExceptionMessage(e);
                    }

                    break;
                case (3):
                    System.out.println("1 - Покормить травоядное" +
                            "\n2 - Покормить хищника" +
                            "\n0 - Завершить");

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

                            eater = forest.findAnimalById(selectedAnimal);
                            Grass foodGrass = forest.findGrassById(selectedFood);

                            try {
                                eater.eat(foodGrass);
                                forest.update(eater);
                                forest.update(foodGrass);
                            } catch (IllegalFoodException | IllegalFeedingDeadException e) {
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

                            eater = forest.findAnimalById(selectedAnimal);
                            Herbivore food = (Herbivore) forest.findAnimalById(selectedFood);

                            try {
                                eater.eat(food);
                                forest.update(eater);
                                forest.update(food);
                            } catch (IllegalFoodException | IllegalFeedingDeadException | IllegalCarrionException e) {
                                printExceptionMessage(e);
                            }

                            break;
                    }

                    break;
            }
        }

        in.close();
    }

    private static void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }

    private static int getUserInputInt() {
        int input = -1;

        try {
            String tmp = in.nextLine().trim().substring(0, 1);
            input = Integer.parseInt(tmp);
        } catch (StringIndexOutOfBoundsException e) {
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
    }

    private static void printHerbivores(HashMap<Integer, Herbivore> herbivores) {
        for (Herbivore herbivore : herbivores.values()) {
            System.out.println(herbivore.getInfo());
        }
    }

    private static void printPredators(HashMap<Integer, Predator> predators) {
        for (Predator predator : predators.values()) {
            System.out.println(predator.getInfo());
        }
    }

    private static void printGrasses(HashMap<Integer, Grass> grasses) {
        for (Grass grass : grasses.values()) {
            System.out.println(grass.getInfo());
        }
    }
}
