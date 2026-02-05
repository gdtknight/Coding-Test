import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        String[] tuples = s.substring(2, s.length() - 2).split("\\},\\{");
        
        List<List<Integer>> numList = new LinkedList<>();
        List<Integer> answerList = new LinkedList<>();
        
        for (String tuple : tuples) {
            List<Integer> nums = Arrays.stream(tuple.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            numList.add(nums);
        }
        numList.sort((l1, l2) -> Integer.compare(l1.size(), l2.size()));
        // System.out.println(numList);
        
        for (int i = 0; i < numList.size(); i++) {
            Integer cur = numList.get(i).get(0);
            answerList.add(cur);
            numList.get(i).remove(cur);
            for (int idx = i + 1; idx < numList.size(); idx++) {
                numList.get(idx).remove(cur);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = answerList.get(idx);
        }
        return answer;
    }
}