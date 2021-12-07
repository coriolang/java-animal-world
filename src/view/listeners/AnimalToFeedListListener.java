package view.listeners;

import view.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnimalToFeedListListener implements ItemListener {

    private MainFrame frame;

    public AnimalToFeedListListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        frame.getFoodList().removeAll();

        String food;

        if (frame.getAnimalToFeedList().getSelectedItem().contains("Predator")) {
            food = "Herbivore ";
        } else {
            food = "Grass ";
        }

        for (int i = 0; i < 10; i++) {
            frame.getFoodList().add(food + i);
        }
    }
}
