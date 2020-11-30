package thread;

public class RunableMyObject implements Runnable{
    private MyObject myObject;
    public RunableMyObject(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.add();
    }
}
