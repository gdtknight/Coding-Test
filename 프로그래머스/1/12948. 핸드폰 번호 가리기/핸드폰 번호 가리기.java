class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (++i < phone_number.length() - 4) {
            sb.append("*");
        }
        sb.append(phone_number.substring(phone_number.length() - 4, phone_number.length()));
        return sb.toString();
    }
}