class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[][] emos = new int[emoticons.length][2];
        for (int idx = 0; idx < emoticons.length; idx++) {
            emos[idx][0] = emoticons[idx];
        }
        get_max_answer(answer, users, emos, 0, emos.length);
        return answer;
    }
    public void get_max_answer(int[] answer, int[][] users, int[][] emos, int sIdx, int eIdx) {
        int[] temp = new int[2];
        int[] rates = {40, 30, 20, 10};
        if (sIdx == eIdx) {
            // System.out.println("------------------------------------");
            // for (int idx = 0; idx < emos.length; idx++)
            //     System.out.printf("[emoticon %d] Price: %d, Rate: %d\n", idx, emos[idx][0], emos[idx][1]);
            // System.out.println("------------------------------------\n");
            update_answer(answer, users, emos);
            return ;
        }
        for (int rate: rates) {
        	emos[sIdx][1] = rate;
    		get_max_answer(answer, users, emos, sIdx + 1, eIdx);
        }
    }
    
    public void update_answer(int[] answer, int[][] users, int[][] emos) {
        int[] temp = new int[2];
        for (int idx = 0; idx < users.length; idx++) {
            int sum = 0;
            for (int[] e: emos) {
                if (users[idx][0] <= e[1]) {
                	sum += (e[0] * (1.0 - e[1] / 100.0));
                    // System.out.printf("[user %d] p_limit: %d, e[1]: %d - sum: %d\n", idx, users[idx][0], e[1], sum);
                }
                if (users[idx][1] <= sum) {
                    temp[0] += 1;
                    // System.out.printf("[user %d] choose emotion plus ! (sum: %d, amount: %d)\n", idx, sum, users[idx][1]);
                    sum = 0;
                    break ;
                }
            }
            temp[1] += sum;
        }
        if (temp[0] > answer[0]) {
            answer[0] = temp[0];
            answer[1] = temp[1];
            // System.out.printf("answer updated - [%d, %d] (temp: [%d, %d])\n", answer[0], answer[1], temp[0], temp[1]);
        }
        else if (temp[0] == answer[0] && temp[1] > answer[1]) {
            answer[0] = temp[0];
            answer[1] = temp[1];
            // System.out.printf("answer updated - [%d, %d] (temp: [%d, %d])\n", answer[0], answer[1], temp[0], temp[1]);
        }
    }
}