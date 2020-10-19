package Factory.Composite;

import Base.Abstract;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 09 : 25
 * @Description: 抽象构建
 */
public interface AbstractFile {
    void killVirus();//杀毒
}
class ImageFile implements AbstractFile{
    private String name;
    public ImageFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println("--图片文件"+name+"，进行查杀！");
    }
}
class TextFile implements AbstractFile{
    private String name;
    public TextFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println("--文本文件"+name+"，进行查杀！");
    }
}
class VideoFile implements AbstractFile{
    private String name;
    public VideoFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println("--视频文件"+name+"，进行查杀！");
    }
}
@SuppressWarnings("all")
class Folder implements AbstractFile{
    private String name;
    //定义容器，用来存放本容器构建下的子节点
    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file){
        list.add(file);
    }
    public void remove(AbstractFile file){
        list.remove(file);
    }
    public AbstractFile getCild(int index){
        return list.get(index);
    }
    @Override
    public void killVirus() {
        System.out.println("--文件夹："+name+"，进行查杀");
        for (AbstractFile file:list){
            file.killVirus();
        }
    }
}