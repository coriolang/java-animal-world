package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectButtonListener implements ActionListener {

    private MainFrame frame;

    public ConnectButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getStatusTextArea().setText(MainController.stringResources.getString("SERVER_CONNECTED"));
    }
}
