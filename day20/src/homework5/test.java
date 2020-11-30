package homework5;

import org.junit.Test;

public class test {
    private static String doStr(String string,StringDemo stringDemo){
        String value = stringDemo.getValue(string);
        return value.toUpperCase();
    }

    @Test
    public static void main(String[] args) {
        System.out.println(doStr("i love chinese",(s)->{return s.substring(2,5);}));
    }
}
