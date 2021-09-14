package main;

import model.Grass;
import model.Herbivore;
import model.Predator;

public class Main {

    public static void main(String[] args) {

        String world = "World";

        System.out.println("Привет, " + world + "!");

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
    }
}
