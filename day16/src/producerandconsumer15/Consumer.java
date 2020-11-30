package producerandconsumer15;

public class Consumer extends Thread {
    private Resource resource;
    private boolean sw = true;

    public Consumer(Resource resource,String threadName){
        this.resource = resource;
        super.setName(threadName);
    }

    public void run(){
        while (true){
            resource.reduce(4);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        this.sw = false;
    }
}
