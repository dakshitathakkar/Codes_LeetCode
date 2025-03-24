class FooBar {
    private int n;
    // private final ReentrantLock lock;
    private boolean fooPrinted;
    private boolean barPrinted;
    // private Semaphore s2;
    public FooBar(int n) {
        this.n = n;
        // this.lock = new ReentrantLock();
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {  
            // System.out.println(fooPrinted + " " + barPrinted);
            if(i==0){
        	printFoo.run();
            }
            else{
                while(!barPrinted){
                    wait();
                }
                printFoo.run();
            }
            fooPrinted = true;
            barPrinted = false;
            notifyAll();

        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // System.out.println("Inside bar:: " + fooPrinted + " " + barPrinted);

            while(!fooPrinted){
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            barPrinted = true;
            fooPrinted = false;
            notifyAll();
        }
    }
}