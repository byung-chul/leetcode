class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> intCountMap = new HashMap<>();

        for (int number : arr) {
            intCountMap.put(number, intCountMap.getOrDefault(number, 0) + 1);
        }

        int mapValueSize = intCountMap.values().size();
        Set<Integer> removeDuplicatedValue = new HashSet<>(intCountMap.values());

        return mapValueSize == removeDuplicatedValue.size();
    }
}