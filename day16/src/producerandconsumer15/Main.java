package producerandconsumer15;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource(20);
        new Producer(resource,"生产者1").start();
        new Producer(resource,"生产者2").start();
        new Producer(resource,"生产者3").start();


        new Consumer(resource,"消费者1").start();
        new Consumer(resource,"消费者2").start();
    }
}
