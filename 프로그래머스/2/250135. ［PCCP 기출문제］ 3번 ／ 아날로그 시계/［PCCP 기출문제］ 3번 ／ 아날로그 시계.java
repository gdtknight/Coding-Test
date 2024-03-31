class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        final double HOUR_NEEDLE_DEGREE_PER_SECOND   = 720.0 / 24.0 / 60.0 / 60.0;
        final double MINUTE_NEEDLE_DEGREE_PER_SECOND = 360.0 / 60.0 / 60.0;
        final double SECOND_NEEDLE_DEGREE_PER_SECOND = 360.0 / 60.0;
        
        final int START_SECOND = h1 * 60 * 60 + m1 * 60 + s1;
        final int END_SECOND = h2 * 60 * 60 + m2 * 60 + s2;
        
        int answer = 0;
        
        double hourNeedleDegree     = ((double)START_SECOND * HOUR_NEEDLE_DEGREE_PER_SECOND  ) % 360.0;
        double minNeedleDegree      = ((double)START_SECOND * MINUTE_NEEDLE_DEGREE_PER_SECOND) % 360.0;
        double secNeedleDegree      = ((double)START_SECOND * SECOND_NEEDLE_DEGREE_PER_SECOND) % 360.0;
        
        if (hourNeedleDegree == minNeedleDegree) answer++;
        
        for (int time = START_SECOND + 1; time <= END_SECOND; time++) {
            double prevHourNeedleDegree = ((double) (time - 1) * HOUR_NEEDLE_DEGREE_PER_SECOND  ) % 360.0;
            double prevMinNeedleDegree  = ((double) (time - 1) * MINUTE_NEEDLE_DEGREE_PER_SECOND) % 360.0;
            double prevSecNeedleDegree  = ((double) (time - 1) * SECOND_NEEDLE_DEGREE_PER_SECOND) % 360.0;
            
            hourNeedleDegree     = ((double) time * HOUR_NEEDLE_DEGREE_PER_SECOND  ) % 360.0;
            minNeedleDegree      = ((double) time * MINUTE_NEEDLE_DEGREE_PER_SECOND) % 360.0;
            secNeedleDegree      = ((double) time * SECOND_NEEDLE_DEGREE_PER_SECOND) % 360.0;
            
            if (secNeedleDegree != 0) {
                if (prevSecNeedleDegree < prevMinNeedleDegree  && minNeedleDegree  < secNeedleDegree) answer++;
                if (prevSecNeedleDegree < prevHourNeedleDegree && hourNeedleDegree < secNeedleDegree) answer++;
            } else {
                secNeedleDegree = 360.0;
                
                if (prevSecNeedleDegree < prevMinNeedleDegree  && minNeedleDegree  <= secNeedleDegree) answer++;
                if (prevSecNeedleDegree < prevHourNeedleDegree && hourNeedleDegree <= secNeedleDegree) answer++;
                if (minNeedleDegree == hourNeedleDegree) answer--;
            }
        }
        
        System.out.println(answer);
        
        return answer;
    }
}