package Oops.passByValueAndRef;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Student{
    int id;

}
class Main {

    private static void fun(Student a){
        Student student = new Student();
        student.id = 2;
        a = student;
    }

    public static void main(String args[]) throws InterruptedException{
        Student x = new Student();
        x.id = 1;
        fun(x);
        System.out.println(x.id);
    }


}
