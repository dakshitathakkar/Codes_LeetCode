class FizzBuzz {
    private int n;
    private final Semaphore num = new Semaphore(1);
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzBuzz = new Semaphore(0);
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1; i<= n;i++){
            if(i%3 ==0 && i%5 !=0){
                fizz.acquire();
                printFizz.run();
                releaseLock(i+1);
            }
            
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1; i<= n;i++){
            if(i%3 !=0 && i%5 ==0){
                buzz.acquire();
                printBuzz.run();
                releaseLock(i+1);
            }
            
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 1; i<= n;i++){
            if(i%3 ==0 && i%5 ==0){
                fizzBuzz.acquire();
                printFizzBuzz.run();
                releaseLock(i+1);
            }
            
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<= n;i++){
            if(i%3 !=0 && i%5 !=0){
                num.acquire();
                printNumber.accept(i);
                releaseLock(i+1);
            }
            
        }
    }

    public void releaseLock(int i){
        if(i%3 !=0 && i%5 != 0){
            num.release();
        }
        else if(i%3==0 && i%5 == 0){
            fizzBuzz.release();
        }
        else if(i%3 == 0 && i%5 !=0){
            fizz.release();
        }
        else{
            buzz.release();
        }
    }
}