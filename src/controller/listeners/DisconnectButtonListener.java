package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectButtonListener implements ActionListener {

    private MainFrame frame;

    public DisconnectButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getConnectButton().setEnabled(true);
        frame.getIpAddressTextField().setEnabled(true);
        frame.getPortTextField().setEnabled(true);
        frame.getDisconnectButton().setEnabled(false);

        frame.getLanguageChoice().setEnabled(true);
        frame.getApplyConfigButton().setEnabled(true);

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

        frame.getCreateItemButton().setEnabled(false);
        frame.getKillAnimalButton().setEnabled(false);
        frame.getFeedAnimalButton().setEnabled(false);

        frame.getStatusTextArea().setForeground(Color.BLACK);
        frame.getStatusTextArea().setText(MainController.stringResources.getString("SERVER_DISCONNECTED"));
    }
}
