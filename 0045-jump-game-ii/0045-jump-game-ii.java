class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int count = 0;
        int farest = 0;
        int current = 0;

        for (int i = 0; i < length - 1; i++) {
            farest = Math.max(farest, i + nums[i]);

            if (i == current) {
                count++;
                current = farest;

                if (current >= length - 1) {
                    break;
                }
            }
        }

        return count;
    }
}