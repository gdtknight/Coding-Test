class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int idx = 0; idx < s.length(); idx++) {
            answer[idx] = -1;
            for (int pos = idx - 1; pos >= 0; pos--) {
                if (s.charAt(idx) == s.charAt(pos)) {
                    answer[idx] = idx - pos;
                    break ;
                }
            }
        }
        
        return answer;
    }
}