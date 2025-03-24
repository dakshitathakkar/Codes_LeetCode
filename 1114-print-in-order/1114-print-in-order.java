class Foo {
    private volatile boolean first;
    private volatile boolean second;
    public Foo() {
        first = false;
        second = false;
    }

    public synchronized void  first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.first = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        // Thread.sleep(1000);
        while(!first){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        // Thread.sleep(1000);

        while(!first || !second){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        // notifyAll();
    }
}