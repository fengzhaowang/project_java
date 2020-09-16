package com.xiamaliu;

import javax.swing.*;
import java.awt.*;

public class BallGames2 extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.jpg");

    double x = 100;
    double y = 100;
    double degree = 3.14/3; //弧度，此处是60度

    //画窗口的方法
    public void paint(Graphics g){
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        if (y>500-40-30 || y<40+40){    //500是高度，40是桌子的宽度，30是台球的直径， 后面的40，一个是桌子的宽度，一个是窗口的宽度
            degree = -degree;
        }
        if (x>850-40-30 || x < 40){
            degree = 3.14-degree;
        }
    }
    //窗口的加载方法
    void launchFrame(){
        setSize(850,500);
        setLocation(400,400);
        setVisible(true);

        //重画窗口
        while (true){
            repaint();
            try {
                Thread.sleep(40);//40毫秒，1秒1000毫秒，1秒执行25次
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //main方法是程序执行的入口
    public static void main(String[] args) {
        BallGames2 game = new BallGames2();
        game.launchFrame();
    }
}
