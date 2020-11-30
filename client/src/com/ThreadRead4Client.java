package com;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadRead4Client extends Thread{
    private BufferedReader in;

    public ThreadRead4Client(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (true){
            try {
                String contentFromServer = in.readLine();
                System.out.println(contentFromServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
