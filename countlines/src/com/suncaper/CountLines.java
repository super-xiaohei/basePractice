package com.suncaper;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zyq
 * @date 2020/11/11 - 9:48
 */
public class CountLines {
    private Integer javaDirectoryNo; //后缀为.java文件的总数
    private long lines;//所有java文件的总行数
    //定义一个装符合后缀名搜索的文件集合
    private static List<String> listByShuffix = new ArrayList<>();
    //列出文件下的所有目录
    public  void showAllDirectory(File file, String s){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if(file1.isDirectory()){//是一个文件夹
                    //System.out.println(s + file1.getName());
                    showAllDirectory(file1,s + "  ");
                }else{
                    //不是文件夹就查找后缀为.java的文件
                    if(file1.getName().toLowerCase().endsWith(".java")){
                        System.out.println(s + file1.getName());
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                        listByShuffix.add(file1.getAbsolutePath());//这里将文件的绝对路径存入到listByShuffix中
                        System.out.println("    " + file1.getAbsolutePath());
                    }
                }
            }
        }else {
            if(file.getName().toLowerCase().endsWith(".java")) {
                listByShuffix.add(file.getAbsolutePath());
                System.out.println("    " + file.getAbsolutePath());
            }
        }
    }
    //显示总共有多少个后缀为.java的文件
    @Test
    public void showJavaDirectoryNo(){
        System.out.println("总共有 " + listByShuffix.size() + " 个后缀为.java的文件");
    }

    //循环遍历每一个java文件，并统计所有java文件的总行数
    @Test
    public long countCodeLines(){
        FileInputStream in = null;
        for (int i = 0; i < listByShuffix.size(); i++) {
            try {
                in = new FileInputStream(listByShuffix.get(i));
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                byte[] bs = new byte[1024*1024*100];
                String s;
                while (true){
                    if((s = br.readLine()) == null){
                        break;
                    }else if(s.trim().length() == 0){
                        continue;
                    }else {
                        lines++;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    public void showCodeLines(){
        System.out.println("java代码总共有 " + lines + " 行!");
    }

}
