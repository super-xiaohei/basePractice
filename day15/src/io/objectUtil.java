package io;

import org.junit.Test;

import java.io.*;

public class objectUtil {
    @Test
    public static Object deepClone(Object object){
        if(!(object instanceof Cloneable)){
            try {
                throw new CloneNotSupportedException("object is not implement Clonable");
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException();
            }
        }
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
       /* File file = new File(".","temp");
       // System.out.println(file.getAbsolutePath());
            if(file.exists()){
                file.delete();
            }else {
                file.createNewFile();
            }*/
           // ByteArrayOutputStream 类似于无限扩容的byte[]
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            //byte[] bytes = byteArrayOutputStream.toByteArray();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object readObject = objectInputStream.readObject();
            return readObject;
        } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(objectInputStream != null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    @Test
    public static void main(String[] args) {
        Dog dog1 = new Dog("001","hh","hh","hh");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Dog dog2 = (Dog) objectUtil.deepClone(dog1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        /*System.out.println(dog1.equals(dog2));
        System.out.println(dog1 == dog2);*/
    }
}
