import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashSet<Edge> path = new HashSet<>();
        
        Point from = new Point (0, 0);
        Robot robot = new Robot(from);
        
        for (char c: dirs.toCharArray()) {
            if (!robot.move(c)) {
                continue ;
            }
            
            Edge e = new Edge(from, robot.pos);
            
            path.add(e);
            
            System.out.printf("[%c] ", c);
            System.out.println(e);
            
            from = robot.pos;
        }
        
        return path.size();
    }
}

class Robot {
    Point pos;
    
    Robot(Point p) {
        pos = p;
    }
    
    boolean move(char c) {
        Point next = new Point(pos);
        
        if (c == 'U') {
            next.y += 1;
        }
        else if (c == 'D') {
            next.y -= 1;
        }
        else if (c == 'R') {
            next.x += 1;
        }
        else {
            next.x -= 1;
        }
        if (!canMove(next))
            return false;
        pos = next;
        return true;
    }
    
    boolean canMove(Point p) {
        return !(p.x > 5 || p.y > 5
                  || p.x < -5 || p.y < -5);
	}
}

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    public boolean equals(Object other) {
        if (!(other instanceof Point))
            return false;
        Point p = (Point) other;
        return (this.x == p.x && this.y == p.y);
    }
    
    public int hashCode() {
        return ((this.x * 31) + this.y);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(Integer.toString(x));
        sb.append(", ");
        sb.append(Integer.toString(y));
        sb.append(")");
        return sb.toString();
    }
}

class Edge {
    Point from;
    Point to;
    
    Edge (Point from, Point to) {
        this.from = from;
        this.to = to;
    }
    
    public boolean equals(Object other) {
        if (!(other instanceof Edge)) {
            return false;
        }
        
        Edge e = (Edge) other;
        
        return (this.from.equals(e.from)
                && this.to.equals(e.to))
            || (this.from.equals(e.to)
                && this.to.equals(e.from));
    }
    
    public int hashCode() {
        return (this.from.hashCode()
            + this.to.hashCode());
    }
    
    public String toString() {
        return from.toString() + "->" + to.toString();
    }
}