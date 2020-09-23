package Thread;

/*
 * 静态代理设计模式（常用于打印日志）
 * 公共接口：
 * 1、真实角色
 * 2、代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyyMarry();
        //new Thread(具体线程对象).start();
    }
}
interface Marry{
    void happyyMarry();
}
//真实角色
class You implements Marry{
    @Override
    public void happyyMarry() {
        System.out.println("久旱逢甘雨，他乡遇故知，洞房花烛夜，金榜题名时！");
    }
}
//代理角色
class WeddingCompany implements Marry{
    //代理必须要有目标对象
    //真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyyMarry() {
        ready();
        this.target.happyyMarry();
        after();
    }
    private void ready(){
        System.out.println("布置猪窝。。。。");
    }
    private void after(){
        System.out.println("闹玉兔。。。。。");
    }
}