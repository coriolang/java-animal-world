package controller.listeners;

import controller.FrameController;
import controller.MainController;
import view.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class AnimalToFeedTypeChoiceListener implements ItemListener {

    private MainFrame frame;

    public AnimalToFeedTypeChoiceListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        FrameController.updateAnimalToFeedList(frame);
    }
}
