package Base;

public class fangfachongzai {
    int id;
    String name;
    String pwd;

    public fangfachongzai(){

    }

    public fangfachongzai(int id,String name){
        super();    //构造方法的第一句总是super(); 如果不写系统自动添加
        this.id = id;   //此处等号右边的是当前方法的输入值，this.id为全局的id
        this.name = name;
    }

    public fangfachongzai(int id,String name,String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }


    public static void main(String[] args) {
        fangfachongzai f1 = new fangfachongzai();
        fangfachongzai f2 = new fangfachongzai(101,"高小七");
        fangfachongzai f3 = new fangfachongzai(100,"高淇","123456");
    }
}
