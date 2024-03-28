class Solution {
    public int solution(String t, String p) {
        final int LEN = p.length();
        final long TARGET = Long.parseLong(p);
        
        int answer = 0;
        
        for (int idx = 0; idx <= t.length() - LEN; idx++) {
            String sub = t.substring(idx, idx + LEN);
            long cur = Long.parseLong(sub);
            
            if (cur <= TARGET) {
                answer++;
            }
        }
        
        return answer;
    }
}