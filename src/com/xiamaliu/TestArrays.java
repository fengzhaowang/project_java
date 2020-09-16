package com.xiamaliu;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        int[] a = {100,30,20,15,50,600,40};

        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.binarySearch(a,20));

    }
}
