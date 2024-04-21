import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);
        
        for (int idx = 1; idx < words.length; idx++) {
            String prevStr = words[idx - 1];
            String curStr = words[idx];
            
            char prevChar = prevStr.charAt(prevStr.length() - 1);
            char curChar = curStr.charAt(0);
            
            if (!used.add(curStr) || prevChar != curChar)  {
                return new int[]{idx % n + 1, idx / n + 1};
            }
        }

        return new int[]{0, 0};
    }
}