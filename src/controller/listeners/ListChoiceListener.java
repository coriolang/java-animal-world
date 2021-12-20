package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ListChoiceListener implements ItemListener {

    private MainFrame frame;

    public ListChoiceListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        frame.getCommonList().removeAll();

        ArrayList<String> list = MainController
                .getSelectedList(frame.getListChoice().getSelectedItem());

        for (int i = 0; i < list.size(); i++) {
            frame.getCommonList().add(list.get(i));
        }
    }
}
