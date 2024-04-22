import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        /**
        *
        * 메인 아이디어
        * : 인용횟수에 따라 오름차순으로 정렬
        *   특정 인덱스에 있는 논문 인용횟수가 h 인 경우
        *   (h 이상 인용된 논문의 수) =  (전체 논문 수) - (해당 인덱스)
        *
        **/
        final int N = citations.length; // 전체 논문 수
        
        Arrays.sort(citations); // 논문 인용수에 따라 오름차순 정렬
        
        int answer = 0;
        int h = citations[N - 1];
        
        // 역순으로 탐색
        for (int idx = N - 1; 0 <= idx; idx--) {
            // 현재 인덱스부터 마지막 인덱스까지 논문의 수
            int paperCnt = N - idx;
            
            while (0 < idx && citations[idx - 1] < h) {
                // h번 이상 이용된 논문수가 h편 이상인 경우 H-Index
                if (h <= paperCnt) return h; 
                h--;
            }
        }
        
        while (N < h) {
            if (h <= N) return h; 
            h--;
        }
        
        return h;
    }
}