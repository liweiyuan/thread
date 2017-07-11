package test.wade.thread;


public class Test {

    public static void main(String[] args) {
        final NameList list=new NameList();
        list.add("aaa");
        class NameDropper extends Thread{
            @Override
            public void run() {
                String name = list.remove();
                System.out.println(name);
            }
        }
        Thread t1 = new NameDropper();
        Thread t2 = new NameDropper();
        t1.start();
        t2.start();
    }
}
