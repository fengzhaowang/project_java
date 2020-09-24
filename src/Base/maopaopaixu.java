package Base;

import java.util.Arrays;

public class maopaopaixu {
    public static void main(String[] args) {
        int[] array = {3,1,6,2,9,0,7,4,5,8};
        //每当循环一次，则选出一个最大的数
        for (int i=0;i<array.length-1;i++){
            boolean feifei = true;
            //里面的数字进行排序，每一次循环，都出出来一个最大的数
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int x = array[j];
                    array[j] = array[j+1];
                    array[j+1] = x;

                    feifei = false;
                }
                System.out.println(Arrays.toString(array));
            }
            if (feifei){
                break;
            }
            System.out.println("##########");
        }

    }
}
