package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class CloseWindowListener extends WindowAdapter {

    private MainFrame frame;

    public CloseWindowListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            MainController.closeApp();
        } catch (IOException ex) {
            frame.getStatusTextArea().setText(ex.getMessage());
        }
    }
}
