class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;
        for (int c : candies) {
            maxCandies = Math.max(c, maxCandies);
        }

        for (int c: candies) {
            if (c + extraCandies < maxCandies) {
                result.add(false);
            } else {
                result.add(true);
            }
        }

        return result;
    }
}