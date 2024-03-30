import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        Trie trie = new Trie();
        
        trie.insert("zero", 0);
        trie.insert("one", 1);
        trie.insert("two", 2);
        trie.insert("three", 3);
        trie.insert("four", 4);
        trie.insert("five", 5);
        trie.insert("six", 6);
        trie.insert("seven", 7);
        trie.insert("eight", 8);
        trie.insert("nine", 9);
        
        
        char[] charArr = s.toCharArray();
        
        Node node = trie.getRootNode();
        
        for (char c : charArr) {
            if ('0' <= c && c <= '9') {
                sb.append(c);
                continue;
            }
            
            node = node.childNodes.get(c);
            
            if (node.endOfWord) {
                sb.append(node.num);
                node = trie.getRootNode();
            } 
        }
        
        
        return Integer.parseInt(sb.toString());
    }

    class Trie {
        Node rootNode;
        
        Trie() {
            this.rootNode = new Node();
        }
        
        Node getRootNode() {
            return this.rootNode;
        }
        
        void insert(String str, int num) {
            Node cur = this.rootNode;
            
            for (char c : str.toCharArray()) {
                cur = cur.childNodes.computeIfAbsent(c, key -> new Node());
            }
            
            cur.endOfWord = true;
            cur.num = num;
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
        Map<Character, Node> childNodes;
        boolean endOfWord;
        int num;
        
        Node() {
            childNodes = new HashMap<>();
            endOfWord = false;
            num = -1;
        }
    }
}