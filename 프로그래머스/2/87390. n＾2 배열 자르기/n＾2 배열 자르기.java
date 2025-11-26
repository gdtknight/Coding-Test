class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left) + 1;
        
        int[] answer = new int[len];
        
        for (int idx = 0; idx < len; idx++) {
            int row = (int)((idx + left) / (long) n);
            int col = (int)((idx + left) % (long) n);
            answer[idx] = Math.max(row, col) + 1;
        }
        return answer;
    }
}