package view;

import exceptions.*;
import main.Main;
import model.Animal;
import model.Grass;
import model.Herbivore;
import model.Predator;
import repository.Forest;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.HashMap;

public class MainFrame extends Frame {

    private final String CONFIGS_FILE = FileSystems.getDefault()
            .getPath("src", "resources", "configs.properties").toString();

    private Forest forest;

    // Panels
    private Panel networkPanel,
            configPanel,
            mainPanel;

    // Labels
    // Network Panel
    private Label networkLabel,
            configLabel,
            mainLabel,
    // Config Panel
            languageLabel,
            initializationLabel,
    // Main Panel
            itemTypeLabel,
            itemNameLabel,
            itemWeightLabel,
            selectAnimalToKillLabel,
            selectAnimalToFeedLabel,
            selectFoodLabel,
            selectListLabel,
            selectedListLabel,
            statusLabel;

    // Choices
    // Config Panel
    private Choice languageChoice,
            initializationChoice,
    // Main Panel
            itemTypeChoice,
            listChoice;

    // Buttons
    // Config Panel
    private Button saveConfigButton,
    // Main Panel
            createItemButton,
            killAnimalButton,
            feedAnimalButton;

    // TextFields
    private TextField itemNameTextField,
            itemWeightTextField;

    // Lists
    private List animalToKillList,
            animalToFeedList,
            foodList,
            commonList;

    // TextArea
    private TextArea statusTextArea;

