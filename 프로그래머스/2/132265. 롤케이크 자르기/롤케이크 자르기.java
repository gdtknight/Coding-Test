import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        if (topping.length == 1)
            return (0);
        int answer = 0;
        
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        left.put(topping[0], 1);
        
        for (int rIdx = 1; rIdx < topping.length; rIdx++) {
            right.put(topping[rIdx], right.getOrDefault(topping[rIdx], 0) + 1);
        }
        
        if (left.keySet().size() == right.keySet().size()) {
            answer++;
        }
        
        for (int cutIdx = 1; cutIdx < topping.length - 1; cutIdx++) {
            left.put(topping[cutIdx], left.getOrDefault(topping[cutIdx], 0) + 1);
            right.put(topping[cutIdx], right.get(topping[cutIdx]) - 1);
            if (right.get(topping[cutIdx]) == 0)
                right.remove(topping[cutIdx]);
        	if (left.keySet().size() == right.keySet().size())
        	    answer++;
        }
        return answer;
    }
}