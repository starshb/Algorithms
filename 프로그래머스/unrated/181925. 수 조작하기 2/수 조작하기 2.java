class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            if (diff == 1) {
                sb.append("w");
            } else if (diff == -1) {
                sb.append("s");
            } else if (diff == 10) {
                sb.append("d");
            } else if (diff == -10) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}