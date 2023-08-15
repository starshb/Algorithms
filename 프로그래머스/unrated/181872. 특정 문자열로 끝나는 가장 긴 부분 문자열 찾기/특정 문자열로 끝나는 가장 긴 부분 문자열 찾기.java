class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int patLength = pat.length();
        int myStringLength = myString.length();

        for (int i = myStringLength - 1; i >= 0; i--) {
            String substr = myString.substring(0, i + 1);
            if (substr.endsWith(pat)) {
                answer = substr;
                break;
            }
        }

        return answer;
    }
}