package homeworkcollection.test;

import homeworkcollection.main.EMS;
import org.junit.Test;

public class Main {
    @Test
    public static void main(String[] args) {
        EMS ems = new EMS("E://my_emps");
        ems.start();
    }
}
