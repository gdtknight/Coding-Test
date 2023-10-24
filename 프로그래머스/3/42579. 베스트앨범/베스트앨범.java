import java.util.*;
import java.util.Map.Entry;

class Solution {
  public int[] solution(String[] genres, int[] plays) {

    Map<String, Integer> totalPlays = new HashMap<>();

    for (int i = 0; i < genres.length; i++) {
      totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
    }

    PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(
        (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

    for (Entry<String, Integer> entry : totalPlays.entrySet()) {
      pq.offer(entry);
    }

    List<Integer> ansList = new ArrayList<>();

    while (!pq.isEmpty()) {
      Entry<String, Integer> entry = pq.poll();

      PriorityQueue<Song> songPq = new PriorityQueue<>(
          (song1, song2) -> song2.getPlayCnt().compareTo(song1.getPlayCnt()));

      for (int i = 0; i < genres.length; i++) {
        if (genres[i].equals(entry.getKey())) {
          songPq.offer(new Song(i, genres[i], plays[i]));
        }
      }

      int cnt = 0;
      while (!songPq.isEmpty() && cnt < 2) {
        ansList.add(songPq.poll().getId());
        cnt += 1;
      }
    }

    return ansList.stream().mapToInt(Integer::valueOf).toArray();
  }
}

class Song {
    int id;
    String genre;
    Integer playCnt;

    public Song(int id, String genre, int playCnt) {
      this.id = id;
      this.genre = genre;
      this.playCnt = playCnt;
    }

    public int getId() {
      return id;
    }

    public String getGenre() {
      return genre;
    }

    public Integer getPlayCnt() {
      return playCnt;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Song other = (Song) obj;
      
      if (id != other.id)
        return false;
      return true;
    }


  }