import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    MyDict myDict = new MyDict();
    
    public int[] solution(String msg) {
        // System.out.println(myDict.dictList);
        List<Integer> ansList = new LinkedList<>();
        
        int idx = 0;
        
        while (idx < msg.length()) {
            int keyLen = Math.min(myDict.dictList.size(), msg.length() - idx);
            String key = msg.substring(idx, idx + keyLen);
            while (!(myDict.dictList.get(keyLen - 1).containsKey(key))) {
                keyLen--;
            	key = msg.substring(idx, idx + keyLen);
            }
            ansList.add(myDict.dictList.get(keyLen - 1).get(key));
            if (idx + keyLen + 1 <= msg.length())
             	myDict.putKey(msg.substring(idx, idx + keyLen + 1));
            idx = Math.min(idx + keyLen, msg.length());
            // if (idx == 3)
            //     break;
        }
        
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++)
            ans[i] = ansList.get(i);
        return ans;
    }
    
    
}

class MyDict {
    int nextIdx;
    List<Map<String, Integer>> dictList;
    
    MyDict() {
        nextIdx = 1;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictList = new LinkedList<Map<String, Integer>>();
        Map<String, Integer> map = new HashMap<>();
        for (int idx = 0; idx < alphabet.length(); idx++) {
            map.put(alphabet.substring(idx, idx + 1), nextIdx++);
        }
        dictList.add(map);
    }
    
    public void putKey(String key) {
        Map<String, Integer> map;
        if (key.length() <= dictList.size()) {
        	map = dictList.get(key.length() - 1);
        }
        else {
            // System.out.println("Create long key map");
            map = new HashMap<>();
            dictList.add(map);
        }
        map.put(key, nextIdx++);
        // System.out.printf("%s - %d\n", key, nextIdx);
    }
}