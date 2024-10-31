class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> word1CharacterMap = new HashMap<>();
        Map<Character, Integer> word2CharacterMap = new HashMap<>();

        for (char c : word1.toCharArray()) {
            word1CharacterMap.put(c, word1CharacterMap.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            word2CharacterMap.put(c, word2CharacterMap.getOrDefault(c, 0) + 1);
        }

        if (!word1CharacterMap.keySet().equals(word2CharacterMap.keySet())) {
            return false;
        }

        List<Integer> word1CharacterFrequency = new ArrayList<>(word1CharacterMap.values());
        List<Integer> word2CharacterFrequency = new ArrayList<>(word2CharacterMap.values());
        Collections.sort(word1CharacterFrequency);
        Collections.sort(word2CharacterFrequency);
        return word1CharacterFrequency.equals(word2CharacterFrequency);
    }
}