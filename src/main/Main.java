package main;

import exceptions.*;
import model.Grass;
import model.Herbivore;
import model.Predator;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Привет, Java Animal World!");

            Predator fox = new Predator(1, "Fox", 6.5F);
            Predator wolf = new Predator(2, "Wolf", 12.0F);
            Herbivore rabbit = new Herbivore(3, "Rabbit", 2.0F);
            Herbivore deer = new Herbivore(4, "Deer", 12.0F);
            Grass grass = new Grass(5, "Grass", 200.0F);

            System.out.println(fox.getInfo());
            System.out.println(wolf.getInfo());
            System.out.println(rabbit.getInfo());
            System.out.println(deer.getInfo());
            System.out.println(grass.getInfo());

            rabbit.eat(grass);
            System.out.println("\n" + rabbit.getInfo());
            System.out.println(grass.getInfo());

            wolf.eat(deer);
            System.out.println("\n" + wolf.getInfo());
            System.out.println(deer.getInfo());

            fox.eat(rabbit);
            System.out.println("\n" + fox.getInfo());
            System.out.println(rabbit.getInfo());
        } catch (IllegalCarrionException
                | IllegalDeathException
                | IllegalFeedingDeadException
                | IllegalFoodException
                | IllegalWeightException e) {

            printExceptionMessage(e);
        }

        try {
            Predator wolf = new Predator(6, "Wolf", -12.0F);
            Herbivore rabbit = new Herbivore(7, "Rabbit", 2.0F);
            wolf.eat(rabbit);
        } catch (IllegalWeightException e) { // Масса не может быть отрицательной
            printExceptionMessage(e);
        }

        try {
            Predator fox = new Predator(8, "Fox", 6.0F);
            fox.die();
            fox.die();
        } catch (IllegalDeathException e) { // Нельзя убить мертвое
            printExceptionMessage(e);
        }

        try {
            Herbivore rabbit = new Herbivore(9, "Rabbit", 2.0F);
            Grass grass = new Grass(10, "Grass", 50.0F);
            rabbit.die();
            rabbit.eat(grass);
        } catch (IllegalFeedingDeadException e) { // Нельзя кормить мертвое
            printExceptionMessage(e);
        }

        try {
            Predator fox = new Predator(11, "Fox", 6.0F);
            Grass grass = new Grass(12, "Grass", 50.0F);
            fox.eat(grass);
        } catch (IllegalFoodException e) { // Нельзя кормить не своей едой
            printExceptionMessage(e);
        }

        try {
            Predator fox = new Predator(13, "Fox", 6.0F);
            Herbivore rabbit = new Herbivore(14, "Rabbit", 2.0F);
            rabbit.die();
            fox.eat(rabbit);
        } catch (IllegalCarrionException e) { // Хищник не ест падаль
            printExceptionMessage(e);
        }
    }

    private static void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
