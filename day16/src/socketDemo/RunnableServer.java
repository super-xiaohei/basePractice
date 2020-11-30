package socketDemo;

import java.io.*;
import java.net.Socket;

public class RunnableServer implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public RunnableServer(Socket socket) {
        this.socket = socket;
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            this.in = new BufferedReader(new InputStreamReader(inputStream));
            this.out = new PrintWriter(outputStream,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String name = null;
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                String s = in.readLine();
                System.out.println(name + ":" + s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
