class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int row = 1; row < triangle.length; row++) {
            triangle[row][0] += triangle[row - 1][0];
            triangle[row][triangle[row].length - 1] += triangle[row - 1][triangle[row - 1].length - 1];
            
            for (int col = 1; col < triangle[row].length - 1; col++) {
                triangle[row][col] += Math.max(triangle[row - 1][col - 1], triangle[row - 1][col]);
            }
        }
        
        for (int col = 0; col < triangle[triangle.length - 1].length; col++) {
            if (answer < triangle[triangle.length - 1][col]) {
                answer = triangle[triangle.length - 1][col];
            }
        }
        
        
        return answer;
    }
}