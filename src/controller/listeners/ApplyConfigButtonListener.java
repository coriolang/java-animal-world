package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyConfigButtonListener implements ActionListener {

    private MainFrame frame;

    public ApplyConfigButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedLanguage = frame.getLanguageChoice().getSelectedIndex();
        String languageStatus = MainController.applyConfig(selectedLanguage);

        frame.getStatusTextArea().setText(languageStatus);
    }
}
