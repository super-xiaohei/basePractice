package practice;

import java.io.*;

/**
 * @author zyq
 * @date 2020/11/11 - 20:28
 */

//读取一个文件到另一个文件,如果要存数据的文件没有就会自动创建一个文件
public class TestFileOutputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        File file1 = new File("E://test.txt");
        File file2 = new File("E://newtest.txt");
        try {
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            byte[] bs = new byte[1024*1024*2];
            int length = 0;
            while (true){
                length = fileInputStream.read(bs);
                if(length == -1){
                    break;
                }else {
                    fileOutputStream.write(bs,0,length);
                    System.out.println("文件已经读取和存储完毕，请到相关目录下查看");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
            fileInputStream.close();
        }
    }
}
