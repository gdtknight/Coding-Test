import java.util.Map;
import java.util.Set;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Arrays;
import java.util.Objects;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, User> userMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], new User(id_list[i]));
        }
        
        for (String reportRecord : report) {
            String[] userIds = reportRecord.split(" ");
            
            User reporter = userMap.get(userIds[0]);
            User reported = userMap.get(userIds[1]);
            
            reporter.reportUser(reported);
            
            if(reported.getReportedCount() >= k) {
                userMap.values().stream()
                    .filter(user -> user.getReportsUserSet().contains(reported))
                    .forEach(user -> user.getStoppedUserSet().add(reported));
            }
        }
        
        return Arrays.stream(id_list)
            .map(userMap::get)
            .map(User::getStoppedUserSet)
            .map(Set::size)
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}

class User {
    
    private String userId;
    private int reportedCount;
    
    private Set<User> reportsUserSet;
    private Set<User> stoppedUserSet;
    
    public User(String userId) {
        this.userId = userId;
        reportedCount = 0;
        reportsUserSet = new HashSet<>();
        stoppedUserSet = new HashSet<>();
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public int getReportedCount() {
        return this.reportedCount;
    }
    
    public Set<User> getReportsUserSet() {
        return this.reportsUserSet;
    }
    
    public Set<User> getStoppedUserSet() {
        return this.stoppedUserSet;
    }
    
    public void increaseReportedCount() {
        this.reportedCount++;
    }
    
    public void reportUser(User reported) {
        if (reportsUserSet.add(reported)) reported.increaseReportedCount();
    }
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        User user = (User) o;
        
        return Objects.equals(userId, user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}