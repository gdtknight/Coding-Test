import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        
        for (int idx = 0; idx < numbers.length; idx++) {
            nums[idx] = numbers[idx] + "";
        }
        
        Arrays.sort(nums, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        if (nums[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String num : nums) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}