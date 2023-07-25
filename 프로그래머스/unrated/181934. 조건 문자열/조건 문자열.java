class Solution {
        public int solution(String ineq, String eq, int n, int m) {
                if (ineq.equals(">")) {
                        if (eq.equals("=")) {
                                return n >= m ? 1 : 0;
                        } else if (eq.equals("!")) {
                                return n > m ? 1 : 0;
                        }
                } else if (ineq.equals("<")) {
                        if (eq.equals("=")) {
                                return n <= m ? 1 : 0;
                        } else if (eq.equals("!")) {
                                return n < m ? 1 : 0;
                        }
                }

                return 0; // 기본적으로 0을 반환 (조건에 맞지 않는 경우)
        }
}