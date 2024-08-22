class Solution {
    public void rotate(int[] nums, int k) {
        int nLength = nums.length;
        k = k % nLength;

        reverse(nums, 0, nLength - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nLength - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}