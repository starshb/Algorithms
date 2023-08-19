import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> X = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                int num = arr[i];
                for (int j = 0; j < num * 2; j++) {
                    X.add(num);
                }
            } else {
                int num = arr[i];
                int size = X.size();
                if (size >= num) {
                    for (int j = 0; j < num; j++) {
                        X.remove(size - 1 - j);
                    }
                }
            }
        }

        int[] answer = new int[X.size()];
        for (int i = 0; i < X.size(); i++) {
            answer[i] = X.get(i);
        }

        return answer;
    }
}