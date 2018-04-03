package xx.yy.concurrent;

import java.util.ArrayList;
import java.util.List;

public class Hello {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Long[] lon = (Long[]) list.toArray(new Long[0]);
        System.err.println(lon);
    }
}
