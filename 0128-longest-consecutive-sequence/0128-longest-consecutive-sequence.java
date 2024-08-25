class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestSequence = 0;
        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int current = i;
                int currentSequence = 1;

                while(set.contains(current+1)) {
                    currentSequence++;
                    current++;
                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }
        return longestSequence;
    }
}