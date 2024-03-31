class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'p' || c =='P') pCnt++;
            if (c == 'y' || c =='Y') yCnt++;
        }

        return pCnt == 0 && yCnt == 0
			? true
            : pCnt == yCnt;
    }
}