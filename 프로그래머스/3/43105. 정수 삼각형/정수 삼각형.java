class Solution {
    /**
    
    높이가 HEIGHT 인 삼각형의 인덱스는 다음과 같은 순서로 구성됨.
    
    [0][0]
    [1][0] [1][1]
    [2][0] [2][1] [2][2]
    ...
    [h - 1][0] [h - 1][1] ... [h - 1][h - 1]
      [h][0]     [h][1]   ...   [h][h - 1]    [h][h]
    
    ...
    
    [HEIGHT - 1][0] [HEIGHT - 1][1] ... [HEIGHT - 1][HEIGHT - 1]
    
    **/
    public int solution(int[][] triangle) {
        final int HEIGHT = triangle.length;
        int answer = 0;
        
        // 0 은 삼각형 꼭대기
        for (int h = 1; h < HEIGHT; h++) {
            // 첫번째 숫자는 오른쪽 위 숫자만 존재하므로 바로 더해준다.
            triangle[h][0] += triangle[h - 1][0];
            
            // 중간 숫자 (인덱스 1번부터 (h - 2)번)
            // 왼쪽 위 숫자, 오른쪽 위 숫자 중 큰 숫자를 더해준다
            for (int idx = 1; idx < h; idx++) {
                triangle[h][idx] += Math.max(triangle[h - 1][idx - 1], triangle[h - 1][idx]);
            }
            
            // 각 행의 마지막 숫자
            triangle[h][h] += triangle[h - 1][h - 1];
            
            for (int idx = 0; idx <= h; idx++) {
                if (answer < triangle[h][idx])
                    answer = triangle[h][idx];
            }
        }
        
        return answer;
    }
}