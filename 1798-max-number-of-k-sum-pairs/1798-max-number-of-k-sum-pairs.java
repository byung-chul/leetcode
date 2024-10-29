class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int remain = k - num;
            if (m.getOrDefault(remain, 0) > 0) {
                count++;
                m.put(remain, m.get(remain) - 1);
            } else {
                m.put(num, m.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}