class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] ans = new int[]{};
        
        if (yellow == 1) return new int[]{yellow + 2, yellow + 2};
        
        for (int w = 1; w <= yellow / 2; w++) {
            if (yellow % w == 0) {
                int h = yellow / w;
                if ((w + 2) * (h + 2) == (brown + yellow)) {
                    return (w + 2) >= (h + 2)
                        ? new int[]{w + 2, h + 2}
                        : new int[]{h + 2, w + 2};
                }
            }
        }
        
        return ans;
    }
}