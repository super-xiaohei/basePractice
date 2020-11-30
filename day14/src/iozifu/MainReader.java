package iozifu;

import org.junit.Test;

import java.io.*;

/**
 * 字符流的形式，读取硬盘中的一个文本文件的内容
 */
public class MainReader {
    @Test
    public static void main(String[] args) throws IOException {
        File file = new File("E://emps.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true){
            String line = bufferedReader.readLine();
            if(line == null){
                break;
            }else {
                System.out.println(line);
            }
        }

    }
}
