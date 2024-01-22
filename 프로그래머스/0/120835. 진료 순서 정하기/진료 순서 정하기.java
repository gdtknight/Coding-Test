import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> patients = new HashMap<>();
        int[] answer = new int[emergency.length];
        
        for (int idx = 0; idx < emergency.length; idx++) {
            patients.put(emergency[idx], idx);
        }
        
        Arrays.sort(emergency);
        
        for (int idx = 0; idx < emergency.length; idx++) {
            answer[patients.get(emergency[idx])] = emergency.length - idx;
        }
        
        return answer;
    }
}