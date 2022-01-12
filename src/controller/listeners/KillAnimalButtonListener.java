package controller.listeners;

import controller.FrameController;
import controller.MainController;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class KillAnimalButtonListener implements ActionListener {

    private MainFrame frame;

    public KillAnimalButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.getAnimalToKillList().getSelectedIndex() == -1) {
            frame.getStatusTextArea().setText(MainController.stringResources
                    .getString("ANIMAL_NOT_SELECTED"));
            return;
        }

        int animalId = -1;

        for (Integer key : MainController.getAnimalToKillHashMap().keySet()) {
            if (Objects.equals(frame.getAnimalToKillList().getSelectedItem(), MainController.getAnimalToKillHashMap().get(key))) {
                animalId = key;
                break;
            }
        }

        String murderStatus = null;
        try {
            murderStatus = MainController.kill(animalId);
        } catch (IOException ex) {
            murderStatus = ex.getMessage();
        }

        FrameController.updateAnimalToKillList(frame);

        frame.getStatusTextArea().setText(murderStatus);
    }
}
