package view.listeners;

import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KillAnimalButtonListener implements ActionListener {

    private MainFrame frame;

    public KillAnimalButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedAnimal = frame.getAnimalToKillList().getSelectedItem();
        frame.getStatusTextArea().setText("Killed: " + selectedAnimal);
    }
}
