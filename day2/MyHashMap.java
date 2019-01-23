package org.day2;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {


    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("1","2");
    }



    class Entry<K,V> implements Map.Entry<K,V> {
        K key ;
        V value;
        int hash;
        Entry<K,V> next;

        Entry(int hash,K key,V value,Entry<K,V> next){
            this.hash = hash;
            this.key = key;
            this.next = next;
            this.value = value;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public Object setValue(Object value) {
            return null;
        }
    }



}
