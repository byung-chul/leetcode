class Solution {
    public String removeStars(String s) {
        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '*') {
                charStack.add(c);
            } else {
                if (charStack.peek() != null) {
                    charStack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charStack) {
            sb.append(c);
        }
        return sb.toString();
    }
}