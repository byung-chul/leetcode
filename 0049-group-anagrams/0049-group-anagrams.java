class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] cArray = s.toCharArray();
            Arrays.sort(cArray);
            String sortedString = new String(cArray);

            if (!anagramMap.containsKey(sortedString)) {
                anagramMap.put(sortedString, new ArrayList<>());
            }
            anagramMap.get(sortedString).add(s);
        }
        return new ArrayList<>(anagramMap.values());
    }
}