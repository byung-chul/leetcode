class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> romanTable = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        romanTable.put(1, 'I');
        romanTable.put(5, 'V');
        romanTable.put(10, 'X');
        romanTable.put(50, 'L');
        romanTable.put(100, 'C');
        romanTable.put(500, 'D');
        romanTable.put(1000, 'M');

        int digit = 1;
        while (num > 0) {
            StringBuilder unitSb = new StringBuilder();
            int current = num % 10;
            char roman = 'A';
            if (current < 4) {
                // 1단위 이어붙이기
                roman = romanTable.get(digit);
                for (int i = 0; i < current; i++) {
                    unitSb.append(roman);
                }
            } else if (current < 5) {
                // 5단위에서 앞에 하나 빼기
                char minusRoman = romanTable.get(digit);
                roman = romanTable.get(digit * 5);
                unitSb.append(minusRoman).append(roman);
            } else if (current < 9) {
                // 5단위에 1단위 이어붙이기
                char fiveRoman = romanTable.get(digit * 5);
                roman = romanTable.get(digit);
                unitSb.append(fiveRoman);
                for (int i = 0; i < current - 5; i++) {
                    unitSb.append(roman);
                }
            } else if (current == 9) {
                // 다음 자릿 수 1단위에서 앞에 하나 빼기
                char minusRoman = romanTable.get(digit);
                char nextDigitRoman = romanTable.get(digit * 10);
                unitSb.append(minusRoman).append(nextDigitRoman);
            }

            sb.insert(0, unitSb.toString());
            num = num / 10;
            digit = digit * 10;
        }
        return sb.toString();
    }
}