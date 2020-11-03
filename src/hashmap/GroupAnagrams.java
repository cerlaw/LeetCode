package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghongjie
 * @date 2020/10/30
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.solution(new String[]{"eat","tea","tan","ate","nat","bat"});

        char[] cc = new char[1];
        for (int i = 0; i < 10; i++) {
            cc[0]++;
        }
        System.out.println(String.valueOf(cc));
     }

    public List<List<String>> solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ca = new char[26];
            for (char c: strs[i].toCharArray()) {
                ca[c - 'a']++;
            }
            String s = new String(ca);
            System.out.println("s" + s);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
