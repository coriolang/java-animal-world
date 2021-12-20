package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class AnimalToFeedListListener implements ItemListener {

    private MainFrame frame;

    public AnimalToFeedListListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        frame.getFoodList().removeAll();

        ArrayList<String> foodList = MainController
                .getFoodList(frame.getAnimalToFeedList().getSelectedItem().contains("Predator"));

        for (int i = 0; i < foodList.size(); i++) {
            frame.getFoodList().add(foodList.get(i));
        }
    }
}
