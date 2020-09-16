package com.xiamaliu;

public class ForEach {
    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int i = 0;i < 5;i++){
            arr[i] = 10*i;
        }
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("*********************");
        String[] arr2 = new String[3];
        arr2[0] = "张三";
        arr2[1] = "赵四";
        arr2[2] = "王五";
        for (String i : arr2){
            System.out.println(i);
        }
    }
}
