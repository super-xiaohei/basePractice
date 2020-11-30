package iozijie;

import org.junit.Test;

import java.io.*;

//读取硬盘中的一个文本文件的内容

/**
 * 字节流
 */
public class Main {
    @Test
    public static void main(String[] args) throws IOException {
        File file = new File("E://emps.txt");
        /*System.out.println(file.getAbsolutePath()); //获取文件的绝对路径，常用的*/

        /*if(file.exists()){
            file.delete();  //删除文件，只能删除一级，不能一次删除多级文件目录，不能删除不存在的文件可以使用listFiles（）循环删除下级文件，但不能删除文件夹
        }*/

        /*System.out.println(file.isDirectory());//判断是否是文件夹
        System.out.println(file.isFile());//判断是否是文件*/

       /* boolean newFile = file.createNewFile(); //创建一文件
        boolean mkdir = file.mkdir();//创建一个文件夹，只能建一级目录*/

        /*boolean mkdirs = file.mkdirs(); //可以创建多级目录*/

        /*long length = file.length(); //获取文件长度
        System.out.println(length); */

        /*InputStream inputStream = new FileInputStream(file);
        while (true){
            int read = inputStream.read();  //一个字节一个字节的读
            if(read == -1){
                break;
            }else {
                System.out.print((char) read);
            }
        }*/

       /* BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[300]; //每次读的字节数
        while (true) {
            int count = inputStream.read(bytes);  //读出很多
            if (count == -1) {
                break;
            } else {
                String str = new String(bytes,0,count);
                System.out.println(str);
            }
        }*/
       //字符字流相互转化(字节流转换成字符流指定编码)
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file)); //字节缓冲流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//字符缓冲流
        /*BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E://my_copt.txt")),"UTF-8"));

        String string = null;
        while ((string = bufferedReader.readLine()) != null){
            //System.out.println(string);
            bufferedWriter.write(string + "\n");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("ok");*/
    }
}
