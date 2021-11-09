package repository;

import model.Animal;
import model.Grass;
import model.Herbivore;
import model.Predator;

import java.io.*;
import java.util.HashMap;

public class Forest implements Serializable {

    private static Forest forest = null;

    private HashMap<Integer, Grass> grasses = new HashMap<>();
    private HashMap<Integer, Herbivore> herbivores = new HashMap<>();
    private HashMap<Integer, Predator> predators = new HashMap<>();

    private int idCounter = 0;

    private static final String REPOSITORY_FILE = "forest.dat";

    private Forest() {
        if (!new File(REPOSITORY_FILE).exists()) {
            create(new Grass("Свежая трава", 250.0F));
            create(new Grass("Зеленая трава", 250.0F));
            create(new Grass("Вкусная трава", 250.0F));
            create(new Grass("Высокая трава", 250.0F));

            create(new Herbivore("Бобр", 30.0F));
            create(new Herbivore("Кролик", 2.0F));
            create(new Herbivore("Лошадь", 500.0F));
            create(new Herbivore("Олень", 400.0F));

            create(new Predator("Волк", 60.0F));
            create(new Predator("Медведь", 200.0F));
        }
    }

    public static Forest getInstance() {
        if (forest == null) {
            forest = new Forest();
        }

        return forest;
    }

    public void create(Grass grass) {
        idCounter++;
        grass.setId(idCounter);
        putGrass(grass);
    }

    public void create(Animal animal) {
        idCounter++;
        animal.setId(idCounter);
        putAnimal(animal);
    }

    private void putGrass(Grass grass) {
        grasses.put(grass.getId(), grass);
    }

    private void putAnimal(Animal animal) {
        if (animal instanceof Herbivore herbivore) {
            herbivores.put(herbivore.getId(), herbivore);
        } else {
            Predator predator = (Predator) animal;
            predators.put(predator.getId(), predator);
        }
    }

    public void update(Grass grass) throws IllegalArgumentException {
        if (!grasses.containsValue(grass)) {
            throw new IllegalArgumentException("В лесу нет нужной травы для обновления!");
        }

        grasses.replace(grass.getId(), grass);
    }

    public void update(Animal animal) throws IllegalArgumentException {
        if (animal instanceof Herbivore herbivore) {
            if (!herbivores.containsValue(herbivore)) {
                throw new IllegalArgumentException("В лесу нет нужного травоядного для обновления!");
            }

            herbivores.replace(herbivore.getId(), herbivore);
        } else {
            Predator predator = (Predator) animal;

            if (!predators.containsValue(predator)) {
                throw new IllegalArgumentException("В лесу нет нужного хищника для обновления!");
            }

            predators.replace(predator.getId(), predator);
        }
    }

    public Animal findAnimalById(int id) {
        Animal animal = herbivores.get(id);
        if (animal != null)
            return animal;

        animal = predators.get(id);
        if (animal != null)
            return animal;

        return null; // Метод вернет значение null, если значения с переданным ключом нет
    }

    public Grass findGrassById(int id) {
        return grasses.get(id); // Метод вернет значение null, если значения с переданным ключом нет
    }

    public HashMap<Integer, Grass> getAllGrasses() {
        return grasses;
    }

    public HashMap<Integer, Animal> getAllAnimals() {
        HashMap<Integer, Animal> animals = new HashMap<>();

        animals.putAll(herbivores);
        animals.putAll(predators);

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

    public static void save() throws IOException {
        try(ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE))) {

            outputStream.writeObject(forest);
        } catch(IOException e) {
            throw e;
        }
    }

    public static void load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream(REPOSITORY_FILE))) {

            forest = (Forest) inputStream.readObject();
        } catch(ClassNotFoundException
                | IOException e) {

            throw e;
        }
    }
}
