package xx.yy.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tingyun on 2017/11/23.
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        Map<String,String> map=new ConcurrentHashMap<String, String>();

        map.put("java","Hadoop");

        System.err.println(map);

    }
}
