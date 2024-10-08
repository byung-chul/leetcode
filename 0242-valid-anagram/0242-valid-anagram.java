class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!sMap.containsKey(c) || sMap.get(c) == 0) {
                return false;
            }
            sMap.put(c, sMap.get(c) - 1);
        }
        return true;
    }
}