package controller.listeners;

import controller.MainController;
import controller.NetworkController;
import view.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConnectButtonListener implements ActionListener {

    private MainFrame frame;

    public ConnectButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.getIpAddressTextField().getText().isEmpty()
                || frame.getIpAddressTextField().getText().isBlank()) {

            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(MainController.stringResources.getString("INCORRECT_ADDRESS"));
            return;
        }

        int port;
        try {
            port = Integer.parseInt((frame.getPortTextField().getText()));
        } catch (NumberFormatException ex) {
            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(MainController.stringResources.getString("INCORRECT_PORT"));
            return;
        }

        NetworkController.serverAddress = frame.getIpAddressTextField().getText();
        NetworkController.serverPort = port;

        try {
            NetworkController.request("test");

            frame.getConnectButton().setEnabled(false);
            frame.getIpAddressTextField().setEnabled(false);
            frame.getPortTextField().setEnabled(false);
            frame.getDisconnectButton().setEnabled(true);

            frame.getItemTypeChoice().setEnabled(true);
            frame.getItemNameTextField().setEnabled(true);
            frame.getItemWeightTextField().setEnabled(true);
            frame.getAnimalToKillTypeChoice().setEnabled(true);
            frame.getAnimalToKillList().setEnabled(true);
            frame.getAnimalToFeedTypeChoice().setEnabled(true);
            frame.getAnimalToFeedList().setEnabled(true);
            frame.getFoodList().setEnabled(true);
            frame.getListChoice().setEnabled(true);
            frame.getCommonList().setEnabled(true);

            frame.getStatusTextArea().setForeground(Color.BLACK);
            frame.getStatusTextArea().setText(MainController.stringResources.getString("SERVER_CONNECTED"));
        } catch (IOException ex) {
            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(ex.getMessage());
        }
    }
}
