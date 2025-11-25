class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2]; // 배열 길이 : 1 + 2 + ... + n = n * (n + 1) / 2
        int nestedCount = 1 + (n - 1) / 3;
        
        int prevLen = 0;
        answer[0] = 1;
        for (int seq = 0; seq < nestedCount; seq++) {
            int rowNum = 1 + 2 * seq;
            int height = n - seq * 3;
            int startIdx = (rowNum - 1) * rowNum / 2 + seq;
            int startNum = prevLen + 1;
            
            int idx = startIdx;
            int offset = rowNum;
            answer[idx] = startNum;
            for (int h = 1; h < height; h++) {
                idx = idx + offset++;
                answer[idx] = ++startNum;
            }
            
            for (int w = 0; w < height - 1; w++) {
                answer[++idx] = ++startNum;
            }
            
            offset = height + (seq * 2);
            for (int h = 1; h < height - 1; h++) {
                idx = idx - offset--;
                answer[idx] = ++startNum;
            }
            
            prevLen += (height + (height - 1) + (height - 2));
        }
        return (answer);
    }
}