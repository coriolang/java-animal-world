import controller.MainController;
import view.MainConsole;
import view.MainFrame;
import view.MessageBox;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {
        try {
            MainController.startApp();
        } catch (FileNotFoundException e) {
            String errorMessage = "File with configs not found!";
            MessageBox.showError(errorMessage);
            return;
        }

        if (MainController.getInterfaceMode() == 1) {
            // GUI
            new MainFrame(MainController.stringResources.getString("APPLICATION_TITLE"));
        } else {
            // Console
            MainConsole.dialog();
        }
    }
}
