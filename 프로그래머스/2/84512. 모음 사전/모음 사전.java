import java.util.Arrays;

class Solution {
    static final char[] ALPHABETS = new char[]{'A', 'E', 'I', 'O', 'U'};
    
    static int count = 0;
    static boolean find = false;
    
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : ALPHABETS) {
            count++;
            sb.append(c);
            dfs(sb, word);
            sb.deleteCharAt(sb.length() - 1);
            if (find) break;
        }
        
        return count;
    }
    
    private void dfs(StringBuilder current, String word) {
        if (word.equals(current.toString())) {
            find = true;
            return;
        }
        
        if (current.length() >= 5 || find) return;
        
        for (char c : ALPHABETS) {
            count++;
            current.append(c);
            dfs(current, word);
            current.deleteCharAt(current.length() - 1);
            if (find) return;
        }
    }
}