package controller.listeners;

import controller.MainController;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ApplyConfigButtonListener implements ActionListener {

    private MainFrame frame;

    public ApplyConfigButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedLanguage = frame.getLanguageChoice().getSelectedIndex();
        String languageStatus;

        try {
            languageStatus = MainController.applyConfig(selectedLanguage);
        } catch (IOException ex) {
            languageStatus = ex.getMessage();
        }

        frame.getStatusTextArea().setText(languageStatus);
    }
}
