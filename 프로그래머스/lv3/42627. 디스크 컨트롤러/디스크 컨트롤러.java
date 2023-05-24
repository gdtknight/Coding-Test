import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public int solution(int[][] jobs) {
    PriorityQueue<Task> ready =
        new PriorityQueue<>(
            (task1, task2) ->
                task1.requestTime == task2.requestTime
                    ? Integer.compare(task1.processTime, task2.processTime)
                    : Integer.compare(task1.requestTime, task2.requestTime));

    Comparator<Task> taskComparator =
        (task1, task2) ->
            task1.completeTime == task2.completeTime
                ? Integer.compare(task1.requestTime, task2.requestTime)
                : Integer.compare(task1.completeTime, task2.completeTime);

    PriorityQueue<Task> suspend = new PriorityQueue<>(taskComparator);

    ArrayList<Integer> results = new ArrayList<>();
    Arrays.stream(jobs).map(job -> new Task(job[0], job[1], job[0] + job[1])).forEach(ready::offer);

    int curTime = 0;
    while (!ready.isEmpty()) {
      if (suspend.isEmpty()) {
        Task cur = ready.poll();
        curTime = cur.completeTime;
        results.add(cur.completeTime - cur.requestTime);

        while (!ready.isEmpty() && curTime >= ready.peek().requestTime) {
          Task next = ready.poll();
          next.completeTime = curTime + next.processTime;
          suspend.offer(next);
        }
      } else {
        Task cur = suspend.poll();
        curTime = cur.completeTime;
        results.add(cur.completeTime - cur.requestTime);

        PriorityQueue<Task> newSuspend = new PriorityQueue<>(taskComparator);

        while (!suspend.isEmpty()) {
          Task next = suspend.poll();
          next.completeTime = curTime + next.processTime;
          newSuspend.add(next);
        }
        while (!ready.isEmpty() && curTime >= ready.peek().requestTime) {
          Task next = ready.poll();
          next.completeTime = curTime + next.processTime;
          newSuspend.offer(next);
        }

        suspend = newSuspend;
      }
    }

    while (!suspend.isEmpty()) {
      Task cur = suspend.poll();

      curTime = cur.completeTime;

      results.add(cur.completeTime - cur.requestTime);

      PriorityQueue<Task> newSuspend = new PriorityQueue<>(taskComparator);

      while (!suspend.isEmpty()) {
        Task next = suspend.poll();
        next.completeTime = curTime + next.processTime;
        newSuspend.add(next);
      }
      suspend = newSuspend;
    }

    return (int) results.stream().mapToInt(Integer::intValue).average().orElse(0.0);
  }

  class Task {
    int requestTime;
    int processTime;
    int completeTime;

    Task(int requestTime, int processTime, int completeTime) {
      this.requestTime = requestTime;
      this.processTime = processTime;
      this.completeTime = completeTime;
    }
  }
}
