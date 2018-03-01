package xx.yy.concurrent.laoma.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingyun on 2018/3/1.
 * 读取某个目录下的所有文件
 */
public class ReadFile {

    public static void main(String[] args) {
        test("D:/应用实例/自己学习/netty");
    }

    private static void test(String fileDir) {
        List<File> fileList=new ArrayList<File>();
        File file=new File(fileDir);
        File[] files=file.listFiles();
        if(files==null){
            return;
        }
        //遍历,目录下的所有文件
        for(File f:files){
            if(f.isFile()){
                fileList.add(f);
            }else if(f.isDirectory()){
                System.out.println(f.getAbsolutePath());
                test(f.getAbsolutePath());
            }
        }
        for (File f1 : fileList) {
            System.out.println(f1.getName());
        }
    }
}
