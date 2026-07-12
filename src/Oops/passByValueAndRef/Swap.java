package Oops.passByValueAndRef;

public class Swap {
    public static void swap(int x,int y){
        int temp = x;
        x = y;
        y = temp;

        // this x and y are copies so swap will not work
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a+" "+b);
    }
}
