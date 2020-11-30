package com;

import javax.swing.*;
import java.io.PrintWriter;

public class ThreadWrite4Client extends Thread{
    private PrintWriter out;

    public ThreadWrite4Client(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        while (true) {
            String inputDialog = JOptionPane.showInputDialog("请输入内容");
            if (inputDialog == null) {
                continue;
            }
            out.println(inputDialog);
        }
    }
}
