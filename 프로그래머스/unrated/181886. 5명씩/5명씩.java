import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> answerList = new ArrayList<>();

        while (names.length > 0) {
            String[] group = Arrays.copyOfRange(names, 0, Math.min(5, names.length));
            answerList.add(group[0]);
            names = Arrays.copyOfRange(names, Math.min(5, names.length), names.length);
        }

        String[] answer = new String[answerList.size()];
        answer = answerList.toArray(answer);
        return answer;
    }
}