package 字符操作;

import java.util.HashMap;

/**
 * @Author Li Yang
 * @Date 22/04/08 21:51
 * @Version 1.0
 */
public class LeetCode_easy_205_同构字符串 {
    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
     * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     * 示例:
     * 输入：s = "egg", t = "add"
     * 输出：true
     *
     * 输入：s = "foo", t = "bar"
     * 输出：false
     *
     * 输入：s = "paper", t = "title"
     * 输出：true
     *
     * 限制
     * 1 <= s.length <= 5 * 104
     * t.length == s.length
     * s 和 t 由任意有效的 ASCII 字符组成
     *
     * 注：这题同LeetCode 290. 单词规律
     */
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
