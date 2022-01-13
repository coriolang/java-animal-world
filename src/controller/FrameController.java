package controller;

import storage.Storage;
import view.MainFrame;

import java.awt.*;
import java.io.IOException;

public class FrameController {

    public static void updateAnimalToKillList(MainFrame frame) {
        frame.getAnimalToKillList().removeAll();

        try {
            if (frame.getAnimalToKillTypeChoice().getSelectedIndex() == 0) {
                return;
            } else if (frame.getAnimalToKillTypeChoice().getSelectedIndex() == 1) {
                Storage.setAnimalToKill(MainController.getLiveHerbivores());
            } else if (frame.getAnimalToKillTypeChoice().getSelectedIndex() == 2) {
                Storage.setAnimalToKill(MainController.getLivePredators());
            }

            for (String item : Storage.getAnimalToKill().values()) {
                frame.getAnimalToKillList().add(item);
            }
        } catch (IOException ex) {
            frame.getStatusTextArea().setForeground(Color.RED);
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
                Storage.setAnimalToFeed(MainController.getLiveHerbivores());
                Storage.setFoods(MainController.getAllGrasses());
            } else if (frame.getAnimalToFeedTypeChoice().getSelectedIndex() == 2) {
                Storage.setAnimalToFeed(MainController.getLivePredators());
                Storage.setFoods(MainController.getLiveHerbivores());
            }

            for (String item : Storage.getAnimalToFeed().values()) {
                frame.getAnimalToFeedList().add(item);
            }
            for (String item : Storage.getFoods().values()) {
                frame.getFoodList().add(item);
            }
        } catch (IOException ex) {
            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(ex.getMessage());
        }
    }
}
