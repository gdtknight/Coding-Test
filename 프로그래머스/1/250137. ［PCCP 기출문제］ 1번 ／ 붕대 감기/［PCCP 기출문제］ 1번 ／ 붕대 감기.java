class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int prev = 0, time = 0;
        int hp = health;
        
        for (int[] attack : attacks) {
            time = attack[0] - prev - 1;
            
            hp = Math.min(health, hp + time * bandage[1] + time / bandage[0] * bandage[2]); 
            hp = Math.max(0, hp - attack[1]);
            
            if (hp <= 0) return -1;
            
            prev = attack[0];
        }
        
        return hp;
    }
}