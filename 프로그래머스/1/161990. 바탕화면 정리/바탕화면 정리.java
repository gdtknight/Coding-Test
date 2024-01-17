class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = Integer.MAX_VALUE, maxRow = 0;
        int minCol = Integer.MAX_VALUE, maxCol = 0;
        
        for (int row = 0; row < wallpaper.length; row++) {
            for (int col = 0; col < wallpaper[0].length(); col++) {
                if (wallpaper[row].charAt(col) != '#') continue;
                
                minRow = Math.min(minRow, row);
                maxRow = Math.max(maxRow, row);
                
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                
            }
        }
        
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}