package view;

import controller.ConsoleController;
import controller.MainController;

public class MainConsole {

    public static void dialog() {
        System.out.println(MainController.stringResources.getString("HELLO_WORLD"));

        int selectedMenu = -1;

        while (selectedMenu != 0) {
            System.out.println(MainController.stringResources.getString("MAIN_MENU"));

            selectedMenu = ConsoleController.getUserInputInt();

            switch (selectedMenu) {
                case (1):
                    System.out.println(MainController.stringResources.getString("CREATE_MENU"));

                    selectedMenu = ConsoleController.getUserInputInt();

                    switch (selectedMenu) {
                        case 1:
                            ConsoleController.createHerbivore();
                            break;
                        case 2:
                            ConsoleController.createPredator();
                            break;
                        case 3:
                            ConsoleController.createGrass();
                            break;
                        case 0:
                            selectedMenu = -1;
                            break;
                    }

                    break;
                case (2):
                    ConsoleController.killAnimal();
                    break;
                case (3):
                    System.out.println(MainController.stringResources.getString("FEED_MENU"));

                    selectedMenu = ConsoleController.getUserInputInt();

                    switch (selectedMenu) {
                        case 1:
                            ConsoleController.feedHerbivore();
                            break;
                        case 2:
                            ConsoleController.feedPredator();
                            break;
                        case 0:
                            selectedMenu = -1;
                            break;
                    }

                    break;
                case 4:
                    ConsoleController.printList(MainController.getAllAnimalsList());
                    break;
                case 5:
                    ConsoleController.printList(MainController.getAllHerbivoresList());
                    break;
                case 6:
                    ConsoleController.printList(MainController.getAllPredatorsList());
                    break;
                case 7:
                    ConsoleController.printList(MainController.getGrassesList());
                    break;
                case 8:
                    ConsoleController.printList(MainController.getLiveAnimalsList());
                    break;
                case 9:
                    ConsoleController.printList(MainController.getLiveHerbivoresList());
                    break;
                case 10:
                    ConsoleController.printList(MainController.getLivePredatorsList());
                    break;
                case 11:
                    ConsoleController.printSelectedAnimal();
                    break;
                case 12:
                    System.out.println(MainController.stringResources.getString("LANGUAGE_MENU"));

                    selectedMenu = ConsoleController.getUserInputInt();

                    if (selectedMenu != 0) {
                        ConsoleController.setLanguage(selectedMenu - 1);
                    } else {
                        selectedMenu = -1;
                    }
                    break;
            }
        }

        ConsoleController.closeDialog();
    }
}
