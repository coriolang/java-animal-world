package controller.listeners;

import controller.FrameController;
import controller.MainController;
import view.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class FeedAnimalButtonListener implements ActionListener {

    private MainFrame frame;

    public FeedAnimalButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.getAnimalToFeedList().getSelectedIndex() == -1) {
            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(MainController.stringResources
                    .getString("ANIMAL_NOT_SELECTED"));
            return;
        }
        if (frame.getFoodList().getSelectedIndex() == -1) {
            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(MainController.stringResources
                    .getString("FOOD_NOT_SELECTED"));
            return;
        }

        int animalId = -1;
        int foodId = -1;

        for (Integer key : MainController.getAnimalToFeedHashMap().keySet()) {
            if (Objects.equals(frame.getAnimalToFeedList().getSelectedItem(),
                    MainController.getAnimalToFeedHashMap().get(key))) {

                animalId = key;
                break;
            }
        }
        for (Integer key : MainController.getFoodsHashMap().keySet()) {
            if (Objects.equals(frame.getFoodList().getSelectedItem(),
                    MainController.getFoodsHashMap().get(key))) {

                foodId = key;
                break;
            }
        }

        String feedingStatus = null;
        try {
            feedingStatus = MainController.feed(animalId, foodId);
            frame.getStatusTextArea().setForeground(Color.BLACK);
        } catch (IOException ex) {
            feedingStatus = ex.getMessage();
            frame.getStatusTextArea().setForeground(Color.RED);
        }

        FrameController.updateAnimalToFeedList(frame);

        frame.getStatusTextArea().setText(feedingStatus);
    }
}
