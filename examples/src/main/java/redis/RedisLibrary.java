package redis;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RedisLibrary {
    private String hostName;
    private int port;
    private OutputStream outputStream;
    private BufferedReader inputStream;

    public RedisLibrary(String hostName, int port){
        this.hostName = hostName;
        this.port = port;
    }


    public String setValue(String key, String value){

        String reply = null;

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(hostName, port), 30000);
            outputStream = socket.getOutputStream();
            String[] args = new String[]{"SET", key, value};

            writeRedisMessage(args);

            outputStream.flush();

            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            reply = inputStream.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reply;
    }

    private void writeRedisMessage( final String[] args) throws IOException {
        try{
            StringBuilder builder = new StringBuilder().append("*").append("3").append("\r\n");
            for (String arg: args ) {
                int length = arg.getBytes("UTF-8").length;
                builder.append("$").append(length).append("\r\n").append(arg).append("\r\n");
            }

            outputStream.write(builder.toString().getBytes("UTF-8"));
        } catch(IOException e){
            throw e;
        }

    }
}
