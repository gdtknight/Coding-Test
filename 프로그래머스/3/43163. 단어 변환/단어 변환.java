import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> bfs = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        bfs.offer(new Node(begin, 0));
        visited.add(begin);
        
        while(!bfs.isEmpty()) {
            Node cur = bfs.poll();
            if (cur.word().equals(target)) return cur.count();
            
            for (String word : words) {
                if (linked(cur.word(), word) && visited.add(word)) {
                    bfs.offer(new Node(word, cur.count() + 1)); 
                } 
            }
        }
        
        return 0;
    }
    
    private boolean linked(String word, String target) {
        final int LEN = word.length();
        int count = 0;
        
        for (int idx = 0; idx < LEN; idx++) {
            if (word.charAt(idx) != target.charAt(idx)) count++;
            
            if (count > 1) return false;
        }
        
        return count == 1;
    }
}

class Node {
    private String word;
    private int count;
    
    Node (String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    public boolean isWord(String word) {
        return this.word.equals(word);
    }
    
    public String word() {
        return word;
    }
    
    public int count() {
        return count;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        
        Node node = (Node) o;
        
        return word.equals(node.word());
    }
    
    @Override
    public int hashCode() {
        return word.hashCode();
    }
}