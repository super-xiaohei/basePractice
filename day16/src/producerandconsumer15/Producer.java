package producerandconsumer15;

public class Producer extends Thread {
    private Resource resource;
    private boolean sw = true;

    public Producer(Resource resource,String thredName) {
        this.resource = resource;
        super.setName(thredName);
    }

    public void run(){
        while(sw){
            resource.add(2);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        this.sw = false;
    }
}
