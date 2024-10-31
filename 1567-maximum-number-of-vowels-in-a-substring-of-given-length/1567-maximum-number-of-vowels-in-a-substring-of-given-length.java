class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        char[] sArr = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (isVowels(sArr[i])) {
                maxCount++;
            }
        }

        int windowCount = maxCount;
        for (int i = k; i < s.length(); i++) {
            if (isVowels(sArr[i - k])) {
                windowCount--;
            }
            if (isVowels(sArr[i])) {
                windowCount++;
            }
            maxCount = Math.max(maxCount, windowCount);
        }

        return maxCount;
    }

    private boolean isVowels(char c) {
        char[] vowelArr = {'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowelArr) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }
}