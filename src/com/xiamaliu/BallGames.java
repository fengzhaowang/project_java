package com.xiamaliu;

import java.awt.*;
import javax.swing.*;

public class BallGames extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.jpg");

    double x = 100;
    double y = 100;
    boolean right = true;

    //画窗口的方法
    public void paint(Graphics g){
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        if(right){
            x = x + 10;
        }else{
            x = x - 10;
        }

        if(x>856-40-30){ //856是桌子的宽度，40是桌子边框的宽度，30是小球的宽度
            right = false;
        }
        if(x<40){   //40是桌子边框的宽度
            right = true;
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
        BallGames game = new BallGames();
        game.launchFrame();
    }
}
