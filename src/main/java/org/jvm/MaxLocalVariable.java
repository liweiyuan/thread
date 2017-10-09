package org.jvm;

/**
 * Created by spark on 17-10-9.
 */
public class MaxLocalVariable {

    public void a() {
        int a = 0;
        System.out.println(a);
        int b = 1;
    }

    public void b() {
        {
            int a = 0;
            System.out.println(a);
        }
        int b = 9;

    }
}
