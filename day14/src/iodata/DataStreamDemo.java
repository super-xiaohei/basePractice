package iodata;

import org.junit.Test;

import java.io.*;

public class DataStreamDemo {
    @Test
    public static void main(String[] args) throws IOException {
        File file = new File("E://myData.txt");
        //writeData(file);
        readData(file);
    }

    private static void readData(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
       /* long l = dataInputStream.readLong();
        //int i = dataInputStream.readInt();
        dataInputStream.skipBytes(4); //连续跳过四个字节
        String s = dataInputStream.readUTF();
        System.out.println(s);*/
      /* while (true){
           String s = dataInputStream.readUTF();
           if(s == null){
               break;
           }else {
               System.out.println(s);
           }
       }*/
        int count = dataInputStream.readInt();
        for (int i = 0; i < count; i++) {
            String value = dataInputStream.readUTF();
            System.out.println(value);
        }
    }
    @Test
    public static void writeData(File file) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        /*//存储 。。。。。。刚刚的时间戳
        dataOutputStream.writeLong(System.currentTimeMillis());
        dataOutputStream.writeInt(520521);
        dataOutputStream.writeUTF("彭于晏");
        dataOutputStream.flush();
        dataOutputStream.close();*/
        //连续写入25个字符
        int count = 25;
        dataOutputStream.writeInt(count);
        for (int i = 1; i <= count; i++) {
            dataOutputStream.writeUTF("人类：" + i);
        }
        dataOutputStream.flush();
        dataOutputStream.close();
        System.out.println("成功");
    }
}
