package Multithreading;

import java.util.Arrays;
import java.util.List;

//This is functional interface
interface StringFormatter{
    String format(String input);
}
interface Bio{
    void getBio(String input);
}
public class ExampleLambda {
    public static void main(String[] args) {
        StringFormatter formatter = new StringFormatter() {
            @Override
            public String format(String input){
                return input +"*";
            }
        };

        StringFormatter exclamation = (input)->input+"!";// implementation with lambda expression.
        System.out.println(exclamation.format("kaushal"));


        Bio bio = (input)-> System.out.println(input+" I am Engnieer");
        bio.getBio("kaushal");
    }

    // usage of lambda expression in streamAPI.
    public static void newmain() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        names.stream()
                // 1. Predicate: Filter names starting with 'A' or 'C'
                .filter(name -> name.startsWith("A") || name.startsWith("C"))

                // 2. Function: Transform the string to uppercase
                .map(String::toUpperCase)

                // 3. Consumer: Print each element
                .forEach(System.out::println);
    }
}
