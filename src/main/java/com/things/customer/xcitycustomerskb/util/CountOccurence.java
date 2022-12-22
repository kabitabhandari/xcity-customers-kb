package com.things.customer.xcitycustomerskb.util;

import java.util.HashMap;
import java.util.Locale;

public class CountOccurence {
    public static void main(String[] args) {
        String s = "Anagram";
        String p = "margana";

        System.out.println(checkAnagram(s, p));
    }

        public static boolean checkAnagram(String s, String p) {
            HashMap<Character, Integer> map1 = (findOccurence(s.toLowerCase(Locale.ROOT)));
            HashMap<Character, Integer> map2 = (findOccurence(p.toLowerCase(Locale.ROOT)));

            System.out.println(map1);
            System.out.println(map2);
            if (map1.equals(map2)) {
                return true;
            }
            return false;
        }




        public static HashMap <Character, Integer> findOccurence(String str) {
            HashMap <Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                } else {
                    map.put(str.charAt(i), 1);
                }

            }
            return map;
        }


    }
