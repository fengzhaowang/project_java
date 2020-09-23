package Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HappyCinema2 {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        available.add(6);
        available.add(7);

        //顾客需要的位置
        List<Integer> cinema1 = new ArrayList<>();
        cinema1.add(1);
        cinema1.add(2);
        List<Integer> cinema2 = new ArrayList<>();
        cinema2.add(4);
        cinema2.add(5);
        cinema2.add(6);

        Cinema2 cinema = new Cinema2(available, "happy sxt");
        new Thread(new Customer2(cinema,cinema1),"老高").start();
        new Thread(new Customer2(cinema,cinema2),"老裴").start();
    }
}
//顾客
class Customer2 implements Runnable{
    Cinema2 cinema;
    List<Integer> seats;

    public Customer2(Cinema2 cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            List<Integer> surplus = cinema.getAvailable();
            if (flag) {
                System.out.println( Thread.currentThread().getName() + "出票成功，" + "-<位置为" + seats);
                System.out.println("剩余票位："+surplus);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不够");
            }
        }
    }
}

//影院
class Cinema2{
    List<Integer> available;//票的个数
    String name;//电影名称

    public Cinema2(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }
    public boolean bookTickets(List<Integer> seats){
        System.out.println("欢迎选购"+this.name+"，当前可用位置为：" + available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);
        //相减
        copy.removeAll(seats);
        //判断大小
        if(available.size() - copy.size() != seats.size()){
            return false;
        }
        //成功
        available = copy;
        return true;
    }

    public List<Integer> getAvailable() {
        return available;
    }
}