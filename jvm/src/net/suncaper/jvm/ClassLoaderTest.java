package net.suncaper.jvm;

/**
 * @author zyq
 * @date 2021/1/3 - 16:04
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        Test test = new Test();
        String s = new String();
        System.out.println(test.getClass().getClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(test.getClass().getClassLoader().getParent()); //sun.misc.Launcher$ExtClassLoader@1b6d3586
        System.out.println(ClassLoader.class.getClassLoader());
//        System.out.println(test.getClass().getClassLoader().getParent().getParent());
//        System.out.println(s.getClass().getClassLoader());
    }


    public static class Test{

    }
}
