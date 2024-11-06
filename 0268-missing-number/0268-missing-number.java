class Solution {
    public int missingNumber(int[] nums) {
        boolean[] isExistArr = new boolean[nums.length+1];

        for (int num : nums) {
            isExistArr[num] = true;
        }

        for (int i = 0; i < nums.length+1; i++) {
            if (!isExistArr[i]) {
                return i;
            }
        }
        return 0;
    }
}