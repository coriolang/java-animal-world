package view;

import java.awt.*;
import java.util.ResourceBundle;

public class MainView {

    private ResourceBundle stringResources;

    // Frame
    private Frame frame;

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
            animalTypeLabel,
            animalNameLabel,
            animalWeightLabel,
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
            animalTypeChoice,
            listChoice;

    // Buttons
    // Config Panel
    private Button saveConfigButton,
    // Main Panel
            createAnimalButton,
            killAnimalButton,
            feedAnimalButton;

    // TextFields
    private TextField animalNameTextField,
            animalWeightTextField;

    // Lists
    private List animalToKillList,
            animalToFeedList,
            foodList,
            commonList;

    // TextArea
    private TextArea statusTextArea;

    public MainView(ResourceBundle stringResources) {
        this.stringResources = stringResources;

        // Frame
        frame = new Frame(this.stringResources.getString("APPLICATION_TITLE"));

        frame.setLayout(null);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.RED);

        setupPanels();
        setupLabels();
        setupChoices();
        setupButtons();
        setupTextFields();
        setupLists();
        setupTextArea();

        frame.setVisible(true);
    }

    private void setupPanels() {
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

        frame.add(networkPanel);
        frame.add(configPanel);
        frame.add(mainPanel);
    }

    private void setupLabels() {
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
        animalTypeLabel = new Label("Animal Type");
        animalNameLabel = new Label("Animal Name");
        animalWeightLabel = new Label("Animal Weight");
        selectAnimalToKillLabel = new Label("Select animal to kill");
        selectAnimalToFeedLabel = new Label("Select animal to feed");
        selectFoodLabel = new Label("Select food");
        selectListLabel = new Label("Select list");
        selectedListLabel = new Label("Selected list");
        statusLabel = new Label("Status");

        mainLabel.setBounds(16, 46, 928, 24);
        mainLabel.setFont(robotoBold);
        mainLabel.setBackground(Color.LIGHT_GRAY);
        animalTypeLabel.setBounds(16, 86, 304, 24);
        animalTypeLabel.setBackground(Color.LIGHT_GRAY);
        animalNameLabel.setBounds(336, 86, 304, 24);
        animalNameLabel.setBackground(Color.LIGHT_GRAY);
        animalWeightLabel.setBounds(656, 86, 288, 24);
        animalWeightLabel.setBackground(Color.LIGHT_GRAY);
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
        mainPanel.add(animalTypeLabel);
        mainPanel.add(animalNameLabel);
        mainPanel.add(animalWeightLabel);
        mainPanel.add(selectAnimalToKillLabel);
        mainPanel.add(selectAnimalToFeedLabel);
        mainPanel.add(selectFoodLabel);
        mainPanel.add(selectListLabel);
        mainPanel.add(selectedListLabel);
        mainPanel.add(statusLabel);
    }

    private void setupChoices() {
        // Choices
        // Config Panel
        languageChoice = new Choice();
        initializationChoice = new Choice();

        languageChoice.setBounds(156, 56, 152, 24);
        initializationChoice.setBounds(156, 96, 152, 24);

        configPanel.add(languageChoice);
        configPanel.add(initializationChoice);

        // Main Panel
        animalTypeChoice = new Choice();
        listChoice = new Choice();

        animalTypeChoice.setBounds(16, 126, 304, 24);
        listChoice.setBounds(16, 486, 304, 24);

        mainPanel.add(animalTypeChoice);
        mainPanel.add(listChoice);
    }

    private void setupButtons() {
        // Buttons
        // Config Panel
        saveConfigButton = new Button("Save");
        saveConfigButton.setBounds(16, 320, 120, 24);
        configPanel.add(saveConfigButton);

        // Main Panel
        createAnimalButton = new Button("Create");
        killAnimalButton = new Button("Kill");
        feedAnimalButton = new Button("Feed");

        createAnimalButton.setBounds(808, 126, 136, 24);
        killAnimalButton.setBounds(16, 406, 304, 24);
        feedAnimalButton.setBounds(336, 406, 608, 24);

        mainPanel.add(createAnimalButton);
        mainPanel.add(killAnimalButton);
        mainPanel.add(feedAnimalButton);
    }

    private void setupTextFields() {
        // TextFields
        animalNameTextField = new TextField();
        animalWeightTextField = new TextField();

        animalNameTextField.setBounds(336, 126, 304, 24);
        animalWeightTextField.setBounds(656, 126, 136, 24);

        mainPanel.add(animalNameTextField);
        mainPanel.add(animalWeightTextField);
    }

    private void setupLists() {
        // Lists
        animalToKillList = new List();
        animalToFeedList = new List();
        foodList = new List();
        commonList = new List();

        animalToKillList.setBounds(16, 206, 304, 184);
        animalToFeedList.setBounds(336, 206, 304, 184);
        foodList.setBounds(656, 206, 288, 184);
        commonList.setBounds(336, 486, 304, 200);

        mainPanel.add(animalToKillList);
        mainPanel.add(animalToFeedList);
        mainPanel.add(foodList);
        mainPanel.add(commonList);
    }

    private void setupTextArea() {
        // TextArea
        statusTextArea = new TextArea();
        statusTextArea.setBounds(656, 486, 288, 200);
        mainPanel.add(statusTextArea);
    }
}
