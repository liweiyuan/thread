package callback;

/**
 * Created by tingyun on 2018/3/26.
 * 内部类的形式进行调用
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class DoWork implements DoJob{

        @Override
        public void fillBack(int a, int b, int result) {
            //todo
            System.out.println(name + "求助小红计算:" + a + " + " + b + " = " + result);
        }
    }

    public void callHelp(int a,int b){
        new SuperCalculator().add(a,b,new DoWork());
    }

}
