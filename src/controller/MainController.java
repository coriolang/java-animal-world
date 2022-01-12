package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import repository.Forest;

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
    public static String repositoryFile;

    public static final int EMPTY_INIT_MODE = 0;
    public static final int DEFAULT_INIT_MODE = 1;
    public static final int FILE_INIT_MODE = 2;

    public static ResourceBundle stringResources;

    private static Forest forest;

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

    public static String create(int type, String name, float weight) throws IOException {
        String creationStatus = NetworkController
                .request("create&" + type + "&" + name + "&" + weight);
        return creationStatus;
    }

    public static String kill(int animalId) throws IOException {
        String murderStatus = NetworkController
                .request("kill&" + animalId);
        return murderStatus;
    }

    public static String feed(int animalId, int foodId) throws IOException {
        String feedingStatus = NetworkController
                .request("feed&" + animalId + "&" + foodId);
        return feedingStatus;
    }

    public static HashMap<Integer, String> getAllAnimals() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allAnimals");
        HashMap<Integer, String> animals = gson.fromJson(json, hashMapType);

        return animals;
    }

    public static HashMap<Integer, String> getAllHerbivores() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allHerbivores");
        HashMap<Integer, String> herbivores = gson.fromJson(json, hashMapType);

        return herbivores;
    }

    public static HashMap<Integer, String> getAllPredators() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allPredators");
        HashMap<Integer, String> predators = gson.fromJson(json, hashMapType);

        return predators;
    }

    public static HashMap<Integer, String> getAllGrasses() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&allGrasses");
        HashMap<Integer, String> grasses = gson.fromJson(json, hashMapType);

        return grasses;
    }

    public static HashMap<Integer, String> getLiveAnimals() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&liveAnimals");
        HashMap<Integer, String> liveAnimals = gson.fromJson(json, hashMapType);

        return liveAnimals;
    }

    public static HashMap<Integer, String> getLiveHerbivores() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&liveHerbivores");
        HashMap<Integer, String> liveHerbivores = gson.fromJson(json, hashMapType);

        return liveHerbivores;
    }

    public static HashMap<Integer, String> getLivePredators() throws IOException {
        Gson gson = new Gson();
        String json = NetworkController.request("get&livePredators");
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
}
