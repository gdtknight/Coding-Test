class Solution {
    public int solution(int n, int m, int[] section) {
        /**
        *
        * 메인 아이디어
        * : 1, 2, 3, ..., n
        * 롤러 길이 m
        * 페인트칠 횟수 최소화
        *
        **/
        int answer = 1;
        int prevIdx = 0;
        for (int idx = 1; idx < section.length; idx++) {
            if (section[idx] < section[prevIdx] + m) {
                continue; 
            } else {
                answer++;
                prevIdx = idx;
            }
            
        }
        
        return answer;
    }
}