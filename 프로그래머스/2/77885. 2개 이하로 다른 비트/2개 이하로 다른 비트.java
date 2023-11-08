class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        answer = new long[numbers.length];
        int idx = 0;
        for (long n : numbers) {
            if (n % 2 == 0) {
                answer[idx] = n + 1;
            } else {
                StringBuilder binary = new StringBuilder(Long.toBinaryString(n));
                int len = binary.length();
                if (binary.toString().contains("01")) {
                    for (int i = len; i > 0; i--) {
                        if (binary.substring(i - 2, i).equals("01")) {
                            binary.setCharAt(i - 1, '0');
                            binary.setCharAt(i - 2, '1');
                            break;
                        }
                    }
                } else {
                    binary.deleteCharAt(0);
                    binary.insert(0, "10");
                }
                answer[idx] = Long.valueOf(binary.toString(), 2);
            }
            idx += 1;
        }
        return answer;
    }
}