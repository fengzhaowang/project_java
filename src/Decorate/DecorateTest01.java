package Decorate;

/**
 * 实现放大器对声音的放大功能
 */
public class DecorateTest01 {
    public static void main(String[] args) {
        Person p = new Person();
        p.say();

        Amplifier am = new Amplifier(p);
        am.say();
    }
}
interface Say{
    void say();
}
class Person implements Say{
    //属性
    private int voice = 10;
    @Override
    public void say() {
        System.out.println("人的声音为：" + this.voice);
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}
//放大器
class Amplifier implements Say{
    //添加属性
    private Person p;
    //传入对象
    Amplifier(Person p){
        this.p = p;
    }
    @Override
    public void say() {
        //调用原对象的方法进行处理
        System.out.println("人的声音为："+p.getVoice()*100);
        System.out.println("噪音。。。。。");
    }
}