import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Step 1: sort string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Step 2: group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}