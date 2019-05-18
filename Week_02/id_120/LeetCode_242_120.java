package com.data.structure.hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zzl
 * @date 2019/5/18 19:37
 * @description
 */

public class HashTableDemo {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(char c:s.toCharArray()){
            String key= String.valueOf(c);
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.put(key,map.get(key)+1);
            }
        }
        for(char c:t.toCharArray()){
            String key=String.valueOf(c);
            if(!map.containsKey(key)){
                return false;
            }
            Integer count=map.get(key);
            if(count==1){
                map.remove(key);
            }else{
                map.put(key,map.get(key)-1);
            }
        }
        return true;
    }
}
