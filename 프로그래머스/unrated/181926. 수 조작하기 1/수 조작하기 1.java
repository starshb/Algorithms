class Solution {
    public int solution(int n, String control) {
        for (char c : control.toCharArray()) {
            switch (c) {
                case 'w':
                    n++;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n += 10;
                    break;
                case 'a':
                    n -= 10;
                    break;
            }
        }
        return n;
    }
}