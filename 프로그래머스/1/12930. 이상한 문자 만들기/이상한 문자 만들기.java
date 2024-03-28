class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        int step = (char)'a' - (char)'A';
        
        int wIdx = 0;
        for (int idx = 0; idx < charArr.length; idx++) {
            char c = charArr[idx];
            if (c == ' ') {
                wIdx = 0;
                continue;
            }
            
            if ('a' <= c && c <= 'z' && wIdx % 2 == 0) {
                charArr[idx] -= step;
            } else if ('A' <= c && c <= 'Z' && wIdx % 2 != 0) {
                charArr[idx] += step;
            } 
            
            wIdx++;
        }
        
        return new String(charArr);
    }
}