    public MainFrame(String appTitle) {
        // Frame
        super(appTitle);

        forest = Forest.getInstance();

        setLayout(null);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setBackground(Color.RED);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                closeApp();
            }
        });

        setPanels();
        setLabels();
        setChoices();
        setButtons();
        setTextFields();
        setLists();
        setTextArea();

        setVisible(true);
    }

    private void setPanels() {
        // Panels
        networkPanel = new Panel();
        configPanel = new Panel();
        mainPanel = new Panel();

        networkPanel.setLayout(null);
        configPanel.setLayout(null);
        mainPanel.setLayout(null);

        networkPanel.setBounds(0, 0, 320, 360);
        networkPanel.setBackground(Color.CYAN);
        configPanel.setBounds(0, 360, 320, 360);
        configPanel.setBackground(Color.ORANGE);
        mainPanel.setBounds(320, 0, 960, 720);
        mainPanel.setBackground(Color.PINK);

        add(networkPanel);
        add(configPanel);
        add(mainPanel);
    }

    private void setLabels() {
        Font robotoBold = new Font("Roboto", Font.BOLD, 18);

        // Labels
        // Network Panel
        networkLabel = new Label("Network");

        networkLabel.setBounds(16, 46, 288, 24);
        networkLabel.setFont(robotoBold);
        networkLabel.setBackground(Color.LIGHT_GRAY);

        networkPanel.add(networkLabel);

        // Config Panel
        configLabel = new Label("Config");
        languageLabel = new Label("Language");
        initializationLabel = new Label("Initialization Type");

        configLabel.setBounds(16, 16, 288, 24);
        configLabel.setFont(robotoBold);
        configLabel.setBackground(Color.LIGHT_GRAY);
        languageLabel.setBounds(16, 56, 120, 24);
        languageLabel.setBackground(Color.LIGHT_GRAY);
        initializationLabel.setBounds(16, 96, 120, 24);
        initializationLabel.setBackground(Color.LIGHT_GRAY);

        configPanel.add(configLabel);
        configPanel.add(languageLabel);
        configPanel.add(initializationLabel);

        // Main Panel
        mainLabel = new Label("Main");
        itemTypeLabel = new Label("Animal Type");
        itemNameLabel = new Label("Animal Name");
        itemWeightLabel = new Label("Animal Weight");
        selectAnimalToKillLabel = new Label("Select animal to kill");
        selectAnimalToFeedLabel = new Label("Select animal to feed");
        selectFoodLabel = new Label("Select food");
        selectListLabel = new Label("Select list");
        selectedListLabel = new Label("Selected list");
        statusLabel = new Label("Status");

        mainLabel.setBounds(16, 46, 928, 24);
        mainLabel.setFont(robotoBold);
        mainLabel.setBackground(Color.LIGHT_GRAY);
        itemTypeLabel.setBounds(16, 86, 304, 24);
        itemTypeLabel.setBackground(Color.LIGHT_GRAY);
        itemNameLabel.setBounds(336, 86, 304, 24);
        itemNameLabel.setBackground(Color.LIGHT_GRAY);
        itemWeightLabel.setBounds(656, 86, 288, 24);
        itemWeightLabel.setBackground(Color.LIGHT_GRAY);
        selectAnimalToKillLabel.setBounds(16, 166, 304, 24);
        selectAnimalToKillLabel.setBackground(Color.LIGHT_GRAY);
        selectAnimalToFeedLabel.setBounds(336, 166, 304, 24);
        selectAnimalToFeedLabel.setBackground(Color.LIGHT_GRAY);
        selectFoodLabel.setBounds(656, 166, 288, 24);
        selectFoodLabel.setBackground(Color.LIGHT_GRAY);
        selectListLabel.setBounds(16, 446, 304, 24);
        selectListLabel.setBackground(Color.LIGHT_GRAY);
        selectedListLabel.setBounds(336, 446, 304, 24);
        selectedListLabel.setBackground(Color.LIGHT_GRAY);
        statusLabel.setBounds(656, 446, 288, 24);
        statusLabel.setBackground(Color.LIGHT_GRAY);

        mainPanel.add(mainLabel);
        mainPanel.add(itemTypeLabel);
        mainPanel.add(itemNameLabel);
        mainPanel.add(itemWeightLabel);
        mainPanel.add(selectAnimalToKillLabel);
        mainPanel.add(selectAnimalToFeedLabel);
        mainPanel.add(selectFoodLabel);
        mainPanel.add(selectListLabel);
        mainPanel.add(selectedListLabel);
        mainPanel.add(statusLabel);
    }

    private void setChoices() {
        // Choices
        // Config Panel
        languageChoice = new Choice();
        initializationChoice = new Choice();

        languageChoice.setBounds(156, 56, 152, 24);
        initializationChoice.setBounds(156, 96, 152, 24);

        languageChoice.addItem("Russian");
        languageChoice.addItem("English");

        initializationChoice.addItem("Empty Initialization");
        initializationChoice.addItem("Default Initialization");
        initializationChoice.addItem("Initialization From File");

        configPanel.add(languageChoice);
        configPanel.add(initializationChoice);

        // Main Panel
        itemTypeChoice = new Choice();
        listChoice = new Choice();

        itemTypeChoice.setBounds(16, 126, 304, 24);
        listChoice.setBounds(16, 486, 304, 24);

        itemTypeChoice.addItem("Herbivore");
        itemTypeChoice.addItem("Predator");
        itemTypeChoice.addItem("Grass");

        listChoice.addItem("List of all animals");
        listChoice.addItem("List of all herbivores");
        listChoice.addItem("List of all predators");
        listChoice.addItem("List of all grass");
        listChoice.addItem("List all living animals");
        listChoice.addItem("List of all living herbivores");
        listChoice.addItem("List of all living predators");

        listChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadSelectedList();
            }
        });

        mainPanel.add(itemTypeChoice);
        mainPanel.add(listChoice);
    }

    private void setButtons() {
        // Buttons
        // Config Panel
        saveConfigButton = new Button("Save");
        saveConfigButton.setBounds(16, 320, 120, 24);

        saveConfigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveConfig();
            }
        });

        configPanel.add(saveConfigButton);

        // Main Panel
        createItemButton = new Button("Create");
        killAnimalButton = new Button("Kill");
        feedAnimalButton = new Button("Feed");

        createItemButton.setBounds(808, 126, 136, 24);
        killAnimalButton.setBounds(16, 406, 304, 24);
        feedAnimalButton.setBounds(336, 406, 608, 24);

        createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createItem();
            }
        });

        killAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                killAnimal();
            }
        });

        feedAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feedAnimal();
            }
        });

        mainPanel.add(createItemButton);
        mainPanel.add(killAnimalButton);
        mainPanel.add(feedAnimalButton);
    }

    private void setTextFields() {
        // TextFields
        itemNameTextField = new TextField();
        itemWeightTextField = new TextField();

        itemNameTextField.setBounds(336, 126, 304, 24);
        itemWeightTextField.setBounds(656, 126, 136, 24);

        mainPanel.add(itemNameTextField);
        mainPanel.add(itemWeightTextField);
    }

    private void setLists() {
        // Lists
        animalToKillList = new List();
        animalToFeedList = new List();
        foodList = new List();
        commonList = new List();

        animalToKillList.setBounds(16, 206, 304, 184);
        animalToFeedList.setBounds(336, 206, 304, 184);
        foodList.setBounds(656, 206, 288, 184);
        commonList.setBounds(336, 486, 304, 200);

        updateLiveAnimalsLists();

        animalToFeedList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadFoodList();
            }
        });

        mainPanel.add(animalToKillList);
        mainPanel.add(animalToFeedList);
        mainPanel.add(foodList);
        mainPanel.add(commonList);
    }

    private void setTextArea() {
        // TextArea
        statusTextArea = new TextArea();
        statusTextArea.setBounds(656, 486, 288, 200);
        statusTextArea.setEditable(false);
        mainPanel.add(statusTextArea);
    }

    private void closeApp() {
        //dispose();

        try {
            Forest.save(Main.getRepositoryFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }

    private void loadSelectedList() {
        commonList.removeAll();

        int selectedListIndex = listChoice.getSelectedIndex();
        Forest forest = Forest.getInstance();

        HashMap<Integer, Animal> animals;
        HashMap<Integer, Herbivore> herbivores;
        HashMap<Integer, Predator> predators;

        switch (selectedListIndex) {
            case 0:
                animals = forest.getAllAnimals();
                for (Animal animal : animals.values()) {
                    commonList.add(animal.getInfo());
                }
                break;
            case 1:
                herbivores = forest.getAllHerbivores();
                for (Herbivore herbivore : herbivores.values()) {
                    commonList.add(herbivore.getInfo());
                }
                break;
            case 2:
                predators = forest.getAllPredators();
                for (Predator predator : predators.values()) {
                    commonList.add(predator.getInfo());
                }
                break;
            case 3:
                HashMap<Integer, Grass> grasses = forest.getAllGrasses();
                for (Grass grass : grasses.values()) {
                    commonList.add(grass.getInfo());
                }
                break;
            case 4:
                animals = forest.getAllLiveAnimals();
                for (Animal animal : animals.values()) {
                    commonList.add(animal.getInfo());
                }
                break;
            case 5:
                herbivores = forest.getAllLiveHerbivores();
                for (Herbivore herbivore : herbivores.values()) {
                    commonList.add(herbivore.getInfo());
                }
                break;
            case 6:
                predators = forest.getAllLivePredators();
                for (Predator predator : predators.values()) {
                    commonList.add(predator.getInfo());
                }
                break;
        }
    }

    private void saveConfig() {
        int selectedLanguageIndex = languageChoice.getSelectedIndex();
        int selectedInitializationTypeIndex = initializationChoice.getSelectedIndex();

        switch (selectedLanguageIndex) {
            case 0:
                Main.getProperties().setProperty("LOCALE", "ru");
                break;
            case 1:
                Main.getProperties().setProperty("LOCALE", "en");
                break;
        }

        Main.getProperties().setProperty(
                "INITIALIZATION_TYPE",
                String.valueOf(selectedInitializationTypeIndex)
        );

        try(FileOutputStream fos = new FileOutputStream(CONFIGS_FILE)) {
            Main.getProperties().store(fos, null);
            statusTextArea.setText(Main.getStringResources().getString("CONFIGS_SAVE"));
        } catch (IOException e) {
            statusTextArea.setText(e.getMessage());
        }
    }

    private void createItem() {
        int selectedItemIndex = itemTypeChoice.getSelectedIndex();

        String name = itemNameTextField.getText();
        float weight = Float.parseFloat(itemWeightTextField.getText());

        try {
            switch (selectedItemIndex) {
                case 0:
                    Herbivore herbivore = new Herbivore(name, weight);
                    forest.create(herbivore);
                    break;
                case 1:
                    Predator predator = new Predator(name, weight);
                    forest.create(predator);
                    break;
                case 2:
                    Grass grass = new Grass(name, weight);
                    forest.create(grass);
                    break;
            }
        } catch (IllegalWeightException e) {
            statusTextArea.setText(e.getMessage());
        }

        updateLiveAnimalsLists();
    }

    private void killAnimal() {
        int selectedAnimalIndex = animalToKillList.getSelectedIndex();
        java.util.List<Animal> animalsList = forest.getAllLiveAnimals().values().stream().toList();
        Animal selectedAnimal = animalsList.get(selectedAnimalIndex);

        try {
            selectedAnimal.die();
            forest.update(selectedAnimal);

            statusTextArea.setText(selectedAnimal.getInfo());
        } catch (NullPointerException
                | IllegalDeathException
                | IllegalArgumentException e) {

            statusTextArea.setText(e.getMessage());
        }

        updateLiveAnimalsLists();
    }

    private void feedAnimal() {
        int selectedAnimalIndex = animalToFeedList.getSelectedIndex();
        java.util.List<Animal> animalsList = forest.getAllLiveAnimals().values().stream().toList();
        Animal selectedAnimal = animalsList.get(selectedAnimalIndex);

        if (selectedAnimal instanceof Herbivore herbivore) {
            int selectedFoodIndex = foodList.getSelectedIndex();
            java.util.List<Grass> grassesList = forest.getAllGrasses().values().stream().toList();
            Grass food = grassesList.get(selectedFoodIndex);

            try {
                herbivore.eat(food);

                forest.update(herbivore);
                forest.update(food);

                statusTextArea.setText(
                        food.getInfo() +
                                "\n" +
                                herbivore.getInfo()
                );
            } catch (NullPointerException
                    | IllegalArgumentException
                    | IllegalFoodException
                    | IllegalFeedingDeadException e) {

                statusTextArea.setText(e.getMessage());
            }
        } else if (selectedAnimal instanceof Predator predator) {
            int selectedFoodIndex = foodList.getSelectedIndex();
            java.util.List<Herbivore> herbivoresList = forest.getAllLiveHerbivores().values().stream().toList();
            Herbivore food = herbivoresList.get(selectedFoodIndex);

            try {
                predator.eat(food);

                forest.update(predator);
                forest.update(food);

                statusTextArea.setText(
                        food.getInfo() +
                                "\n" +
                                predator.getInfo()
                );
            } catch (NullPointerException
                    | IllegalArgumentException
                    | IllegalFoodException
                    | IllegalFeedingDeadException e) {

                statusTextArea.setText(e.getMessage());
            }
        }

        updateLiveAnimalsLists();
        foodList.removeAll();
    }

    private void loadFoodList() {
        foodList.removeAll();

        int selectedAnimalIndex = animalToFeedList.getSelectedIndex();

        java.util.List<Animal> animalsList = forest.getAllLiveAnimals().values().stream().toList();
        Animal animal = animalsList.get(selectedAnimalIndex);

        if (animal instanceof Herbivore) {
            HashMap<Integer, Grass> grasses = forest.getAllGrasses();
            for (Grass grass : grasses.values()) {
                foodList.add(grass.getInfo());
            }
        } else if (animal instanceof Predator) {
            HashMap<Integer, Herbivore> herbivores = forest.getAllLiveHerbivores();
            for (Herbivore herbivore : herbivores.values()) {
                foodList.add(herbivore.getInfo());
            }
        }
    }

    private void updateLiveAnimalsLists() {
        animalToKillList.removeAll();
        animalToFeedList.removeAll();
        commonList.removeAll();

        HashMap<Integer, Animal> animals = forest.getAllLiveAnimals();

        for (Animal animal : animals.values()) {
            animalToKillList.add(animal.getInfo());
            animalToFeedList.add(animal.getInfo());
        }
    }
}
