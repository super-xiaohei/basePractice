package com.suncaper;

import java.io.File;


/**
 * @author zyq
 * @date 2020/11/11 - 10:29
 */
public class TestDemo {
    public static void main(String[] args) {
        CountLines countLines = new CountLines();
        File file = new File("C://Users//Administrator//IdeaProjects");
        long time1 = System.currentTimeMillis();
        countLines.showAllDirectory(file," ");
        countLines.showJavaDirectoryNo();
        countLines.countCodeLines();
        countLines.showCodeLines();
        long time2 = System.currentTimeMillis();
        System.out.println("统计总耗时  " + (time2 - time1));
    }
}
