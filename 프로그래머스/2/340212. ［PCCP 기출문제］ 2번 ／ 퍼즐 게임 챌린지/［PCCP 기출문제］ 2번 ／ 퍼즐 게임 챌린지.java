class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long min = 1;
        long max = 2_147_483_647;

        while (min < max)
        {
            long mid = (min + max) / 2;
            long total = calculate_spend_time(diffs[0], mid, times[0], 0);
            for (int idx = 1; idx < diffs.length; idx++)
            {
                total += calculate_spend_time(diffs[idx], mid, times[idx], times[idx - 1]);
                if (total > limit)
                    break;
            }
            if (total <= limit)
                max = mid;
            else
                min = mid + 1;
        }
        return (int)(min);
    }
    
    public long calculate_spend_time(int diff, long level, int time_cur, int time_prev)
    {
        if (diff <= level)
            return (time_cur);
        else
            return ((long)(diff - level) * (long)(time_cur + time_prev) + (long)time_cur);
    }
}
