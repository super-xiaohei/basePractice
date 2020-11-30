package practice;

public class Productor implements Runnable{
    private Animal animal;

    public Productor() {
    }

    public Productor(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                this.animal.set("小黑","是一个爱学习的好青年!");
            }else{
                this.animal.set("吴娟","也是一个爱学习的好青年!");
            }
        }
    }
}
