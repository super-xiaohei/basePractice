package producerandconsumer14;

import org.junit.Test;

public class Main {
    @Test
    public static void main(String[] args) {
        Resource resource = new Resource(200);
        new Thread(new Consumer(resource),"消费者1").start();
        new Thread(new Consumer(resource),"消费者2").start();
        new Thread(new Producer(resource),"生产者1").start();
        new Thread(new Producer(resource),"生产者2").start();
        new Thread(new Producer(resource),"生产者3").start();
        new Thread(new Producer(resource),"生产者4").start();
    }
}
