package com.xiamaliu;

import java.util.Arrays;

public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
        int temp = 0;

        for (var j = 0;j < values.length-1;j++){
            boolean temp2 = true;
            for (int i = 0;i < values.length-1-j;i++){
                if(values[i]>values[i+1]){
                    temp = values[i+1];
                    values[i+1] = values[i];
                    values[i] = temp;
                    temp2 = false;
                }
                System.out.println(Arrays.toString(values));
            }
            if (temp2){
                System.out.println("结束！！！！！！");
                break;
            }
            System.out.println("##################");
        }

    }
}
