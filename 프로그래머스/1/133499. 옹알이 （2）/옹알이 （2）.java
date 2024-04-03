import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        Trie trie = new Trie();
        
        trie.insert("aya");
        trie.insert("ye");
        trie.insert("woo");
        trie.insert("ma");
        
        outer :
        for (String word : babbling) {
            String prev = "";
            
            StringBuilder sb = new StringBuilder();
            Node node = trie.rootNode;
            
            for (int idx = 0; idx < word.length(); idx++) {
                node = node.childNodes.getOrDefault(word.charAt(idx), null);
                
                // 해당 문자로 시작하는 발음이 없는 경우
                if (node == null) {
                    continue outer;
                }
                
                sb.append(word.charAt(idx));
                
                if (node.endOfWord) {
                    String curWord = sb.toString();
                    System.out.println(curWord);
                    
                    // 같은 발음이 연속해서 나오는 경우
                    if (prev.equals(curWord)) {
                        continue outer;
                    }
                    
                    if (idx == word.length() - 1) {
                        answer++;  
                    }
                    
                    prev = curWord;
                    sb = new StringBuilder();
                    node = trie.rootNode;
                    
                }
            }
        }
        
        return answer;
    }
    
    class Trie {
        Node rootNode = new Node();
        
        void insert(String str) {
            Node node = this.rootNode;
            
            for (char c : str.toCharArray()) {
                node = node.childNodes.computeIfAbsent(c, key -> new Node());
            }
            
            node.endOfWord = true;
        }
        
        boolean search(String str) {
            Node node = this.rootNode;
            
            for (char c : str.toCharArray()) {
                node = node.childNodes.getOrDefault(c, null);
                
                if (node == null) {
                    return false;
                }
            }
            
            return node.endOfWord;
        }
    }
    
    class Node {
        Map<Character, Node> childNodes = new HashMap<>();
        boolean endOfWord = false;
    }
}