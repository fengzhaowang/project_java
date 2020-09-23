package Synchronized;

public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(20, "happy sxt");
        new Thread(new Customer(cinema,2),"老高").start();
        new Thread(new Customer(cinema,1),"老裴").start();
    }
}
class Customer implements Runnable{
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不够");
            }
        }
    }
}
//影院
class Cinema{
    private int available;//票的个数
    String name;//电影名称

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }
    public boolean bookTickets(int seats){
        System.out.println("可用位置为：" + available);
        if(seats > available){
            return false;
        }
        available -= seats;
        return true;
    }
}