class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        
        for (int idx = 0; idx < charArr.length; idx++) {
            char c = charArr[idx];
            
            if ('A' <= c && c <= 'Z') {
                charArr[idx] = (char)((c - 'A' + n) % 26 + 'A');
            } else if ('a' <= c && c <= 'z') {
                charArr[idx] = (char)((c - 'a' + n) % 26 + 'a');
            }
        }
        
        return new String(charArr);
    }
}