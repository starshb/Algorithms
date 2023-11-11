import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.replaceAll("[\\{,\\}]", " ");
        String[] sa = s.split("[ ]+");
        Map<String, Integer> hashMap = new HashMap<>();


        for(int j = 0; j < sa.length; j++){
            if (!sa[j].equals("")){
                if (hashMap.containsKey(sa[j])){
                    hashMap.replace(sa[j], hashMap.get(sa[j]) + 1);
                }else{
                    hashMap.put(sa[j], 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, (o1, o2) -> {return o2.getValue().compareTo(o1.getValue());});

        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = Integer.parseInt(list.get(i).getKey());
        }


        return answer;
    }
}