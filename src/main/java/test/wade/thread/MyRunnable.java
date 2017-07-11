package test.wade.thread;


public class MyRunnable implements Runnable {

    private Foo foo = new Foo();

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread ta = new Thread(myRunnable, "Thread-A");
        Thread tb = new Thread(myRunnable, "Thread-B");
        ta.start();
        tb.start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            this.fix(30);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + foo.getX());
        }
    }

    private int fix(int y) {
        return foo.fix(y);
    }
}
