import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Map<String, Integer> idxMap = new HashMap<>();
        
        for (int idx = 0; idx < words.length; idx++) {
            idxMap.put(words[idx], idx);
        }
        
        // target 이 words에 존재하지 않는 경우 도달 불가능
        if (!idxMap.containsKey(target)) return 0;
        if (!idxMap.containsKey(begin)) idxMap.put(begin, idxMap.size());
        
        
        int size = idxMap.size();
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] graph = new boolean[size][size];
        int[] counts = new int[size];
        
        int start = idxMap.get(begin);
        
        for (int i = 0; i < words.length; i++) {
            if (linked(begin, words[i])) {
                counts[i] = 1;
                queue.offer(i);
            }
            
            for (int j = i+1; j < words.length; j++) {
                if (linked(words[i], words[j])) {
                    graph[i][j] = true;
                    graph[j][i] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int from = queue.poll();
            int count = counts[from];
            
            for (String next : idxMap.keySet()) {
                int to = idxMap.get(next);
                if (counts[to] == 0 && graph[from][to]) {
                    if (next.equals(target)) return count + 1;
                    counts[to] = counts[from] + 1;
                    queue.offer(to);
                    System.out.printf("단어 : %s, 카운트 : %d\n", next, count + 1);
                }
			}
       	}
        
        return counts[idxMap.get(target)];
    }
    
    public boolean linked(String s1, String s2) {
        final int MAX_MATCH_COUNT = s1.length() - 1;
        
        int count = 0;
        
        if (s1.length() != s2.length())
            throw new RuntimeException("길이가 다릅니다");
        
        for (int idx = 0; idx < s1.length(); idx++) {
            if (s1.charAt(idx) == s2.charAt(idx)) count++;
        }
        
        return count == MAX_MATCH_COUNT;
    }
}
