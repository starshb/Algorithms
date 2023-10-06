import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] idList, String[] report, int k){
        // @param idList : 이용자의 ID를 담은 배열.
        // @param report : 신고한 이용자와 신고당한 이용자의 정보를 담은 배열. ex) "a b",.. -> a가 b를 신고
        // @param k      : 신고 횟수에 따른 정지 기준 정수값.
        // @return answer : id_list에 담긴 id 순서대로 각 유저가 받은 신고 결과 메일 개수 배열.
        int[] answer = new int[idList.length];
        HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        HashMap<String, Integer> reportedCountInfoMap = new HashMap<>();
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        for(String reportInfo : reportSet){
            String reporter = reportInfo.split(" ")[0];  // 신고 한 사람
            String reported = reportInfo.split(" ")[1];  // 신고 당한 사람
            reporterInfoMap.putIfAbsent(reporter, new HashSet<String>(){{
                add(reported);
            }});
            reporterInfoMap.get(reporter).add(reported);
            reportedCountInfoMap.put(reported, reportedCountInfoMap.getOrDefault(reported, 0)+1);
        }

        for (String reported : reportedCountInfoMap.keySet()){
            int reportedCount = reportedCountInfoMap.get(reported);
            if(reportedCount >= k){
                // 메일 발송 대상
                for(int i=0; i<idList.length; i++){
                    if(reporterInfoMap.containsKey(idList[i]) && reporterInfoMap.get(idList[i]).contains(reported)) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
   }
}