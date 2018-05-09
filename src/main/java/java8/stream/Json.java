package java8.stream;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Json {

    public static void main(String[] args) {
        String targetCity="{\"type\":\"INCLUDE\",\"cities\":[11,22,33]}";

        JSONObject jsonObject=JSONObject.parseObject(targetCity);
        String str= (String) jsonObject.get("type");
        //System.out.println(jsonObject);
        //System.out.println(str);

        //AdAreaType adAreaType= (AdAreaType) jsonObject.get("type");
        List<Integer> cities= (List<Integer>) jsonObject.get("cities");

        //System.out.println(adAreaType);
        System.out.println(cities);
    }
}
