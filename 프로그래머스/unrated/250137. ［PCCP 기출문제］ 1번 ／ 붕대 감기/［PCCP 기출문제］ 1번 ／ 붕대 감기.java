class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int prev = 0, time = 0;
        int hp = health;
        
        for (int[] attack : attacks) {
            time = attack[0];
            System.out.printf(
                "Before HP: %d, Recover : %d", 
                hp, 
                (time - prev - 1) * bandage[1] + (time - prev - 1) / bandage[0] * bandage[2]);
            hp = Math.min(health, hp + (time - prev - 1) * bandage[1] + (time - prev - 1) / bandage[0] * bandage[2]); 
            hp = Math.max(0, hp - attack[1]);
            
            if (hp <= 0) return -1;
            
            System.out.println(", After HP : " + hp);
            
            prev = time;
        }
        
        return hp;
    }
}