class Solution {
    public String reverseVowels(String s) {
        char[] sca = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && vowels.indexOf(sca[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(sca[right]) == -1) {
                right--;
            }

            char temp = sca[left];
            sca[left] = sca[right];
            sca[right] = temp;
            left++;
            right--;
        }
        return new String(sca);
    }
}