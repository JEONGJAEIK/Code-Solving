import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : participant) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for (String b : completion) {
            if (map.containsKey(b)) {
                Integer value = map.get(b);
                if (value == 1) {
                    map.remove(b);
                } else {
                    map.put(b, value - 1);
                }
            }
        }
        
        String result = map.keySet().iterator().next();
        return result;
    }
}