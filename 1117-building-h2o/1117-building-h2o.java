class H2O {
    private final Semaphore H = new Semaphore(2);
    private final Semaphore O = new Semaphore(0);
    public volatile int countH = 0;
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		H.acquire();
        System.out.println("inside H::: " +countH);
        countH++;
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if(countH == 2){
            O.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire();
        System.out.println("inside O::: " +countH);

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        countH = 0;
        H.release();
        H.release();
    }
}