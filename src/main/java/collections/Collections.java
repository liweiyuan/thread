package collections;

import org.apache.commons.lang3.StringUtils;

public class Collections {


    public static void main(String[] args) {

        String title="";
        String desc="";

        Boolean b=StringUtils.isAnyEmpty(title,desc);
        System.err.println(b);
        
        
        aoo();
    }

    private static void aoo() {
    }

}
