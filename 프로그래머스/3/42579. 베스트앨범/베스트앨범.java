import java.lang.Comparable;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        final int LEN = genres.length;
        
        Map<String, Genre> genreMap = new HashMap<>();
        
        for (int idx = 0; idx < LEN; idx++) {
            Genre curGenre = genreMap.getOrDefault(genres[idx], new Genre());
            Song curSong = new Song(idx, plays[idx]);
            curGenre.addSong(curSong);
            genreMap.put(genres[idx], curGenre);
        }
        
        PriorityQueue<Genre> genrePq = new PriorityQueue<>();
        
        genreMap.values().forEach(genrePq::offer);
        
        List<Integer> indexes = new ArrayList<>();
        
        while(!genrePq.isEmpty()) {
            Genre curGenre = genrePq.poll();
            PriorityQueue<Song> songs = curGenre.songs();
            
            if (!songs.isEmpty()) {
                indexes.add(songs.poll().id());
            }
            
            if (!songs.isEmpty()) {
                indexes.add(songs.poll().id());
            }
        }
        
        return indexes.stream().mapToInt(Integer::valueOf).toArray();
    }
}

class Genre implements Comparable<Genre> {
    private PriorityQueue<Song> songs = new PriorityQueue<>();
    private int totalPlayCount;
    
    public Genre() {
        this.songs = new PriorityQueue<>();
        this.totalPlayCount = 0;
    }
    
    public void addSong(Song song) {
        songs.offer(song);
        totalPlayCount += song.playCount();
    }
    
    public int totalPlayCount() {
        return totalPlayCount;
    }
    
    public PriorityQueue<Song> songs() {
        return songs;
    }
    
    @Override
    public int compareTo(Genre other) {
        return Integer.compare(other.totalPlayCount(), totalPlayCount);
    }
}

class Song implements Comparable<Song> {
    private int id;
    private int playCount;
    
    Song(int id, int playCount) {
        this.id = id;
        this.playCount = playCount;
    }
    
    public int id() {
        return id;
    }
    
    public int playCount() {
        return playCount;
    }
    
    @Override
    public int compareTo(Song song) {
        return playCount == song.playCount()
            ? Integer.compare(id, song.id())
            : Integer.compare(song.playCount(), playCount);
    }
}