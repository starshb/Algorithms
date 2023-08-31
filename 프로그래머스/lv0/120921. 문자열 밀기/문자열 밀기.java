class Solution {
    public int solution(String A, String B) {
        int count = 0;

        String word = A;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (word.equals(B)) return count;
            sb.append(word.substring(word.length() - 1))
                    .append(word, 0, word.length() -1);
            word = sb.toString();
            sb.setLength(0);
            count++;
        }
        return -1;
    }
}