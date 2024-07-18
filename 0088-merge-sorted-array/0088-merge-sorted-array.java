class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1_index = m;
        int nums2_index = 0;
        for(int i = nums2_index; i < n; i++) {
            nums1[nums1_index++] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}