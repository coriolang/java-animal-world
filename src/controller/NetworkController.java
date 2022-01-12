package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkController {

    public static String serverAddress;
    public static int serverPort;

    public static String request(String clientCommand) throws IOException {
        Socket socket = new Socket(serverAddress, serverPort);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        dataOutputStream.writeUTF(clientCommand);
        dataOutputStream.flush();

        String answer = dataInputStream.readUTF();

        dataOutputStream.close();
        dataInputStream.close();

        socket.close();

        return answer;
    }
}
