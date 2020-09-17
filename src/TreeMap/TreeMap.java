package TreeMap;

import java.util.Map;

public class TreeMap {
    public static void main(String[] args) {
        Map<Integer,String> treemap1 = new java.util.TreeMap<>();
        treemap1.put(20,"aa");
        treemap1.put(3,"bb");
        treemap1.put(6,"cc");

        //keySet():将Mao中所有的键存入到set集合中。因为set具备迭代器，所有可迭代方式去除的所有的键，在根据get方法，获取每一个键对应的值
        //迭代后只能通过get()取key
        for (Integer key:treemap1.keySet()){
            System.out.println(key + "---" + treemap1.get(key));
        }


        Map<Emp,String> treemap2 = new java.util.TreeMap<Emp, String>();
        treemap2.put(new Emp(100,"张三",50000),"张三是个好小伙");
        treemap2.put(new Emp(200,"李四",50000),"李四还行");
        treemap2.put(new Emp(150,"王五",50000),"王五是个实习生");

        for (Emp key:treemap2.keySet()){
            System.out.println(key + "---" + treemap2.get(key));
        }
    }


}



//根据自己的值进行排序
class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:"+id+",name:"+name+",salary"+salary;
    }

    //自定义比较
    @Override
    public int compareTo(Emp o) {
        //return 负数：小于  0：等于  正数：大于
        if (this.salary > o.salary){
            return 1;
        }else if (this.salary < o.salary){
            return -1;
        }else{
            if (this.id > o.id){
                return 1;
            }else if(this.id < o.id){
                return -1;
            }else{
                return 0;
            }
        }
    }
}