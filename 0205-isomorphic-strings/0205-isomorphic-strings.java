class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sMap.containsKey(sc)) {
                if (sMap.get(sc) != tc) {
                    return false;
                }
            } else {
                sMap.put(sc, tc);
            }

            if (tMap.containsKey(tc)) {
                if (tMap.get(tc) != sc) {
                    return false;
                }
            } else {
                tMap.put(tc, sc);
            }
        }
        return true;
    }
}