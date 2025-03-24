class Foo {
    boolean first;
    boolean second;
    boolean third;
    public Foo() {
        first = false;
        second = false;
        third = false;
    }

    public synchronized void  first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.first = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        // Thread.sleep(1000);
        System.out.println("In second thread, value of first: " + first);
        while(!first){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        System.out.println("In third thread, value of first: " + first);
        System.out.println("In third thread, value of second: " + second);
        // Thread.sleep(1000);

        while(!first || !second){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        third = true;
        // notifyAll();
    }
}