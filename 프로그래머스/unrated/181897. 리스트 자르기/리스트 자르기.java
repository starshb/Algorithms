class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        int[] answer;
        
        if (n == 1) {
            answer = new int[b + 1];
            for (int i = 0; i <= b; i++) {
                answer[i] = num_list[i];
            }
        } else if (n == 2) {
            answer = new int[num_list.length - a];
            for (int i = a; i < num_list.length; i++) {
                answer[i - a] = num_list[i];
            }
        } else if (n == 3) {
            answer = new int[b - a + 1];
            for (int i = a; i <= b; i++) {
                answer[i - a] = num_list[i];
            }
        } else if (n == 4) {
            int count = (b - a + 1) / c;
            if ((b - a + 1) % c != 0) {
                count++;
            }
            answer = new int[count];
            
            int index = 0;
            for (int i = a; i <= b; i += c) {
                answer[index++] = num_list[i];
            }
        } else {
            // n이 1, 2, 3, 4 중 하나가 아닌 경우 예외 처리
            answer = new int[0];
        }
        
        return answer;
    }
}