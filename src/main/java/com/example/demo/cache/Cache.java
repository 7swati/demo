package com.example.demo.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

   public final Map<String, Integer> CACHE = new ConcurrentHashMap<>();

   public int getRandomNumber(String monthYear){
       if(CACHE.containsKey(monthYear)){
           return CACHE.get(monthYear);
       } else {
           Random rand = new Random();
           int max = 5;
           int min = 4;
           int randomNum = rand.nextInt(max - min + 1) + min;
            CACHE.put(monthYear, randomNum);
       }
        return CACHE.get(monthYear);
   }
}
