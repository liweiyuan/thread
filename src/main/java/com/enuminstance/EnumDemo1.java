package com.enuminstance;

/**
 * Created by tingyun on 2017/12/14.
 */
public class EnumDemo1 {
    public static void main(String[] args) {
//直接引用
        Day1 day = Day1.MONDAY;
    }
}
//定义枚举类型
enum Day1 {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
