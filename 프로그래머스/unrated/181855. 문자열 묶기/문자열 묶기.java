import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> groupCounts = new HashMap<>(); // 각 그룹의 개수를 저장할 맵
        
        // 문자열 배열의 원소들을 그룹으로 묶고, 그룹별 개수를 계산
        for (String str : strArr) {
            int length = str.length();
            groupCounts.put(length, groupCounts.getOrDefault(length, 0) + 1);
        }
        
        int maxCount = 0; // 가장 개수가 많은 그룹의 크기
        
        // 가장 개수가 많은 그룹의 크기 찾기
        for (int count : groupCounts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        return maxCount;
    }
}