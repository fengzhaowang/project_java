package Base;

public class Polymorphism {
    public static void main(String[] args) {
        Animal a = new Animal();
        animalCry(a);
        /**
         * 下面的animalCry()方法传进去的应该是Animal，但现在传进去的是Dog，没有报错，并触发了Dog重写的方法
         * 这就是多态
         * 父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了
         * Dog是Animal的子类，把子类对象传到父类后，就触发了子类的方法
         * 因为对象都是Animal类，传的对象不一样，所以调用的shout()方法也就不一样
         * 传哪个对象，就调用哪个对象的方法
         * 好处：如果没有多态，当传的对象或参数类型不同时，必须要重新写方法，否则不能一起使用
         */
        Dog d = new Dog();//由于Dog类是Animal类的子类，所以可以写成Animal d = new Dog();同下
        //Animal dd = new Dog();
        animalCry(d);
        Cat c = new Cat();
        animalCry(c);
    }
    static void animalCry(Animal a){
        a.shout();
    }
    //好处：如果没有多态，当传的对象或参数类型不同时，必须要重新写方法，否则不能一起使用
    /*static void animalCry(Dog d){
        d.shout();
    }
    static void animalCry(Cat c ){
        c.shout();
    }*/
}
class Animal{
    public void shout(){
        System.out.println("叫了一声！");
    }
}
//对Animal类进行了继承
class Dog extends Animal{
    //对shout()方法进行了重写
    @Override
    public void shout(){
        System.out.println("汪汪汪！");
    }
}
//对Animal类进行了继承
class Cat extends Animal{
    //对shout()方法进行了重写
    @Override
    public void shout(){
        System.out.println("喵喵喵！！");
    }
}