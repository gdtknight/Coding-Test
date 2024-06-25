import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {        
        Set<Integer> sums = new HashSet<>();
        
        for (int start = 0; start < elements.length; start++) {
            for (int len = 1; len <= elements.length; len++) {
                sums.add(calculateSum(elements, start, len));
            }
        }
        
        return sums.size();
    }
    
    int calculateSum(int[] elements, int start, int len) {
        int sum = elements[start];
        int idx = start;
        
        while(--len > 0) {
            idx = (idx + 1) % elements.length;
            sum += elements[idx];
        }
        
        return sum;
    }
}