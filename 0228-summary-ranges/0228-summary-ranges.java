class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        
        if (nums.length == 0) {
            return ranges; // 빈 배열에 대해 빈 리스트 반환
        }
        
        int start = nums[0]; // 첫 번째 숫자를 시작점으로 설정
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    ranges.add(String.valueOf(start)); 
                } else {
                    ranges.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        
        if (start == nums[nums.length - 1]) {
            ranges.add(String.valueOf(start));
        } else {
            ranges.add(start + "->" + nums[nums.length - 1]);
        }
        
        return ranges;
    }
}