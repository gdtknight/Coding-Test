import java.util.Set;
import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        final int LEN = s.length();
        
        Set<Character> skipSet = new HashSet<>();
        
        for (int idx = 0; idx < skip.length(); idx++) {
            skipSet.add(skip.charAt(idx));
        }
        
        StringBuilder answerBuilder = new StringBuilder(s);
        
        for (int idx = 0; idx < LEN; idx++) {
            int cnt = 0;
            
            char cur = answerBuilder.charAt(idx);
            
            while(cnt < index) {
                cur += 1;
                if ('z' < cur) cur = 'a';
                if (skipSet.contains(cur)) continue;
                else cnt++;
            }
            
            answerBuilder.setCharAt(idx, cur);
        }
        
        
        return answerBuilder.toString();
    }
}