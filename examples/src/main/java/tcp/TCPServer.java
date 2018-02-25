package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer{

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server Started at:"+ serverSocket);

        while (true){
            final Socket activeSocket = serverSocket.accept();
            System.out.println("Received a connection from :" + activeSocket);
            Runnable runnable = () -> handleClientRequest(activeSocket);
            new Thread(runnable).start();
        }



    }

    private static void handleClientRequest(Socket socket) {

        try(BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream())){

            outToClient.writeBytes("\nPlease enter your name...\n");
            String message;
            while((message = socketReader.readLine()) != null){
                System.out.println("Received form client:" + message );
                outToClient.writeBytes("Hello " + message + ". Welcome to socket world!!!!\n");
                outToClient.writeBytes("\nPlease enter your name...\n");
            }
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }


}