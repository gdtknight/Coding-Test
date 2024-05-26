import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((n1, n2) -> (n2 + n1).compareTo(n1 + n2))
            .reduce((n1, n2) -> "0".equals(n1) && "0".equals(n2) ? "0" : n1 + n2)
            .orElse("0");
    }
}