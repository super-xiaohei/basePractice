package iozijie;

import org.junit.Test;

import java.io.*;

/**
 * 字节流
 */
public class MainCopy {
    @Test
    public static void main(String[] args)  {
        //Date date = new Date();
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            File fileSrc = new File("E://my_emps");
            File fileCopy = new File("D://copy.txt");
            inputStream = new BufferedInputStream(new FileInputStream(fileSrc)); //输入缓冲流
            outputStream = new BufferedOutputStream(new FileOutputStream(fileCopy));//输出缓冲流
            byte[] bytes = new byte[1024];
            long now1 = System.currentTimeMillis();
            System.out.println("开始复制...");
            while (true){
                int count = inputStream.read(bytes);
                if(count == -1){
                    break;
                }
                for (int i = 0; i < count; i++) {
                    bytes[i] = (byte)(bytes[i] ^ 1521);
                }
                outputStream.write(bytes,0,count);
                outputStream.flush();

                System.out.println((System.currentTimeMillis() - now1) + "毫秒");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(inputStream != null)
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(outputStream != null)
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
