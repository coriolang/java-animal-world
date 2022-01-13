package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateItemButtonListener implements ActionListener {

    private MainFrame frame;

    public CreateItemButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.getItemNameTextField().getText().isEmpty()
        || frame.getItemNameTextField().getText().isBlank()
        || frame.getItemNameTextField().getText().contains("&")) {

            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(MainController.stringResources.getString("INCORRECT_NAME"));
            return;
        }

        float weight;
        try {
            weight = Float.parseFloat(frame.getItemWeightTextField().getText());
        } catch (NumberFormatException ex) {
            frame.getStatusTextArea().setForeground(Color.RED);
            frame.getStatusTextArea().setText(MainController.stringResources.getString("INCORRECT_WEIGHT"));
            return;
        }

        int selectedItem = frame.getItemTypeChoice().getSelectedIndex();
        String name = frame.getItemNameTextField().getText();

        String creationStatus = null;
        try {
            creationStatus = MainController.create(selectedItem, name, weight);
        } catch (IOException ex) {
            creationStatus = ex.getMessage();
        }

        frame.getStatusTextArea().setForeground(Color.BLACK);
        frame.getStatusTextArea().setText(creationStatus);
    }
}
