package Thread;

public class IDownloader implements Runnable{
    private String url;
    private String name;

    public IDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoad(url,name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        IDownloader td1 = new IDownloader("http://upload.news.cecb2b.com/2014/0511/1399775432250.jpg", "phone.jpg");
        IDownloader td2 = new IDownloader("http://p1.pstatp.com/large/403c00037462ae2eee13", "spl.jpg");
        IDownloader td3 = new IDownloader("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg", "success.jpg");

        //借助代理类对象
        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();
    }
}
