import java.util.Map;
import java.util.Set;
import java.util.HashMap;

class Solution {
    public int solution(String[] wants, int[] numbers, String[] discounts) {
        int WIN_SIZE = 10;
        int answer = 0;
        
        HashMap<String, Integer> products = new HashMap<>();
        Set<String> keySet;
        
        for (int idx = 0; idx < wants.length; idx++) {
            products.put(wants[idx], numbers[idx]);
        }
        
        keySet = products.keySet();
        
        for (int idx = 0; idx < WIN_SIZE; idx++) {
            if (products.containsKey(discounts[idx]))
                products.put(discounts[idx], products.get(discounts[idx]) - 1);
        }
        
        if (check(products, keySet))
            answer++;
        
        for (int idx = WIN_SIZE; idx < discounts.length; idx++) {
            if (keySet.contains(discounts[idx - WIN_SIZE]))
                products.put(
                	discounts[idx - WIN_SIZE],
                	products.getOrDefault(discounts[idx - WIN_SIZE], 0) + 1);
            if (keySet.contains(discounts[idx])) 
                products.put(
                	discounts[idx],
                	products.get(discounts[idx]) - 1);
            if (check(products, keySet)) {
                answer++;
            }
        }
        
        return (answer);
    }
    
    public boolean check(Map<String, Integer> map, Set<String> set) {
        for (String key : set) {
            if (map.containsKey(key) && map.get(key) != 0)
                return (false);
        }
        return (true);
    }
}