package iozifu;

import org.junit.Test;

import java.io.*;

public class InputStream2Reader {
    @Test
    public static void main(String[] args) throws Exception {
        File file = new File("E://emps.txt");
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));//没有缓冲的
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//InputStreamReader是转换流（字节转化为字符或者反过来）
        String str = null;
        while ((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
        inputStream.close();
        bufferedReader.close();
    }
}
