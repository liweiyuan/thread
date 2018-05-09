package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("苹果", "apple", "火龙果", "香蕉", "梨子");

        //Map<Integer,String> maps= strings.stream().collect(Collectors.toMap(strings::get, strings->strings));

        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> collect=alpha.stream().map(String::toString).collect(Collectors.toList());
        System.out.println(collect.toString());
    }
}
