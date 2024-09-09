class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(next3, next5), next2);
            ugly[i] = min;

            if (min == next2) {
                index2++;
                next2 = ugly[index2] * 2;
            }
            if (min == next3) {
                index3++;
                next3 = ugly[index3] * 3;
            }
            if (min == next5) {
                index5++;
                next5 = ugly[index5] * 5;
            }
        }

        return ugly[n-1];
    }
}