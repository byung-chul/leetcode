class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanTable = new HashMap<>();
        romanTable.put('I', 1);
        romanTable.put('V', 5);
        romanTable.put('X', 10);
        romanTable.put('L', 50);
        romanTable.put('C', 100);
        romanTable.put('D', 500);
        romanTable.put('M', 1000);

        int result = 0;
        for (int i = 0 ; i < s.length(); i++) {
            int current = romanTable.get(s.charAt(i));

            if (i < s.length() - 1 && current < romanTable.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }
}