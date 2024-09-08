class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        backtrack(mapping, digits, result, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(Map<Character, String> mapping, String digits, List<String> result, StringBuilder sb, int index){
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String currentMapping = mapping.get(digits.charAt(index));
        for (char c : currentMapping.toCharArray()) {
            sb.append(c);
            backtrack(mapping, digits, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}