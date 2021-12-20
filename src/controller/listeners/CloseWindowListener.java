package controller.listeners;

import controller.MainController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseWindowListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        MainController.closeApp();
    }
}
