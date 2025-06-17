class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        boolean flag = true;
        int answer = 0;
        
        for (int idx = 0; idx < schedules.length; idx++) {
            flag = true;
            System.out.println("Employee " + idx);
            for (int day = 0; day < 7; day++) {
                if (((day + startday - 1) % 7 + 1 == 6) || ((day + startday - 1) % 7 + 1 == 7)) {
                    continue ;
                }
                int start_time = convert_to_minute(timelogs[idx][day]);
                int scheduled_time = convert_to_minute(schedules[idx]) + 10;
                if (start_time > scheduled_time) {
                    System.out.println("day : " + ((day + startday - 1) % 7 + 1));
                    System.out.println("Late! - start_time : " + start_time + ", scheduled : " + scheduled_time);
                    flag = false;
                    break ;
                }
            }
            if (flag == true)
                answer++;
        }
        
        return (answer);
    }
    
    int convert_to_minute(int timelog) {
        int converted;
        
        converted = (timelog / 100 * 60 + timelog % 100);
        // System.out.println("timelog : " + timelog + ", converted : " + converted);
        return (converted);
    }
}

