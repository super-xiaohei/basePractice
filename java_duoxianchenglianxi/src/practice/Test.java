package practice;

public class Test {

    public static void main(String[] args) {
        //创建一个动物对象
        Animal animal = new Animal();
        //创建生产者线程主体类
        new Thread(new Productor(animal)).start();
        //创建一个消费者线程主体类
        new Thread(new Customer(animal)).start();
    }
}
