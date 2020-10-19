package Factory.Bridge;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 08 : 34
 * @Description: 未使用桥接模式
 */
public interface Computer {
    void sale();
}
class Desktop implements Computer{
    @Override
    public void sale() {
        System.out.println("销售台式电脑！");
    }
}
class Laptop implements Computer{
    @Override
    public void sale() {
        System.out.println("销售笔记本电脑！");
    }
}
class Pid implements Computer{
    @Override
    public void sale() {
        System.out.println("销售平板电脑！");
    }
}

class LenvoDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("联想台式机");
    }
}
class LenvoLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("联想笔记本");
    }
}
class LenvoPid extends Pid{
    @Override
    public void sale() {
        System.out.println("联想平板电脑");
    }
}

class DellDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("戴尔台式机");
    }
}
class DellLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("戴尔笔记本");
    }
}
class DellPid extends Pid{
    @Override
    public void sale() {
        System.out.println("戴尔平板电脑");
    }
}

class ShenzhouDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("神州台式机");
    }
}
class ShenzhouLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("神州笔记本");
    }
}
class ShenzhouPid extends Pid{
    @Override
    public void sale() {
        System.out.println("神州平板电脑");
    }
}