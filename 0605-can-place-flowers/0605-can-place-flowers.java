class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (flowerbed[i] == 0) {
                boolean isBeforeEmpty = (i == 0 || flowerbed[i-1] == 0);
                boolean isNextEmpty = (i == size - 1 || flowerbed[i+1] == 0);
                if (isBeforeEmpty && isNextEmpty) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        
        return count >= n;
    }
}