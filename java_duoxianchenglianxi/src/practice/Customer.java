package practice;

public class Customer implements Runnable{
    private Animal animal;

    public Customer() {
    }

    public Customer(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.animal.get();
        }
    }
}
