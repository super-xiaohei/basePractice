package io;

import org.junit.Test;

import java.io.*;

public class MainOut {
    @Test
    public static void main(String[] args) {
        Dog dog1 = new Dog("1","1","1","1");
        Dog dog2 = new Dog("2","2","2","2");
        Dog dog3 = new Dog("3","3","3","3");


        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File("E://dog.txt");
            fileOutputStream = new FileOutputStream(file,true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dog1);
            objectOutputStream.writeObject(dog2);
            objectOutputStream.writeObject(dog3);
            objectOutputStream.flush();
            System.out.println("成功!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
