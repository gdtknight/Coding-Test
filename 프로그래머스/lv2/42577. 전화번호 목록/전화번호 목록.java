import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {     
        Trie root = new Trie();
        Arrays.stream(phone_book).forEach(number -> root.add(number));
        
        boolean check = true;
        
        for (String number : phone_book) {
            if (!root.check(number)) {
                return false;
            }
        }
        
        return true;
    }
}

class Trie {
    Trie[] node;
    boolean isEnd;

    Trie() {
        this.node = new Trie[10];
        this.isEnd = false;
    }
    
    public void add(String s) {
        if (s.length() == 0) return;
       
        Trie[] nodes = this.node;
        Trie curr = null;
   
        for (char c : s.toCharArray()) {
            int num = c - '0';

            if (nodes[num] == null) nodes[num] = new Trie();    
    
            curr = nodes[num];
            nodes = nodes[num].node;
        }

        curr.isEnd = true;
    }

    public boolean check(String s) {
        Trie[] nodes = this.node;
        Trie curr = null;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            curr = nodes[n];
            if (curr.isEnd && i < s.length() - 1) return false;
            nodes = nodes[n].node;
        }
  
        return true;
    }

}
