import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = Integer.MAX_VALUE;
        
        int cntOne = 0;
        
        String origin = Integer.toBinaryString(n);
        String temp = "";
        
        int len = origin.length();
        
        for (int idx = 0; idx < len; idx++) {
            if (origin.charAt(idx) == '1') cntOne++;
        }
        
        int tmpCntOne = 0;
        
        int maxNum = (n * 3) + 1;
        
        for (int num = n + 1; num <= maxNum; num++) {
            tmpCntOne = 0;
            
            temp = Integer.toBinaryString(num);
            len = temp.length();
            
            for (int idx = 0; idx < len; idx++) {
                if (temp.charAt(idx) == '1') tmpCntOne++;
            }
            
            if (tmpCntOne == cntOne) return num;
        }
        
        return answer;
    }
}