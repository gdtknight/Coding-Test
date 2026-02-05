import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> all = new HashMap<>();
        HashMap<String, Integer> cross = new HashMap<>();
        
        String cur;
        
        for (int idx = 0; idx < str1.length() - 1; idx++) {
            if (('A' <= str1.charAt(idx) && str1.charAt(idx) <= 'Z')
                && ('A' <= str1.charAt(idx + 1) && str1.charAt(idx + 1) <= 'Z')) {
                cur = str1.substring(idx, idx + 2);
                map1.put(cur, map1.getOrDefault(cur, 0) + 1);
            }
        }
        
        for (int idx = 0; idx < str2.length() - 1; idx++) {
            if (('A' <= str2.charAt(idx) && str2.charAt(idx) <= 'Z')
                && ('A' <= str2.charAt(idx + 1) && str2.charAt(idx + 1) <= 'Z')) {
                cur = str2.substring(idx, idx + 2);
                map2.put(cur, map2.getOrDefault(cur, 0) + 1);
            }
        }
        
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                all.put(key, Math.max(map1.get(key), map2.get(key)));
                cross.put(key, Math.min(map1.get(key), map2.get(key)));
            }
            else {
                all.put(key, map1.get(key));
            }
        }
        
        for (String key : map2.keySet()) {
            if (map1.containsKey(key))
                continue ;
            all.put(key, map2.get(key));
        }
        
        
        Float result = (float) cross.values().stream().mapToInt(Integer::intValue).sum() / (float) all.values().stream().mapToInt(Integer::intValue).sum() * 65536;
        if (all.keySet().size() == 0)
            result = (float) 65536;
        return  result.intValue();
    }
}