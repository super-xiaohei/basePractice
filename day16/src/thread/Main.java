package thread;

import org.junit.Test;

public class Main {
    @Test
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        //myObject.add();
        new Thread(new RunableMyObject(myObject),"线程A").start();
        new Thread(new RunableMyObject(myObject),"线程B").start();
    }
}
