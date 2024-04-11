import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        final int ALPHABET_LEN = 26;
        int[] minTouch = new int[ALPHABET_LEN];
        
        Arrays.fill(minTouch, 101);
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                minTouch[key.charAt(i) - 'A'] = Math.min(minTouch[key.charAt(i) - 'A'], i + 1);
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int idx = 0; idx < targets.length; idx++) {
            String target = targets[idx];
            int sum = 0;
            boolean canMake = true;
            
            for (int j = 0; j < target.length(); j++) {
                if (minTouch[target.charAt(j) - 'A'] == 101) {
                    canMake = false;
                    break;
                }
                sum += minTouch[target.charAt(j) - 'A'];
            }
            
            answer[idx] = canMake ? sum : -1;
        }
        
        return answer;
    }
}