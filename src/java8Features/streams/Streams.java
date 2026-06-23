package java8Features.streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    collection can be converted into stream
    and after conversion we can apply declarative or functional
    collections => streams

    1. map() ->   map ke andar function denge
    2. filter() -> filter ke andar predicate denge
    3. reduce


 */
public class Streams {
    public static void main(String[] args) {

        //imperative approach
        int[] array = {1,2,3,4,5};
        int sum = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] % 2 == 0){
                sum += array[i];
            }
        }

        // stream
        int[] array2 = {1,2,3,4,5,8,12,16};
        int sum2 = Arrays.stream(array2).filter(n -> n%2 == 0).sum();
        System.out.println(sum2);

        List<Integer> squares = Arrays
                .stream(array2)
                .filter(n -> n%2 == 0)
                .map(n -> n* n)
                .boxed()
                .sorted((a,b) -> b-a)
                .collect(Collectors.toList());

        System.out.println("squares "+squares.toString());

        //convert list to stream
        List<String> list = Arrays.asList("apple","banana","cherry");
        Stream<String> stream = list.stream();// stream of string

        //array to stream
        String[] arr = {"banana","apple","orangle"};

        Stream<String>s = Arrays.stream(arr);
        Stream<Integer>t = Stream.of(1,2,3,4,5);
        Stream<Integer>v = Stream.iterate(0,n->n+1).limit(100);
        Stream<Integer>b = Stream.generate(()->(int)Math.random()).limit(5);

        List<Integer>list2 = Arrays.asList(12,3,4,56,4,3,9,11,25,34);
        List<Integer>filteredList =list2.stream().filter(n-> n%2 ==0).collect(Collectors.toList());
        System.out.println(filteredList);


        List<Integer> ps = Arrays.asList(1,1,2,4,5,5,6,6,6,7,8);

        Map<Integer, Long> map = ps.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(map);
        List<Integer> newList = ps.stream()
                .sorted((x, y) -> Long.compare(map.get(y), map.get(x)))
                .toList();

        System.out.println(arr.hashCode());

    }
}
