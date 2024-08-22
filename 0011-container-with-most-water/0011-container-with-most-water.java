class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;

        while (left < right) {
            int lowerHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = lowerHeight * width;
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}