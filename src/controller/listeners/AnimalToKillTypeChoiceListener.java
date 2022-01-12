package controller.listeners;

import controller.FrameController;
import view.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnimalToKillTypeChoiceListener implements ItemListener {

    private MainFrame frame;

    public AnimalToKillTypeChoiceListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        FrameController.updateAnimalToKillList(frame);
    }
}
