package java8.stream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Encoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        JSONObject map = new JSONObject();
        map.put("down_x",URLEncoder.encode("$he$","UTF-8"));
        map.put("down_y",87);
        map.put("slot_w",20);
        map.put("slot_h",30);
        try {
            String msg="&sk="+URLEncoder.encode(map.toString(),"UTF-8");
            System.out.println(msg);
            System.out.println(map.toString());
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

    }
}
