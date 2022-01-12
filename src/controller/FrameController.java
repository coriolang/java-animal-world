package controller;

import view.MainFrame;

import java.io.IOException;

public class FrameController {

    public static void updateAnimalToKillList(MainFrame frame) {
        frame.getAnimalToKillList().removeAll();

        try {
            if (frame.getAnimalToKillTypeChoice().getSelectedIndex() == 0) {
                return;
            } else if (frame.getAnimalToKillTypeChoice().getSelectedIndex() == 1) {
                MainController.setAnimalToKillHashMap(MainController.getLiveHerbivores());
            } else if (frame.getAnimalToKillTypeChoice().getSelectedIndex() == 2) {
                MainController.setAnimalToKillHashMap(MainController.getLivePredators());
            }

            for (String item : MainController.getAnimalToKillHashMap().values()) {
                frame.getAnimalToKillList().add(item);
            }
        } catch (IOException ex) {
            frame.getStatusTextArea().setText(ex.getMessage());
        }
    }

    public static void updateAnimalToFeedList(MainFrame frame) {
        frame.getAnimalToFeedList().removeAll();
        frame.getFoodList().removeAll();

        try {
            if (frame.getAnimalToFeedTypeChoice().getSelectedIndex() == 0) {
                return;
            } else if (frame.getAnimalToFeedTypeChoice().getSelectedIndex() == 1) {
                MainController.setAnimalToFeedHashMap(MainController.getLiveHerbivores());
                MainController.setFoodsHashMap(MainController.getAllGrasses());
            } else if (frame.getAnimalToFeedTypeChoice().getSelectedIndex() == 2) {
                MainController.setAnimalToFeedHashMap(MainController.getLivePredators());
                MainController.setFoodsHashMap(MainController.getLiveHerbivores());
            }

            for (String item : MainController.getAnimalToFeedHashMap().values()) {
                frame.getAnimalToFeedList().add(item);
            }
            for (String item : MainController.getFoodsHashMap().values()) {
                frame.getFoodList().add(item);
            }
        } catch (IOException ex) {
            frame.getStatusTextArea().setText(ex.getMessage());
        }
    }
}
