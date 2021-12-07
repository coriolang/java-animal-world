package view.listeners;

import view.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListChoiceListener implements ItemListener {

    private MainFrame frame;

    public ListChoiceListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        frame.getCommonList().removeAll();

        String selectedList = frame.getListChoice().getSelectedItem();

        for (int i = 0; i < 12; i++) {
            frame.getCommonList().add(i + " " + selectedList);
        }
    }
}
