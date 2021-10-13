package repository;

import model.Animal;
import model.Grass;
import model.Herbivore;
import model.Predator;

import java.util.HashMap;

public class Forest {

    private HashMap<Integer, Grass> grasses = new HashMap<>();
    private HashMap<Integer, Herbivore> herbivores = new HashMap<>();
    private HashMap<Integer, Predator> predators = new HashMap<>();

    private int idCounter = 0;

    public void create(Grass grass) {
        idCounter++;
        grass.setId(idCounter);

        grasses.put(idCounter, grass);
    }

    public void create(Animal animal) {
        idCounter++;
        animal.setId(idCounter);

        if (animal instanceof Herbivore herbivore) {
            herbivores.put(idCounter, herbivore);
        } else {
            Predator predator = (Predator) animal;
            predators.put(idCounter, predator);
        }
    }

    public void update(Grass grass) {
        grasses.replace(grass.getId(), grass);
    }

    public void update(Animal animal) {
        if (animal instanceof Herbivore herbivore) {
            herbivores.replace(herbivore.getId(), herbivore);
        } else {
            Predator predator = (Predator) animal;
            predators.replace(predator.getId(), predator);
        }
    }

    public Animal findAnimalById(int id) {
        Animal animal = herbivores.get(id);

        if (animal == null) {
            animal = predators.get(id);
        }

        return animal; // Метод вернет значение null, если значения с переданным ключом нет
    }

    public Grass findGrassById(int id) {
        return grasses.get(id); // Метод вернет значение null, если значения с переданным ключом нет
    }

    public HashMap<Integer, Grass> getAllGrasses() {
        return grasses;
    }

    public HashMap<Integer, Animal> getAllAnimals() {
        HashMap<Integer, Animal> animals = new HashMap<>();

        for (Herbivore herbivore : herbivores.values()) {
            animals.put(herbivore.getId(), herbivore);
        }
        for (Predator predator : predators.values()) {
            animals.put(predator.getId(), predator);
        }

        return animals;
    }

    public HashMap<Integer, Predator> getAllPredators() {
        return predators;
    }

    public HashMap<Integer, Herbivore> getAllHerbivores() {
        return herbivores;
    }

    public HashMap<Integer, Animal> getAllLiveAnimals() {
        HashMap<Integer, Animal> animals = new HashMap<>();

        for (Herbivore herbivore : herbivores.values()) {
            if (herbivore.isAlive()) {
                animals.put(herbivore.getId(), herbivore);
            }
        }
        for (Predator predator : predators.values()) {
            if (predator.isAlive()) {
                animals.put(predator.getId(), predator);
            }
        }

        return animals;
    }

    public HashMap<Integer, Predator> getAllLivePredators() {
        HashMap<Integer, Predator> livePredators = new HashMap<>();

        for (Predator predator : predators.values()) {
            if (predator.isAlive()) {
                livePredators.put(predator.getId(), predator);
            }
        }

        return livePredators;
    }

    public HashMap<Integer, Herbivore> getAllLiveHerbivores() {
        HashMap<Integer, Herbivore> liveHerbivore = new HashMap<>();

        for (Herbivore herbivore : herbivores.values()) {
            if (herbivore.isAlive()) {
                liveHerbivore.put(herbivore.getId(), herbivore);
            }
        }

        return liveHerbivore;
    }
}
