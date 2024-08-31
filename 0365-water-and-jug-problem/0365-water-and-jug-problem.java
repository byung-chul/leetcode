class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }
        if (target == 0 || target == x + y) {
            return true;
        }

        return target % gdb(x, y) == 0;
    }

    private int gdb(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}