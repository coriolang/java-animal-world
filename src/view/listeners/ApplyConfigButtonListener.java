package view.listeners;

import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyConfigButtonListener implements ActionListener {

    private MainFrame frame;

    public ApplyConfigButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getStatusTextArea().setText("Config applied!");
    }
}
