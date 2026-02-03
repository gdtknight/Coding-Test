class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        if (arr.length == 1)
            return (new int[]{-1});
        int minVal = arr[0];
        int minIdx = 0;
        for (int idx = 1; idx < arr.length; idx++) {
            if (minVal > arr[idx]) {
                minVal = arr[idx];
                minIdx = idx;
            }
        }
        for (int idx = 0; idx < minIdx; idx++) {
            answer[idx] = arr[idx];
        }
        for (int idx = minIdx + 1; idx < arr.length; idx++) {
            answer[idx - 1] = arr[idx];
        }

        return answer;
    }
}