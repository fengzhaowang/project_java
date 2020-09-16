package com.xiamaliu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历
 */
public class TestCalendar {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期（日期格式为：2020-6-8）：");
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date data = df.parse(str);
        Calendar c = new GregorianCalendar();
        c.setTime(data);

        int day = c.get(Calendar.DAY_OF_MONTH);
        int days = c.getActualMaximum(Calendar.DATE);

        System.out.println("日\t一\t二\t三\t四\t五\t六\t");

        c.set(Calendar.DAY_OF_MONTH,1);//设置天数从一号开始

        for (int i=1;i<c.get(Calendar.DAY_OF_WEEK);i++){
            System.out.print("\t");//获取第一天是星期几，然后会有几个空格
        }

        for (int i=1;i<=days;i++){
            if(day == c.get(Calendar.DAY_OF_MONTH)){
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");//输出今天
            }else{
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");//输出每一天
            }


            if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){//如果为星期六 则换行
                System.out.println();//换行
            }

            c.add(Calendar.DAY_OF_MONTH,1);//为下一次输出增加1
        }
    }
}
