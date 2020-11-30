package practice1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    @Test
    public static void main(String[] args) {
       /* Scanner s = new Scanner(System.in);
        System.out.println("输入1：");
        String str1 = s.nextLine();
        System.out.println("输入2：");
        char str2 = s.nextLine().charAt(0);
        char[] chars = str1.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == str2) {
                count++;
            }
        }
        System.out.println("字符" + str2 + "出现了" + count + "次");*/
        /*String ss="123";
        int ii = Integer.parseInt(ss);
        System.out.println("字符类型转成整型："+ii);
        //toString方法：int类型转成数字字符串类型
        int ii2=123;
        String ss2 = Integer.toString(ii2);
        System.out.println("int类型转成数字字符串类型:"+ss);*/
        /*Date date = new Date();
        System.out.println(System.currentTimeMillis());
        System.out.println(date.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date.getTime());
        System.out.println(format);*/
        /*String ss = "2020-09-23";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(ss);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        /*Calendar calendar = Calendar.getInstance();
        // 获取年
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println(month);
        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        // 获取时
        int hour = calendar.get(Calendar.HOUR);
        System.out.println(hour);
        // int hour = calendar.get(Calendar.HOUR_OF_DAY);// 24小时表示
        // 获取分
        int minute = calendar.get(Calendar.MINUTE);
        System.out.println(minute);
        // 获取秒
        int second = calendar.get(Calendar.SECOND);
        System.out.println(second);*/
        /*//算算自己活了多少天
        Date date = new Date();
        long nowTime = date.getTime();
        System.out.println(nowTime); //从1970到现在有多久
        Calendar calendar = Calendar.getInstance();
        calendar.set(1998,05,29);
        Date agoTime = calendar.getTime(); //从1970开始到1998有多久
        long birth = agoTime.getTime();
        System.out.println(birth);
        System.out.println((nowTime-birth)/1000/60/60/24);*/
    }

}
