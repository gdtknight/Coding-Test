import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    static final Set<Integer> numSet = new HashSet<>();
    
    public int solution(String numbers) {
        /**
        *
        * 완전탐색
        *  : 문자열의 최대길이 (numbers의 길이) 만큼 반복하면서 생성가능한 문자들을 더한다
        *
        **/
        
        final int MAX_LEN = numbers.length();
        final char[] chars = numbers.toCharArray();
        final boolean[] visited = new boolean[numbers.length()];
        StringBuilder numBuilder = new StringBuilder();
        
        for (int len = 1; len <= MAX_LEN; len++) {
            dfs(chars, visited, numBuilder, len);
        }
        
        System.out.println(numSet);
        
        return numSet.size();
    }
    
    private void dfs(char[] chars, boolean[] visited, StringBuilder numBuilder, int len) {
        if (numBuilder.length() == len) {
            int num = Integer.parseInt(numBuilder.toString(), 10);
            
            if (isPrime(num)) {
                numSet.add(num);
            }
            
            return;
        }
        
        for (int idx = 0; idx < chars.length; idx++) {
            if (visited[idx]) continue;
            
            visited[idx] = true;
            numBuilder.append(chars[idx]);
            dfs(chars, visited, numBuilder, len);
            numBuilder.deleteCharAt(numBuilder.length() - 1);
            visited[idx] = false;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        
        for (int div = 2; div <= Math.sqrt(num); div++) {
            if (num % div == 0) return false;
        }
        
        return true;
    }
}