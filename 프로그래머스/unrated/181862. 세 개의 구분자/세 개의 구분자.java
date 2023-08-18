import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String myStr) {
        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();
        for (char c : myStr.toCharArray()) {
            if (c == 'a' || c == 'b' || c == 'c') {
                if (current.length() > 0) {
                    result.add(current.toString());
                    current = new StringBuilder();
                }
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            result.add(current.toString());
        }

        if (result.isEmpty()) {
            return new String[]{"EMPTY"};
        } else {
            return result.toArray(new String[0]);
        }
    }
}