package controller.listeners;

import controller.MainController;
import controller.NetworkController;
import view.MainFrame;

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

            frame.getStatusTextArea().setText(MainController.stringResources.getString("INCORRECT_ADDRESS"));
            return;
        }

        int port;
        try {
            port = Integer.parseInt((frame.getPortTextField().getText()));
        } catch (NumberFormatException ex) {
            frame.getStatusTextArea().setText(MainController.stringResources.getString("INCORRECT_PORT"));
            return;
        }

        NetworkController.serverAddress = frame.getIpAddressTextField().getText();
        NetworkController.serverPort = port;

        frame.getConnectButton().setEnabled(false);
        frame.getIpAddressTextField().setEnabled(false);
        frame.getPortTextField().setEnabled(false);

        frame.getDisconnectButton().setEnabled(true);

        try {
            NetworkController.request("test");
            frame.getStatusTextArea().setText(MainController.stringResources.getString("SERVER_CONNECTED"));
        } catch (IOException ex) {
            frame.getStatusTextArea().setText(ex.getMessage());
        }
    }
}
