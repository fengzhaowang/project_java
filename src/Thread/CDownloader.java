package Thread;

import java.util.concurrent.*;

/**
 * 了解创建线程的方式三：实现Callable方接口，重写Callable方法
 */
public class CDownloader implements Callable<Boolean>{
    private String url;
    private String name;

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoad(url,name);
        System.out.println(name);
        return true;
    }

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader td1 = new CDownloader("http://upload.news.cecb2b.com/2014/0511/1399775432250.jpg", "phone.jpg");
        CDownloader td2 = new CDownloader("http://p1.pstatp.com/large/403c00037462ae2eee13", "spl.jpg");
        CDownloader td3 = new CDownloader("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg", "success.jpg");

       //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> submit1 = ser.submit(td1);
        Future<Boolean> submit2 = ser.submit(td2);
        Future<Boolean> submit3 = ser.submit(td3);
        //获取结果
        Boolean r1 = submit1.get();
        Boolean r2 = submit2.get();
        Boolean r3 = submit3.get();
        //关闭服务
        ser.shutdownNow();
    }


}
