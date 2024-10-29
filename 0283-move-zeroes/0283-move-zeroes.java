class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[nonZeroCount] = num;
                nonZeroCount++;
            }
        } 

        for (int i = nonZeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
        
    }
}