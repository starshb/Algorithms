import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i< survey.length; i++) {
            int value = choices[i];

            if(value > 0 && value < 4) {
                char ch = survey[i].charAt(0);
                map.put(ch, map.getOrDefault(ch, 0) + 4 - value);
            } else if(value > 4) {
                char ch = survey[i].charAt(1);
                map.put(ch, map.getOrDefault(ch, 0) + value - 4);
            }

        }

        return new StringBuilder()
            .append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
            .append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
            .append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
            .append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N')
            .toString();
    }
}