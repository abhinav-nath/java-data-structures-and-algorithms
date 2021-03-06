package com.codecafe.ds.maps.concurrenthashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// The ConcurrentHashMap class is similar to HashMap
// except that it's thread-safe and allows modification while iteration

// https://www.journaldev.com/122/concurrenthashmap-in-java

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        Map<String, String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        
        System.out.println("ConcurrentHashMap before iterator: " + myMap);
        
        Iterator<String> it = myMap.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("3"))
                myMap.put(key + "new", "new3");
        }

        System.out.println("ConcurrentHashMap after iterator: " + myMap);

        // HashMap
        myMap = new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        
        System.out.println("HashMap before iterator: " + myMap);
        
        Iterator<String> it1 = myMap.keySet().iterator();

        while (it1.hasNext()) {
            String key = it1.next();
            if (key.equals("3"))
                myMap.put(key + "new", "new3");
        }

        System.out.println("HashMap after iterator: " + myMap);

    }

}