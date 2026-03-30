class Solution {
    public String longestPalindrome(String s) {
        final int MAX_LEN = s.length();

        int lIdx = 0, rIdx = 0, answer = 0;
 
        for (int startPos = 1; startPos < MAX_LEN; startPos++) {
            
            int len = 1;
            // 길이가 홀수인 경우
            int leftIdx = startPos - 1;
            int rightIdx = startPos + 1;

            while(0 <= leftIdx && rightIdx < MAX_LEN && s.charAt(leftIdx) == s.charAt(rightIdx)) {
                len += 2;
                leftIdx -= 1;
                rightIdx += 1;
            }

            if (answer < len) {
                answer = len;
                lIdx = leftIdx + 1;
                rIdx = rightIdx - 1;
            }

            len = 0;
            
            // 길이가 짝수인 경우
            leftIdx = startPos - 1;
            rightIdx = startPos;

            while(0 <= leftIdx && rightIdx < MAX_LEN && s.charAt(leftIdx) == s.charAt(rightIdx)) {
                len += 2;
                leftIdx -= 1;
                rightIdx += 1;
            }
            
            if (answer < len) {
                answer = len;
                lIdx = leftIdx + 1;
                rIdx = rightIdx - 1;
            }
        }

        return s.substring(lIdx, rIdx + 1);
    }
}