package com.example.fengxin.mykotlinproject;

/**
 * Created by fengxin on 22/02/2018.
 */

public class Test {

    public static void main(String[] args) {

        int[] arr = new int[]{8,2,1,0,3};
        int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
        String tel = "";

        for (int i : index) {
            System.out.println("i : " + i);
            System.out.println("arr[i] : " + arr[i]);
            tel += arr[i];
        }
        System.out.println("联系方式 : " + tel);
    }

}
