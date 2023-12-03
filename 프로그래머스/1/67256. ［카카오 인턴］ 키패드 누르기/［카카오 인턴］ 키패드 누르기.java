class Solution {
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        KEYPAD left = KEYPAD.ASTERISK;
        KEYPAD right = KEYPAD.SHARP;
        
        for (int num : numbers) {
            KEYPAD current = KEYPAD.getKey(String.valueOf(num));
            
            if (current == KEYPAD.ONE || current == KEYPAD.FOUR || current == KEYPAD.SEVEN) {
                sb.append("L");
                left = current;
                continue;
            } 
            
            if (current == KEYPAD.THREE || current == KEYPAD.SIX || current == KEYPAD.NINE) {
                sb.append("R");
                right = current;
                continue;
            } 
            
            int lDis = left.getDistance(current);
            int rDis = right.getDistance(current);
            
            if (lDis < rDis) {
                sb.append("L");
                left = current;
            } else if (lDis > rDis) {
                sb.append("R");
                right = current;
            } else {
                if (hand.equals("right")) {
                    sb.append("R");
                    right = current; 
                } else {
                    sb.append("L");
                    left = current;
                }
            }
        }
        
        return sb.toString();
    }
}

enum KEYPAD {
    ONE("1", 0, 3),
    TWO("2", 1, 3),
    THREE("3", 2, 3),
    FOUR("4", 0, 2),
    FIVE("5", 1, 2),
    SIX("6", 2, 2),
    SEVEN("7", 0, 1),
    EIGHT("8", 1, 1),
    NINE("9", 2, 1),
    ASTERISK("*", 0, 0),
    ZERO("0", 1, 0),
    SHARP("#", 2, 0);
    
    private final String key;
    private final int x;
    private final int y;
    
    public static KEYPAD getKey(String key) {
        if (key.equals("1")) return KEYPAD.ONE;
        else if (key.equals("2")) return KEYPAD.TWO;
        else if (key.equals("3")) return KEYPAD.THREE;
        else if (key.equals("4")) return KEYPAD.FOUR;
        else if (key.equals("5")) return KEYPAD.FIVE;
        else if (key.equals("6")) return KEYPAD.SIX;
        else if (key.equals("7")) return KEYPAD.SEVEN;
        else if (key.equals("8")) return KEYPAD.EIGHT;
        else if (key.equals("9")) return KEYPAD.NINE;
        else if (key.equals("*")) return KEYPAD.ASTERISK;
        else if (key.equals("0")) return KEYPAD.ZERO;
        else if (key.equals("#")) return KEYPAD.SHARP;
        
        throw new IllegalArgumentException("키값이 잘못되었습니다.");
    }
    
    KEYPAD(String key, int x, int y) {
        this.key = key;
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getDistance(KEYPAD other) {
      return Math.abs(this.x - other.getX()) + Math.abs(this.y - other.getY());
    }
}