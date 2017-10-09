package org.jvm;

/**
 * Created by spark on 17-10-9.
 */
public class TestStackDemo {

    private static int count = 0;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable a) {
            System.out.println("deep of caling = " + count);
            a.printStackTrace();
        }
    }
}
