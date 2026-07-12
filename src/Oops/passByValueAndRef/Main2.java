package Oops.passByValueAndRef;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static void fun(Integer b){
        System.out.println(b);
        b = 2;
    }
    public static void addition(ArrayList<Integer> list1){

        for (int i = 0; i < 5; i++) {
            list1.add(i);
        }

        //list1 = new ArrayList<>(List.of(1,2,3,4));// list1 is copy so it will point to new object that's it
    }
    public static void main(String[] args) {
        Integer a = 10;
        fun(a);
        System.out.println(a);
        ArrayList<Integer> list = new ArrayList<>();
        // this is pass by value.
        /*
                a --> 10
                b -->10 // b is copy
                b --> 2 // now b is pointing to new value
         */
        addition(list);
        System.out.println(list);
    }
}
