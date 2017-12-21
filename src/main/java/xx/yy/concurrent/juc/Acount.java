package xx.yy.concurrent.juc;

/**
 * Created by tingyun on 2017/12/21.
 */
public class Acount {

    private int balance;

    public Acount(int balance) {
        this.balance = balance;
    }

    synchronized public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    synchronized public void deposit(int amount) {
        balance += amount;
    }
    // 等价于
    public void deposit1(int amount){
        synchronized(this){
            balance +=amount;
        }
    }
}
