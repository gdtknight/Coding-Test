import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] solution(String[] operations) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        
        for (String operation : operations) {
            String[] args = operation.split(" ");
            
            String op = args[0];
            int arg = Integer.parseInt(args[1]);
            
            if ("I".equals(op)) {
                dpq.insert(arg);
            } else if ("D".equals(op)) {
                dpq.delete(arg);
            }
        }
        
        return dpq.getValues();
    }
}

class DoublePriorityQueue {
  Node head;
  Node tail;

  public DoublePriorityQueue() {}

  public boolean insert(int value) {
    if (head == null) {
      head = new Node(value);
      tail = head;
      return true;
    }

    Node curNode = head;
    Node prevNode = null;

    while (curNode != null && curNode.value < value) {
      prevNode = curNode;
      curNode = curNode.next;
    }

    if (curNode == null) {
      prevNode.next = new Node(value, prevNode, null);
      tail = prevNode.next;
      return true;
    }

    if (curNode.value == value) {
      return false;
    }

    if (curNode == head) {
      Node newNode = new Node(value, null, curNode);
      curNode.prev = newNode;
      head = newNode;
      return true;
    }

    Node newNode = new Node(value, prevNode, curNode);
    prevNode.next = newNode;
    curNode.prev = newNode;

    return true;
  }

  public boolean delete(int flag) {
    if (head == null) {
      return false;
    }

    if (head == tail) {
      head.next = null;
      tail.prev = null;
      head = null;
      tail = null;
      return true;
    }

    if (flag == 1) {
      Node removeTarget = tail;
      int value = removeTarget.value;
      tail = removeTarget.prev;
      tail.next = null;
      removeTarget.prev = null;
      return true;
    }

    Node removeTarget = head;
    head = removeTarget.next;
    head.prev = null;
    removeTarget.next = null;
    return true;
  }

  public int[] getValues() {
    if (head == null || tail == null) {
      return new int[] {0, 0};
    }

    return new int[] {tail.value, head.value};
  }

  class Node {
    int value;
    Node prev;
    Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    public Node(int value, Node prev, Node next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }
}
