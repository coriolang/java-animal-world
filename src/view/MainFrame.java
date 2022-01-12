package view;

import controller.MainController;
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
            ipAddressLabel,
            portLabel,
    // Config Panel
            configLabel,
            languageLabel,
    // Main Panel
            mainLabel,
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
            animalToKillTypeChoice,
            animalToFeedTypeChoice,
            listChoice;

    // Buttons
    // Network Panel
    private Button connectButton,
            disconnectButton,
    // Config Panel
            applyConfigButton,
    // Main Panel
            createItemButton,
            killAnimalButton,
            feedAnimalButton;

    // TextFields
    // Network Panel
    private TextField ipAddressTextField,
            portTextField,
    // Main Panel
            itemNameTextField,
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

        addWindowListener(new WindowListener(this));

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
        networkLabel = new Label(MainController.stringResources.getString("NETWORK_LABEL"));
        ipAddressLabel = new Label(MainController.stringResources.getString("IP_ADDRESS_LABEL"));
        portLabel = new Label(MainController.stringResources.getString("PORT_LABEL"));

        networkLabel.setBounds(16, 46, 288, 24);
        networkLabel.setFont(robotoBold);
        networkLabel.setBackground(Color.LIGHT_GRAY);
        ipAddressLabel.setBounds(16, 86, 288, 24);
        ipAddressLabel.setBackground(Color.LIGHT_GRAY);
        portLabel.setBounds(16, 166, 288, 24);
        portLabel.setBackground(Color.LIGHT_GRAY);

        networkPanel.add(networkLabel);
        networkPanel.add(ipAddressLabel);
        networkPanel.add(portLabel);

        // Config Panel
        configLabel = new Label(MainController.stringResources.getString("CONFIG_LABEL"));
        languageLabel = new Label(MainController.stringResources.getString("LANGUAGE_LABEL"));

        configLabel.setBounds(16, 16, 288, 24);
        configLabel.setFont(robotoBold);
        configLabel.setBackground(Color.LIGHT_GRAY);
        languageLabel.setBounds(16, 56, 120, 24);
        languageLabel.setBackground(Color.LIGHT_GRAY);

        configPanel.add(configLabel);
        configPanel.add(languageLabel);

        // Main Panel
        mainLabel = new Label(MainController.stringResources.getString("MAIN_LABEL"));
        itemTypeLabel = new Label(MainController.stringResources.getString("ITEM_TYPE_LABEL"));
        itemNameLabel = new Label(MainController.stringResources.getString("ITEM_NAME_LABEL"));
        itemWeightLabel = new Label(MainController.stringResources.getString("ITEM_WEIGHT_LABEL"));
        selectAnimalToKillLabel = new Label(MainController.stringResources.getString("ANIMAL_TO_KILL_LABEL"));
        selectAnimalToFeedLabel = new Label(MainController.stringResources.getString("ANIMAL_TO_FEED_LABEL"));
        selectFoodLabel = new Label(MainController.stringResources.getString("SELECT_FOOD_LABEL"));
        selectListLabel = new Label(MainController.stringResources.getString("SELECT_LIST_LABEL"));
        selectedListLabel = new Label(MainController.stringResources.getString("SELECTED_LIST_LABEL"));
        statusLabel = new Label(MainController.stringResources.getString("STATUS_LABEL"));

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

        languageChoice.addItem(MainController.stringResources.getString("RUSSIAN_LANG_ITEM"));
        languageChoice.addItem(MainController.stringResources.getString("ENGLISH_LANG_ITEM"));

        configPanel.add(languageChoice);

        // Main Panel
        itemTypeChoice = new Choice();
        animalToKillTypeChoice = new Choice();
        animalToFeedTypeChoice = new Choice();
        listChoice = new Choice();

        itemTypeChoice.setBounds(16, 126, 304, 24);
        animalToKillTypeChoice.setBounds(16, 206, 304, 24);
        animalToFeedTypeChoice.setBounds(336, 206, 304, 24);
        listChoice.setBounds(16, 486, 304, 24);

        itemTypeChoice.addItem(MainController.stringResources.getString("HERBIVORE_ITEM"));
        itemTypeChoice.addItem(MainController.stringResources.getString("PREDATOR_ITEM"));
        itemTypeChoice.addItem(MainController.stringResources.getString("GRASS_ITEM"));

        animalToKillTypeChoice.addItem("");
        animalToKillTypeChoice.addItem(MainController.stringResources.getString("HERBIVORE_ITEM"));
        animalToKillTypeChoice.addItem(MainController.stringResources.getString("PREDATOR_ITEM"));

        animalToFeedTypeChoice.addItem("");
        animalToFeedTypeChoice.addItem(MainController.stringResources.getString("HERBIVORE_ITEM"));
        animalToFeedTypeChoice.addItem(MainController.stringResources.getString("PREDATOR_ITEM"));

        listChoice.addItem("");
        listChoice.addItem(MainController.stringResources.getString("ALL_ANIMALS_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_HERBIVORES_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_PREDATORS_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_GRASSES_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_LIVING_ANIMALS_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_LIVING_HERBIVORES_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_LIVING_PREDATORS_ITEM"));

        listChoice.addItemListener(new ListChoiceListener(this));
        animalToKillTypeChoice.addItemListener(new AnimalToKillTypeChoiceListener(this));
        animalToFeedTypeChoice.addItemListener(new AnimalToFeedTypeChoiceListener(this));

        mainPanel.add(itemTypeChoice);
        mainPanel.add(animalToKillTypeChoice);
        mainPanel.add(animalToFeedTypeChoice);
        mainPanel.add(listChoice);
    }

    private void setButtons() {
        // Buttons
        // Network Panel
        connectButton = new Button(MainController.stringResources.getString("CONNECT_BUTTON"));
        disconnectButton = new Button(MainController.stringResources.getString("DISCONNECT_BUTTON"));

        connectButton.setBounds(16, 246, 136, 24);
        disconnectButton.setBounds(168, 246, 136, 24);

        connectButton.addActionListener(new ConnectButtonListener(this));
        disconnectButton.addActionListener(new DisconnectButtonListener(this));

        networkPanel.add(connectButton);
        networkPanel.add(disconnectButton);

        // Config Panel
        applyConfigButton = new Button(MainController.stringResources.getString("APPLY_CONFIG_BUTTON"));
        applyConfigButton.setBounds(16, 320, 136, 24);

        applyConfigButton.addActionListener(new ApplyConfigButtonListener(this));

        configPanel.add(applyConfigButton);

        // Main Panel
        createItemButton = new Button(MainController.stringResources.getString("CREATE_BUTTON"));
        killAnimalButton = new Button(MainController.stringResources.getString("KILL_BUTTON"));
        feedAnimalButton = new Button(MainController.stringResources.getString("FEED_BUTTON"));

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
        // Network Panel
        ipAddressTextField = new TextField();
        portTextField = new TextField();

        ipAddressTextField.setBounds(16, 126, 288, 24);
        portTextField.setBounds(16, 206, 288, 24);

        networkPanel.add(ipAddressTextField);
        networkPanel.add(portTextField);

        // Main Panel
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

        animalToKillList.setBounds(16, 246, 304, 144);
        animalToFeedList.setBounds(336, 246, 304, 144);
        foodList.setBounds(656, 206, 288, 184);
        commonList.setBounds(336, 486, 304, 200);

//        updateLists();

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

//    private void updateLists() {
//        animalToKillList.removeAll();
//        animalToFeedList.removeAll();
//        foodList.removeAll();
//        commonList.removeAll();
//
//        String herbivore = "Herbivore ";
//        String predator = "Predator ";
//
//        for (int i = 0; i < 12; i++) {
//            if (i % 2 == 0) {
//                animalToKillList.add(herbivore + i);
//                animalToFeedList.add(herbivore + i);
//            } else {
//                animalToKillList.add(predator + i);
//                animalToFeedList.add(predator + i);
//            }
//        }
//    }

    public void updateStrings() {
        // Labels
        // Network Panel
        networkLabel.setText(MainController.stringResources.getString("NETWORK_LABEL"));
        ipAddressLabel.setText(MainController.stringResources.getString("IP_ADDRESS_LABEL"));
        portLabel.setText(MainController.stringResources.getString("PORT_LABEL"));
        // Config Panel
        configLabel.setText(MainController.stringResources.getString("CONFIG_LABEL"));
        languageLabel.setText(MainController.stringResources.getString("LANGUAGE_LABEL"));
        // Main Panel
        mainLabel.setText(MainController.stringResources.getString("MAIN_LABEL"));
        itemTypeLabel.setText(MainController.stringResources.getString("ITEM_TYPE_LABEL"));
        itemNameLabel.setText(MainController.stringResources.getString("ITEM_NAME_LABEL"));
        itemWeightLabel.setText(MainController.stringResources.getString("ITEM_WEIGHT_LABEL"));
        selectAnimalToKillLabel.setText(MainController.stringResources.getString("ANIMAL_TO_KILL_LABEL"));
        selectAnimalToFeedLabel.setText(MainController.stringResources.getString("ANIMAL_TO_FEED_LABEL"));
        selectFoodLabel.setText(MainController.stringResources.getString("SELECT_FOOD_LABEL"));
        selectListLabel.setText(MainController.stringResources.getString("SELECT_LIST_LABEL"));
        selectedListLabel.setText(MainController.stringResources.getString("SELECTED_LIST_LABEL"));
        statusLabel.setText(MainController.stringResources.getString("STATUS_LABEL"));

        // Choices
        // Config Panel
        languageChoice.removeAll();
        languageChoice.addItem(MainController.stringResources.getString("RUSSIAN_LANG_ITEM"));
        languageChoice.addItem(MainController.stringResources.getString("ENGLISH_LANG_ITEM"));
        // Main Panel
        itemTypeChoice.removeAll();
        itemTypeChoice.addItem(MainController.stringResources.getString("HERBIVORE_ITEM"));
        itemTypeChoice.addItem(MainController.stringResources.getString("PREDATOR_ITEM"));
        itemTypeChoice.addItem(MainController.stringResources.getString("GRASS_ITEM"));

        animalToKillTypeChoice.removeAll();
        animalToKillTypeChoice.addItem("");
        animalToKillTypeChoice.addItem(MainController.stringResources.getString("HERBIVORE_ITEM"));
        animalToKillTypeChoice.addItem(MainController.stringResources.getString("PREDATOR_ITEM"));

        animalToFeedTypeChoice.removeAll();
        animalToFeedTypeChoice.addItem("");
        animalToFeedTypeChoice.addItem(MainController.stringResources.getString("HERBIVORE_ITEM"));
        animalToFeedTypeChoice.addItem(MainController.stringResources.getString("PREDATOR_ITEM"));

        listChoice.removeAll();
        listChoice.addItem("");
        listChoice.addItem(MainController.stringResources.getString("ALL_ANIMALS_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_HERBIVORES_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_PREDATORS_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_GRASSES_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_LIVING_ANIMALS_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_LIVING_HERBIVORES_ITEM"));
        listChoice.addItem(MainController.stringResources.getString("ALL_LIVING_PREDATORS_ITEM"));

        // Buttons
        // Network Panel
        connectButton.setLabel(MainController.stringResources.getString("CONNECT_BUTTON"));
        disconnectButton.setLabel(MainController.stringResources.getString("DISCONNECT_BUTTON"));
        // Config Panel
        applyConfigButton.setLabel(MainController.stringResources.getString("APPLY_CONFIG_BUTTON"));
        // Main Panel
        createItemButton.setLabel(MainController.stringResources.getString("CREATE_BUTTON"));
        killAnimalButton.setLabel(MainController.stringResources.getString("KILL_BUTTON"));
        feedAnimalButton.setLabel(MainController.stringResources.getString("FEED_BUTTON"));
    }

    public Choice getLanguageChoice() {
        return languageChoice;
    }

    public Choice getItemTypeChoice() {
        return itemTypeChoice;
    }

    public Choice getAnimalToKillTypeChoice() {
        return animalToKillTypeChoice;
    }

    public Choice getAnimalToFeedTypeChoice() {
        return animalToFeedTypeChoice;
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

    public Button getConnectButton() {
        return connectButton;
    }

    public Button getDisconnectButton() {
        return disconnectButton;
    }

    public TextField getItemNameTextField() {
        return itemNameTextField;
    }

    public TextField getItemWeightTextField() {
        return itemWeightTextField;
    }

    public TextField getIpAddressTextField() {
        return ipAddressTextField;
    }

    public TextField getPortTextField() {
        return portTextField;
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
