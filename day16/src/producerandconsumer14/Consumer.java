package producerandconsumer14;

public class Consumer implements Runnable{
    private  Resource resource;
    private boolean sw = true;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (sw){
            resource.reduce(2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        this.sw = false;
    }
}
