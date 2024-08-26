class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            maxLength = 1;
        }

        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int i = 3; i <= length; i++) {
            for (int j = 0; j < length - i + 1; j++) {
                int end = j + i - 1;
                if (s.charAt(j) == s.charAt(end) && dp[j+1][end-1]) {
                    dp[j][end] = true;
                    start = j;
                    maxLength = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}