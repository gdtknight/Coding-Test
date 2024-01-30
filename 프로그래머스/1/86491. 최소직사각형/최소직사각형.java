import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int minWidth = 0;
        int minHeight = 0;
        
        for (int[] size : sizes) {
            if ((size[0] <= minWidth && size[1] <= minHeight) 
                || (size[1] <= minWidth && size[0] <= minHeight)) {
                continue;
            }
            
            minWidth = Math.max(minWidth, Math.min(size[0], size[1]));
            minHeight = Math.max(minHeight, Math.max(size[0], size[1]));
        }
        
        return minWidth * minHeight;
    }
}