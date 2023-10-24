import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        return Arrays.stream(sb.reverse().chars().map(c -> c - '0').toArray()).toArray();
    }
}