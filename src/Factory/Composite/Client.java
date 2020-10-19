package Factory.Composite;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 09 : 39
 * @Description: todo
 */
public class Client {
    public static void main(String[] args) {
        Folder c1 = new Folder("我的收藏");
        AbstractFile c2,c3,c4,c5,c6,c7;
        c2 = new ImageFile("老高的大头像.jpb");
        c3 = new TextFile("Hello.txt");

        //单独杀毒
        c2.killVirus();
        c3.killVirus();

        System.out.println("#########");

        //组合模式杀毒
        c1.add(c2);
        c1.add(c3);
        c1.killVirus();

        System.out.println("#########");

        Folder c11 = new Folder("电影文件夹");
        c4 = new VideoFile("笑傲江湖.avi");
        c5 = new VideoFile("大笑江湖.avi");
        c6 = new VideoFile("神雕侠侣.avi");
        c11.add(c4);
        c11.add(c5);
        c11.add(c6);
        c1.add(c11);
        c1.killVirus();
    }
}
