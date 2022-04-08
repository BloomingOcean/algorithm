package 字符操作;

import java.util.HashMap;

/**
 * @Author Li Yang
 * @Date 22/04/08 21:51
 * @Version 1.0
 */
public class Leetcode_easy_205_同构字符串 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title")); // true
//        System.out.println(isIsomorphic("foo", "bar")); // false
//        System.out.println(isIsomorphic("badc", "baba")); // false
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len ;i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if ((sMap.containsKey(sc) && sMap.get(sc) != tc) || (tMap.containsKey(tc) && tMap.get(tc) != sc)) {
                return false;
            }
            sMap.put(sc, tc);
            tMap.put(tc, sc);
        }
        return true;
    }
}
