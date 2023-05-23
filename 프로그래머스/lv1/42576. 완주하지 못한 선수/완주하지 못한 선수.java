import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        Arrays.stream(participant).forEach(p -> {
            map.put(p, map.getOrDefault(p, 0) + 1);
        });
        
        for (String p : completion) {
            map.put(p, map.get(p) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        return null;
    }
}