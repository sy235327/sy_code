package com.demo.test1;

public class Test {
    public static void main(String[] args) {
        int[] arr = {4,3,5,8,4,1,4};
    }

    /**
     * 快速排序 小到大
     * @param arr 数组
     * @param a 起始索引
     * @param b 结束索引
     * @int c 暂时存放参数位置
     * @return
     */
    public static int[] desc(int[] arr,int a,int b){
        for(int c = 0;b == 1;a++){

            //判断
            if (arr[a] > arr[a+1]){
                c = arr[a];
                arr[a] = arr[a+1];
                arr[a+1] = c;

                //递归
                return desc(arr,++a,--b);
            }
        }
        return null;
    }
}
