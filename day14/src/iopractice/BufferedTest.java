package iopractice;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 回复文本文件“恢复顺序in.txt”的文本顺序(字符流)
 */
public class BufferedTest {
    @Test
    public static void main(String[] args) throws IOException {
        //创建map集合，保存文本数据，键为序号，值为文字
        Map<String,String> lineMap = new HashMap<>();
        //创建流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E://恢复顺序in.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E://恢复顺序out.txt"));
        //读取取数据
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            //解析文本
            String[] split = line.split("\\.");
            //保存到集合
            lineMap.put(split[0],split[1]);
        }
        //释放资源
        bufferedReader.close();
        //遍历集合
        for(int i = 1;i < lineMap.size();i++){
            String key = String.valueOf(i);
            //获取map中的文本
            String value = lineMap.get(key);
            //写出拼接文本
            bufferedWriter.write(key + "." + value);
            //写出换行
            bufferedWriter.newLine();
        }
        //释放资源
        bufferedWriter.close();
        System.out.println("恢复顺序完成！");
    }
}
