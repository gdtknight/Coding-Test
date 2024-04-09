class Solution {
    public int[] solution(int brown, int yellow) {
        /**
        *
        * 메인 아이디어 
        *  : 가운데 노란색 사각형의 영역을 기준으로 가로(w), 세로(h) 계산
        *  테두리를 포함한 전체 사각형의 넓이는 (w + 2) * (h + 2)
        *
        **/ 
        
        int[] ans = new int[]{};
        
        final int MAX_WIDTH = yellow / 2 + 1;
        
        for (int w = 1; (w <= MAX_WIDTH); w++) {
            if (yellow % w != 0) continue;
            
            int h = yellow / w;
            
            if ((w + 2) * (h + 2) != (brown + yellow)) {
                continue;
            }
            
            return (w + 2) >= (h + 2)
                ? new int[]{w + 2, h + 2}
                : new int[]{h + 2, w + 2};
        }
        
        return ans;
    }
}