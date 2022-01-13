package storage;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Storage {

    private static Type hashMapType = new TypeToken<HashMap<Integer, String>>() {}.getType();

    private static HashMap<Integer, String> animalToKill = new HashMap<>();
    private static HashMap<Integer, String> animalToFeed = new HashMap<>();
    private static HashMap<Integer, String> foods = new HashMap<>();

    public static Type getHashMapType() {
        return hashMapType;
    }

    public static HashMap<Integer, String> getAnimalToKill() {
        return animalToKill;
    }

    public static void setAnimalToKill(HashMap<Integer, String> animalToKill) {
        Storage.animalToKill = animalToKill;
    }

    public static HashMap<Integer, String> getAnimalToFeed() {
        return animalToFeed;
    }

    public static void setAnimalToFeed(HashMap<Integer, String> animalToFeed) {
        Storage.animalToFeed = animalToFeed;
    }

    public static HashMap<Integer, String> getFoods() {
        return foods;
    }

    public static void setFoods(HashMap<Integer, String> foods) {
        Storage.foods = foods;
    }
}
