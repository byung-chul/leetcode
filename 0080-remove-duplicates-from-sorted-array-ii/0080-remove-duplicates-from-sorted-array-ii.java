import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int targetIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[targetIndex-2]) {
                nums[targetIndex] = nums[i];
                targetIndex++;
            }
        }
        return targetIndex;
    }
}