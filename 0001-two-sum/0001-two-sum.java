class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(target - current)) {
                return new int[]{map.get(target - current), i};
            }
            map.put(current, i);
        }
        return new int[]{};
    }
}