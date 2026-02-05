import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        return Arrays.stream(s.substring(2, s.length() - 2).split("\\},\\{"))
                .map(t -> Arrays.stream(t.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .sorted(Comparator.comparingInt(List::size))
                .collect(LinkedHashSet<Integer>::new,
                         (set, list) -> list.forEach(set::add),
                         LinkedHashSet::addAll)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
