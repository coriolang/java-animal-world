package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.HashMap;

public class ListChoiceListener implements ItemListener {

    private MainFrame frame;

    public ListChoiceListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        frame.getCommonList().removeAll();

        HashMap<Integer, String> hashMap = new HashMap<>();

        try {
            switch (frame.getListChoice().getSelectedIndex()) {
                case 1:
                    hashMap = MainController.getAllAnimals();
                    break;
                case 2:
                    hashMap = MainController.getAllHerbivores();
                    break;
                case 3:
                    hashMap = MainController.getAllPredators();
                    break;
                case 4:
                    hashMap = MainController.getAllGrasses();
                    break;
                case 5:
                    hashMap = MainController.getLiveAnimals();
                    break;
                case 6:
                    hashMap = MainController.getLiveHerbivores();
                    break;
                case 7:
                    hashMap = MainController.getLivePredators();
                    break;
            }
        } catch (IOException ex) {
            frame.getStatusTextArea().setText(ex.getMessage());
            return;
        }

        for (String item : hashMap.values()) {
            frame.getCommonList().add(item);
        }

        frame.getStatusTextArea().setText(
                MainController.stringResources.getString("SELECTED_LIST")
                + " "
                + frame.getListChoice().getSelectedItem()
        );
    }
}
