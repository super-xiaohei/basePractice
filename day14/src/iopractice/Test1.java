package iopractice;

import org.junit.Test;

import java.io.File;

/**
 * 遍历所给定的目录的所有文件
 */
public class Test1 {
    @Test
    public static void main(String[] args) {
        File file = new File("D://XMind");
        show(file,"");
    }

    private static void show(File file, String s) {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if(file1.isDirectory()){
                    System.out.println(s + file1.getName());
                    show(file1,s + "");
                }else {
                    System.out.println(s + file1.getName());
                }
            }
        }else {
            System.out.println(file.getName());
        }
    }
}
