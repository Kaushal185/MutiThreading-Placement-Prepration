package Oops.allAboutMaps;

import java.util.Collections;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.HashMap;
public class AllAboutHashMaps {

    public static void main(String[] args) {

        /*
            A normal HashMap is not thread safe. If multiple threads modify it simultaneously, it can lead to:
            inconsistent data
            infinite loops during resizing
            corrupted map structure
         */
        HashMap<String,Integer>m = new HashMap<>();


        //One possible fix is using Collections.synchronizedMap():
        //However, this locks the entire map, which reduces performance when many threads access it.
        Map<String,Integer> syncMap = Collections.synchronizedMap(new HashMap<>());


        //ConcurrentHashMap solves this problem by allowing multiple threads to access different parts of the map simultaneously.
        //ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        // Java 7 => segments based locking => 16 segments => smaller hashmaps
        // The map was divided into segments, and each segment had its own lock. So multiple threads could modify different segments simultaneously.
        // read: do not require locking unless there is write operation happening on the same segment
        // write: lock

        // java 8 => no segmentation
        //           compare-and-swap approach => no locking except resizing or collision
        // map.put(null, 10); // not allowed

        Map<Integer,Integer> hashMap= new HashMap<>();
        for(int i=0;i<100;i++){
            int val = i%7;
          if(val == 0){
              if( hashMap.containsKey(i)){
                  hashMap.put(i,hashMap.get(i)+1);
              }else{
                  hashMap.put(i,1);
              }
          }
        }
        System.out.println();
        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println();
        System.out.println();
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0;i<100;i++){
            int val = i%7;
            if(val == 0){
                if( tm.containsKey(i)){
                    tm.put(i,tm.get(i)+1);
                }else{
                    tm.put(i,1);
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry: tm.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
