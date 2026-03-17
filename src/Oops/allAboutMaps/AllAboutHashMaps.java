package Oops.allAboutMaps;

import java.util.Collections;
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
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        // Java 7 => segments based locking => 16 segments => smaller hashmaps
        // The map was divided into segments, and each segment had its own lock. So multiple threads could modify different segments simultaneously.
        // read: do not require locking unless there is write operation happening on the same segment
        // write: lock

        // java 8 => no segmentation
        //           compare-and-swap approach => no locking except resizing or collision
        // map.put(null, 10); // not allowed

    }
}
