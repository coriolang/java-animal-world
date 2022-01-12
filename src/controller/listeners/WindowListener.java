package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class WindowListener extends WindowAdapter {

    private MainFrame frame;

    public WindowListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        frame.getIpAddressTextField().setText("localhost");
        frame.getPortTextField().setText("1356");
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
