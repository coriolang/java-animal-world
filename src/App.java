import controller.MainController;
import view.MainConsole;
import view.MainFrame;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws InterruptedException {
        try {
            MainController.startApp();
        } catch (FileNotFoundException e) {
            System.out.println("File with configs not found!");
            // Или вывести Месседж Бокс с ошибкой
            return;
        }

        if (args.length > 0) {
            // Console
            MainConsole.dialog();
        } else {
            // GUI
            new MainFrame(MainController.stringResources.getString("APPLICATION_TITLE"));
        }
    }
}
