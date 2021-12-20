package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedAnimalButtonListener implements ActionListener {

    private MainFrame frame;

    public FeedAnimalButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedAnimal = frame.getAnimalToFeedList().getSelectedItem();
        String selectedFood = frame.getFoodList().getSelectedItem();

        String feedStatus = MainController.feedAnimal(selectedAnimal, selectedFood);

        frame.getStatusTextArea().setText(feedStatus);
    }
}
