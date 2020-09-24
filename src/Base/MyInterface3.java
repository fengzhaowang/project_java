package Base;

/**
 * 接口可以多继承，但是类不能多继承
 */
public class MyInterface3 {
}
interface A{
    void testa();
}
interface B{
    void testb();
}

/**
 * 接口可以多继承，接口C继承接口A和B
 */
interface C extends A,B{
    void testc();
}
class Mysubclass implements C{
    @Override
    public void testa() {

    }
    @Override
    public void testb() {

    }
    @Override
    public void testc() {

    }
}