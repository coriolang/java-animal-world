package view;

import main.Main;
import controller.listeners.*;

import java.awt.*;

public class MainFrame extends Frame {

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
    // Main Panel
            itemTypeChoice,
            listChoice;

    // Buttons
    // Config Panel
    private Button applyConfigButton,
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

        setLayout(null);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setBackground(Color.RED);

        addWindowListener(new CloseWindowListener());

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
        networkLabel = new Label(Main.getStringResources().getString("NETWORK_LABEL"));

        networkLabel.setBounds(16, 46, 288, 24);
        networkLabel.setFont(robotoBold);
        networkLabel.setBackground(Color.LIGHT_GRAY);

        networkPanel.add(networkLabel);

        // Config Panel
        configLabel = new Label(Main.getStringResources().getString("CONFIG_LABEL"));
        languageLabel = new Label(Main.getStringResources().getString("LANGUAGE_LABEL"));

        configLabel.setBounds(16, 16, 288, 24);
        configLabel.setFont(robotoBold);
        configLabel.setBackground(Color.LIGHT_GRAY);
        languageLabel.setBounds(16, 56, 120, 24);
        languageLabel.setBackground(Color.LIGHT_GRAY);

        configPanel.add(configLabel);
        configPanel.add(languageLabel);

        // Main Panel
        mainLabel = new Label(Main.getStringResources().getString("MAIN_LABEL"));
        itemTypeLabel = new Label(Main.getStringResources().getString("ITEM_TYPE_LABEL"));
        itemNameLabel = new Label(Main.getStringResources().getString("ITEM_NAME_LABEL"));
        itemWeightLabel = new Label(Main.getStringResources().getString("ITEM_WEIGHT_LABEL"));
        selectAnimalToKillLabel = new Label(Main.getStringResources().getString("ANIMAL_TO_KILL_LABEL"));
        selectAnimalToFeedLabel = new Label(Main.getStringResources().getString("ANIMAL_TO_FEED_LABEL"));
        selectFoodLabel = new Label(Main.getStringResources().getString("SELECT_FOOD_LABEL"));
        selectListLabel = new Label(Main.getStringResources().getString("SELECT_LIST_LABEL"));
        selectedListLabel = new Label(Main.getStringResources().getString("SELECTED_LIST_LABEL"));
        statusLabel = new Label(Main.getStringResources().getString("STATUS_LABEL"));

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

        languageChoice.setBounds(156, 56, 152, 24);

        languageChoice.addItem(Main.getStringResources().getString("RUSSIAN_LANG_ITEM"));
        languageChoice.addItem(Main.getStringResources().getString("ENGLISH_LANG_ITEM"));

        configPanel.add(languageChoice);

        // Main Panel
        itemTypeChoice = new Choice();
        listChoice = new Choice();

        itemTypeChoice.setBounds(16, 126, 304, 24);
        listChoice.setBounds(16, 486, 304, 24);

        itemTypeChoice.addItem(Main.getStringResources().getString("HERBIVORE_ITEM"));
        itemTypeChoice.addItem(Main.getStringResources().getString("PREDATOR_ITEM"));
        itemTypeChoice.addItem(Main.getStringResources().getString("GRASS_ITEM"));

        listChoice.addItem(Main.getStringResources().getString("ALL_ANIMALS_ITEM"));
        listChoice.addItem(Main.getStringResources().getString("ALL_HERBIVORES_ITEM"));
        listChoice.addItem(Main.getStringResources().getString("ALL_PREDATORS_ITEM"));
        listChoice.addItem(Main.getStringResources().getString("ALL_GRASSES_ITEM"));
        listChoice.addItem(Main.getStringResources().getString("ALL_LIVING_ANIMALS_ITEM"));
        listChoice.addItem(Main.getStringResources().getString("ALL_LIVING_HERBIVORES_ITEM"));
        listChoice.addItem(Main.getStringResources().getString("ALL_LIVING_PREDATORS_ITEM"));

        listChoice.addItemListener(new ListChoiceListener(this));

        mainPanel.add(itemTypeChoice);
        mainPanel.add(listChoice);
    }

    private void setButtons() {
        // Buttons
        // Config Panel
        applyConfigButton = new Button(Main.getStringResources().getString("APPLY_CONFIG_BUTTON"));
        applyConfigButton.setBounds(16, 320, 120, 24);

        applyConfigButton.addActionListener(new ApplyConfigButtonListener(this));

        configPanel.add(applyConfigButton);

        // Main Panel
        createItemButton = new Button(Main.getStringResources().getString("CREATE_BUTTON"));
        killAnimalButton = new Button(Main.getStringResources().getString("KILL_BUTTON"));
        feedAnimalButton = new Button(Main.getStringResources().getString("FEED_BUTTON"));

        createItemButton.setBounds(808, 126, 136, 24);
        killAnimalButton.setBounds(16, 406, 304, 24);
        feedAnimalButton.setBounds(336, 406, 608, 24);

        createItemButton.addActionListener(new CreateItemButtonListener(this));
        killAnimalButton.addActionListener(new KillAnimalButtonListener(this));
        feedAnimalButton.addActionListener(new FeedAnimalButtonListener(this));

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

        updateLists();

        animalToFeedList.addItemListener(new AnimalToFeedListListener(this));

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

    private void updateLists() {
        animalToKillList.removeAll();
        animalToFeedList.removeAll();
        foodList.removeAll();
        commonList.removeAll();

        String herbivore = "Herbivore ";
        String predator = "Predator ";

        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) {
                animalToKillList.add(herbivore + i);
                animalToFeedList.add(herbivore + i);
            } else {
                animalToKillList.add(predator + i);
                animalToFeedList.add(predator + i);
            }
        }
    }

    public Choice getLanguageChoice() {
        return languageChoice;
    }

    public Choice getItemTypeChoice() {
        return itemTypeChoice;
    }

    public Choice getListChoice() {
        return listChoice;
    }

    public Button getApplyConfigButton() {
        return applyConfigButton;
    }

    public Button getCreateItemButton() {
        return createItemButton;
    }

    public Button getKillAnimalButton() {
        return killAnimalButton;
    }

    public Button getFeedAnimalButton() {
        return feedAnimalButton;
    }

    public TextField getItemNameTextField() {
        return itemNameTextField;
    }

    public TextField getItemWeightTextField() {
        return itemWeightTextField;
    }

    public List getAnimalToKillList() {
        return animalToKillList;
    }

    public List getAnimalToFeedList() {
        return animalToFeedList;
    }

    public List getFoodList() {
        return foodList;
    }

    public List getCommonList() {
        return commonList;
    }

    public TextArea getStatusTextArea() {
        return statusTextArea;
    }
}
