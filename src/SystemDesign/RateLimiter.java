package SystemDesign;


import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

record Person(String name, int age) {}

public class RateLimiter {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();

        Person p = new Person("kaushal",21);
        System.out.println(p.name());
    }

}
