package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.util.*;

public class MainController {

    private static final String CONFIGS_FILE = FileSystems.getDefault()
            .getPath("src", "resources", "configs.properties").toString();

    private static Properties properties;
    public static ResourceBundle stringResources;

    private static Type hashMapType = new TypeToken<HashMap<Integer, String>>() {}.getType();

    private static HashMap<Integer, String> animalToKill = new HashMap<>();
    private static HashMap<Integer, String> animalToFeed = new HashMap<>();
    private static HashMap<Integer, String> foods = new HashMap<>();

    public static void startApp() throws FileNotFoundException {
        try(FileInputStream fis = new FileInputStream(CONFIGS_FILE)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

        stringResources = ResourceBundle.getBundle(
                "resources.strings",
                new Locale(properties.getProperty("LOCALE"))
        );
    }

    public static void closeApp() throws IOException {
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

    public static String create(int type, String name, float weight) throws IOException {
        String creationStatus = NetworkController
                .request("create&" + type + "&" + name + "&" + weight
                        + "&" + properties.getProperty("LOCALE"));
        return creationStatus;
    }

    public static String kill(int animalId) throws IOException {
        String murderStatus = NetworkController
                .request("kill&" + animalId
                        + "&" + properties.getProperty("LOCALE"));
        return murderStatus;
    }

    public static String feed(int animalId, int foodId) throws IOException {
        String feedingStatus = NetworkController
                .request("feed&" + animalId + "&" + foodId
                        + "&" + properties.getProperty("LOCALE"));
        return feedingStatus;
    }

    public static HashMap<Integer, String> getAllAnimals() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allAnimals"
                + "&" + properties.getProperty("LOCALE"));
        HashMap<Integer, String> animals = gson.fromJson(json, hashMapType);

        return animals;
    }

    public static HashMap<Integer, String> getAllHerbivores() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allHerbivores"
                + "&" + properties.getProperty("LOCALE"));
        HashMap<Integer, String> herbivores = gson.fromJson(json, hashMapType);

        return herbivores;
    }

    public static HashMap<Integer, String> getAllPredators() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allPredators"
                + "&" + properties.getProperty("LOCALE"));
        HashMap<Integer, String> predators = gson.fromJson(json, hashMapType);

        return predators;
    }

    public static HashMap<Integer, String> getAllGrasses() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allGrasses"
                + "&" + properties.getProperty("LOCALE"));
        HashMap<Integer, String> grasses = gson.fromJson(json, hashMapType);

        return grasses;
    }

    public static HashMap<Integer, String> getLiveAnimals() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&liveAnimals"
                + "&" + properties.getProperty("LOCALE"));
        HashMap<Integer, String> liveAnimals = gson.fromJson(json, hashMapType);

        return liveAnimals;
    }

    public static HashMap<Integer, String> getLiveHerbivores() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&liveHerbivores"
                + "&" + properties.getProperty("LOCALE"));
        HashMap<Integer, String> liveHerbivores = gson.fromJson(json, hashMapType);

        return liveHerbivores;
    }

    public static HashMap<Integer, String> getLivePredators() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&livePredators"
                + "&" + properties.getProperty("LOCALE"));
        HashMap<Integer, String> livePredators = gson.fromJson(json, hashMapType);

        return livePredators;
    }

    public static HashMap<Integer, String> getAnimalToKillHashMap() {
        return animalToKill;
    }

    public static void setAnimalToKillHashMap(HashMap<Integer, String> animalToKill) {
        MainController.animalToKill = animalToKill;
    }

    public static HashMap<Integer, String> getAnimalToFeedHashMap() {
        return animalToFeed;
    }

    public static void setAnimalToFeedHashMap(HashMap<Integer, String> animalToFeed) {
        MainController.animalToFeed = animalToFeed;
    }

    public static HashMap<Integer, String> getFoodsHashMap() {
        return foods;
    }

    public static void setFoodsHashMap(HashMap<Integer, String> foods) {
        MainController.foods = foods;
    }

    public static int getInterfaceMode() {
        return Integer.parseInt(properties.getProperty("INTERFACE_MODE"));
    }
}
