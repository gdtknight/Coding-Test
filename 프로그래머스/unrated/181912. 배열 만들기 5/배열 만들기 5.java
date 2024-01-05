import java.util.Arrays;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
            .map(intStr -> intStr.substring(s, s + l))
            .mapToInt(Integer::parseInt)
            .filter(num -> num > k)
            .toArray();
    }
}