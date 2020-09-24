package Base;

import javax.lang.model.element.NestingKind;

public class TestArrayCopy {
    public static void main(String[] args) {
//        testBasicCopy();

//        testBasicCopy2();

        String[] arr = {"阿里","百度","京东","亚马逊","淘宝"};
//        removeElement(arr, 2);
        extendChange();
    }
    //数组的拷贝
    public static void testBasicCopy(){
        String[] arr1 = {"aa","bb","cc","dd","ee"};
        String[] arr2 = new String[10];
        System.arraycopy(arr1,2,arr2,6,3);
        for (int i = 0; i < arr2.length; i++){
            System.out.println(i + "----" + arr2[i]);
        }
    }
    //测试从数组中删除某个元素（本质还是数组的拷贝）
    public static void testBasicCopy2(){
        String[] arr1 = {"aa","bb","cc","dd","ee"};
        System.arraycopy(arr1,2,arr1,2-1,arr1.length-2);
        arr1[arr1.length-1] = null;
        for (int i = 0; i < arr1.length; i++){
            System.out.println(i + "----" + arr1[i]);
        }
    }

    //封装一个删除指定元素的方法,并将原数组返回（本质上还是数组的拷贝）
    public static String[] removeElement(String[] arr,int index){
        System.arraycopy(arr,index,arr,index-1,arr.length-index);
        arr[arr.length-1] = null;
        for (int i = 0; i < arr.length; i++){
            System.out.println(i + "----" + arr[i]);
        }
        return arr;
    }

    //数组的扩容
    public static void extendChange(){
        String[] arr1 = {"aa","bb","cc","dd"};
        String[] arr2 = new String[arr1.length+10];
        System.arraycopy(arr1,0,arr2,0,arr1.length);
        for (String temp:arr1){
            System.out.println(temp);
        }
    }


}
