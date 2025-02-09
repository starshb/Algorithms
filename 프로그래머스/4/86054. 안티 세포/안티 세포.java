import java.util.*;

public class Solution {
  private static final int DIV = 1_000_000_007;

  private static int sum(int a, int b) {
    long sum = (long) a + b;
    return (int) (sum % DIV);
  }

  private static class Count {
    final long sum;
    final int count;
    final int offset;

    public Count(long sum, int count, int offset) {
      this.sum = sum;
      this.count = count;
      this.offset = offset;
    }
  }

  private int solve(int[] b) {
    List<Map<Long, Count>> counts = new ArrayList<>(b.length);
    for (int i = 0; i < b.length; i++) {
      Map<Long, Count> map = new HashMap<>();
      counts.add(map);

      long targetSum = b[i];
      if (i == 0) {
        map.put(targetSum, new Count(targetSum, 1, i));
      } else {
        map.put(
            targetSum,
            new Count(
                targetSum,
                counts.get(i - 1).values().stream()
                    .mapToInt(c -> c.count)
                    .reduce(Solution::sum)
                    .orElse(0),
                i));
      }

      while (true) {
        targetSum *= 2;
        Count lastCount = map.get(targetSum / 2);

        int prevOffset = lastCount.offset - 1;
        if (prevOffset < 0) break;

        Map<Long, Count> prevMap = counts.get(prevOffset);
        if (!prevMap.containsKey(targetSum / 2)) break;

        Count count = prevMap.get(targetSum / 2);
        map.put(targetSum, new Count(targetSum, count.count, count.offset));
      }
    }

    return counts.get(counts.size() - 1).values().stream()
        .mapToInt(c -> c.count)
        .reduce(Solution::sum)
        .orElse(0);
  }

  public int[] solution(int[] a, int[] s) {
    int[] answer = new int[s.length];
    int offset = 0;
    for (int i = 0; i < answer.length; i++) {
      answer[i] = solve(Arrays.copyOfRange(a, offset, offset + s[i]));
      offset += s[i];
    }
    return answer;
  }
}