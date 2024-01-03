import java.util.*;

public class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> gemCounter = new HashMap<>();
        Queue<String> selectedGems = new LinkedList<>();
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));

        int start = 0;
        int end = Integer.MAX_VALUE;
        int startPoint = 0;

        for (String gem : gems) {
            gemCounter.put(gem, gemCounter.getOrDefault(gem, 0) + 1);
            selectedGems.add(gem);

            while (true) {
                String targetGem = selectedGems.peek();

                if (gemCounter.get(targetGem) <= 1) {
                    break;
                }

                selectedGems.poll();
                start++;
                gemCounter.put(targetGem, gemCounter.get(targetGem) - 1);
            }

            if (gemCounter.size() == gemSet.size() && end > selectedGems.size()) {
                startPoint = start;
                end = selectedGems.size();
            }
        }

        return new int[] {startPoint + 1, startPoint + end};
    }
}