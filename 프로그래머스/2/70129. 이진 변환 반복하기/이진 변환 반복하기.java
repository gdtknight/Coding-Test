class Solution {
    public int[] solution(String s) {
        StringBuilder sb;
        int[] answer = new int[2];
        
        while (!"1".equals(s)) {
            sb = new StringBuilder();
            answer[0]++;
            
            for (int idx = 0; idx < s.length(); idx++) {
                if (s.charAt(idx) == '0') answer[1]++;
                else sb.append(s.charAt(idx));
            }
            
            s = Integer.toBinaryString(sb.length());
        }
        
        return answer;
    }
}