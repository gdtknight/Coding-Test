class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        compress(answer, arr, 0, 0, arr.length, 0);
        return answer;
    }
    
    public void compress(int[] answer, int[][] arr, int row, int col, int size, int seq) {
        if (size == 1) {
            answer[arr[row + size * (seq / 2)][col + size * (seq % 2)]] += 1;
            return ;
        }
        
        boolean flag = true;
        outer:
        for (int r = row + size * (seq / 2); r < row + size * (seq / 2) + size; r++) {
            for (int c = col + size * (seq % 2); c < col + size * (seq % 2) + size; c++) {
                if (arr[row + size * (seq / 2)][col + size * (seq % 2)] != arr[r][c]) {
                    flag = false;
                    break outer;
                }
            }
        }
        
        if (flag)
            answer[arr[row + size * (seq / 2)][col + size * (seq % 2)]] += 1;
        else {
            for (int s = 0; s < 4; s++) {
                compress(answer, arr, row + size * (seq / 2), col + size * (seq % 2), size / 2, s);
            }
        }
        return ;
    }
}