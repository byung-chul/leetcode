class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 문자열이 서로를 나눌 수 없다면, 공통 패턴이 없으므로 빈 문자열 반환
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // 두 문자열 길이의 최대 공약수를 구함
        int gcdLength = gcd(str1.length(), str2.length());
        
        // str1의 앞부분부터 gcd 길이만큼의 문자열 반환
        return str1.substring(0, gcdLength);
    }
    
    // 두 숫자의 최대 공약수를 구하는 함수
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}