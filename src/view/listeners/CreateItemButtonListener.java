package view.listeners;

import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateItemButtonListener implements ActionListener {

    private MainFrame frame;

    public CreateItemButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = frame.getItemTypeChoice().getSelectedItem();
        String name = frame.getItemNameTextField().getText();
        float weight = Float.parseFloat(frame.getItemWeightTextField().getText());

        frame.getStatusTextArea().setText("Created: " + selectedItem + " " + name + " weight = " + weight);
    }
}
