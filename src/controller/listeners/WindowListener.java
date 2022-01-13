package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.*;
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

        frame.getConnectButton().setEnabled(true);
        frame.getIpAddressTextField().setEnabled(true);
        frame.getPortTextField().setEnabled(true);
        frame.getDisconnectButton().setEnabled(false);

        frame.getItemTypeChoice().setEnabled(false);
        frame.getItemNameTextField().setEnabled(false);
        frame.getItemWeightTextField().setEnabled(false);
        frame.getAnimalToKillTypeChoice().setEnabled(false);
        frame.getAnimalToKillList().setEnabled(false);
        frame.getAnimalToFeedTypeChoice().setEnabled(false);
        frame.getAnimalToFeedList().setEnabled(false);
        frame.getFoodList().setEnabled(false);
        frame.getListChoice().setEnabled(false);
        frame.getCommonList().setEnabled(false);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            MainController.closeApp();
        } catch (IOException ex) {
            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(ex.getMessage());
        }
    }
}
