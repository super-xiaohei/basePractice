package producerandconsumer14;

public class Producer implements Runnable{
    private  Resource resource;
    private boolean sw = true;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (sw){
            resource.add(2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        this.sw = false;
    }
}
