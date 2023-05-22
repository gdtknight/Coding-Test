import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    MinHeap minHeap = new MinHeap(N);
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        sb.append(minHeap.pop()).append("\n");
      } else {
        minHeap.push(num);
      }
    }

    System.out.println(sb);
  }

  static class MinHeap {
    int[] minHeap;
    int size;

    MinHeap(int defaultSize) {
      this.size = 0;
      this.minHeap = new int[defaultSize * 2];
    }

    public void push(int x) {
      if (size == 0) {
        minHeap[++size] = x;
        return;
      }

      minHeap[++size] = x;
      int curPos = size;
      while (curPos > 1) {
        int parent = curPos / 2;
        if (minHeap[parent] > minHeap[curPos]) {
          int temp = minHeap[curPos];
          minHeap[curPos] = minHeap[parent];
          minHeap[parent] = temp;
        }
        curPos = parent;
      }
    }

    public int pop() {
      if (size == 0) {
        return 0;
      }

      int data = minHeap[1];
      minHeap[1] = minHeap[size--];
      int curPos = 1;
      while (curPos <= size) {
        int left = curPos * 2;
        int right = curPos * 2 + 1;
        if (right <= size) {
          int nextPos = minHeap[left] < minHeap[right] ? left : right;
          if (minHeap[curPos] > minHeap[nextPos]) {
            int temp = minHeap[curPos];
            minHeap[curPos] = minHeap[nextPos];
            minHeap[nextPos] = temp;
          }
          curPos = nextPos;
        } else if (left <= size) {
          if (minHeap[curPos] > minHeap[left]) {
            int temp = minHeap[curPos];
            minHeap[curPos] = minHeap[left];
            minHeap[left] = temp;
          }
          curPos = left;
        } else {
          break;
        }
      }

      return data;
    }
  }
}
