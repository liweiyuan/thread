package cn.concurrent.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by spark on 17-9-18.
 */
public class FutureRenderer {
    private final ExecutorService exec = Executors.newFixedThreadPool(20);

    void renderPage(CharSequence source) {
        final List<?> imageInfos = null;//scanForImageIndo(source);
        Callable<List<?>> task = new Callable<List<?>>() {
            @Override
            public List<?> call() throws Exception {
                List<?> result = new ArrayList();
                /*for(ImageInfo imageInfo:imageInfos){
                    result.add(imageInfo.downLoadImage());
                }*/
                return result;
            }
        };
        Future<List<?>> future = exec.submit(task);
        //文本文件
        //renderText(source);
        try {
            List<?> imageData = future.get();

            //加載圖片
            /*for(ImageData data:imageData){
                renderImage(data);
            }*/
        } catch (InterruptedException e) {
            //重新设置线程的中断状态
            Thread.currentThread().interrupt();
            e.printStackTrace();
            //由于不需要结果，因此取消任务
            future.cancel(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
