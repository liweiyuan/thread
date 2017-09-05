package cn.concurrent.design;

/**
 * Created by spark on 17-9-5.
 * 不变模式:最常用的比如:String
 */
public final class Product {//确保没有子类
    private final String no;//私有属性，不会被其他对象获取
    private final String name;//final保证不会被2次赋值
    private final double price;

    public Product(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
