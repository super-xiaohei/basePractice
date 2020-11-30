package producerandconsumer14;

public class Resource {
    private int count = 200;
    private int current = 0;

    public Resource() {
    }

    public Resource(int count) {
        this.count = count;
    }

    public synchronized void add(int i){
        if((current + i) >= count){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        current = current + i;
        System.out.println(Thread.currentThread().getName() + ": ++ 添加 ++ 了2个商品，目前数量是" + current);
        this.notifyAll();
    }
    //仓库减少商品的方法
    public synchronized void reduce(int i){
        while ((current - i) <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        current = current - i;
        System.out.println(Thread.currentThread().getName() + ": -- 减少 -- 了2个商品，目前数量是" + current);
        this.notifyAll();
    }
}
