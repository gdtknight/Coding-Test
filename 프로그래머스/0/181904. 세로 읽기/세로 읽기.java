class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        
        while (cnt * m + c - 1 < my_string.length()) {
            sb.append(my_string.charAt(cnt++ * m + c - 1));
        }
        
        return sb.toString();
    }
}