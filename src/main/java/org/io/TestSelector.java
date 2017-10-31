package org.io;

import java.nio.channels.Selector;

/**
 * Created by tingyun on 2017/10/30.
 */
public class TestSelector {
    private static final int MAXSIZE = 5;

    public static final void main(String argc[]) {
        Selector[] sels = new Selector[MAXSIZE];

        try {
            for (int i = 0; i < MAXSIZE; ++i) {
                sels[i] = Selector.open();
                //sels[i].close();
            }
            Thread.sleep(30000);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
}
}
