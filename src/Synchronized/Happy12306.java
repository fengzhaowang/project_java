package Synchronized;

public class Happy12306 {
    public static void main(String[] args) throws InterruptedException {
        Web12306 c = new Web12306(4, "happy sxt");
        new Passenger(c, "老高", 2).start();
        Thread.sleep(100);
        new Passenger(c, "老裴", 1).start();
    }
}

//顾客
class Passenger extends Thread {
    int seats;

    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}

//火车票网
class Web12306 implements Runnable {
    int available;
    String name;

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        /**
         * 此处需要获取到Passenger里面的seats，可以通过继承Thread类，
         * 然后通过Thread.currentThread()获取其子类Passenger，就可以强转到Passenger的seats属性
         */
        Passenger p = (Passenger)Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if (flag) {
            System.out.println(Thread.currentThread().getName() + "出票成功，" + "-<位置为" + p.seats);
        } else {
            System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不够");
        }
    }

    public synchronized boolean bookTickets(int seats) {
        System.out.println("可用票数为：" + available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}