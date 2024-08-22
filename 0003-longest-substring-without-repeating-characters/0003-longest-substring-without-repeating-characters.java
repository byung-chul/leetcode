class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);

            if (charMap.containsKey(c)) {
                start = Math.max(start, charMap.get(c) + 1);
            }
            charMap.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}