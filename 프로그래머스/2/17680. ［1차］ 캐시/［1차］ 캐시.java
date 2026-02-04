import java.util.HashSet;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int runtime = 0;
        
        HashSet<CacheRecord> set = new HashSet<>();
        
        outer:
        for (String city : cities) {
            for (CacheRecord r : set) {
                if (r.city.equalsIgnoreCase(city)) {
                    r.last_hit = runtime;
                    runtime += 1;
                    continue outer;
                }
            }
            if (set.size() < cacheSize) {
            	set.add(new CacheRecord(city, runtime));
                runtime += 5;
                continue ;
            }
            int last_hit = runtime;
            CacheRecord target = null;
            for (CacheRecord r : set) {
                if (r.last_hit < last_hit) {
                    last_hit = r.last_hit;
                    target = r;
                }
            }
            set.remove(target);
            set.add(new CacheRecord(city, runtime));
            runtime += 5;
        }
        return runtime;
    }
}

class CacheRecord {
    String city;
    int last_hit;
    
    CacheRecord(String city, int last_hit) {
        this.city = city;
        this.last_hit = last_hit;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof CacheRecord))
            return false;
        CacheRecord cr = (CacheRecord) obj;
        return (this.city.equalsIgnoreCase(cr.city));
    }
    
    public int hashCode() {
        return (this.city.hashCode());
    }
}