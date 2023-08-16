import java.util.*;
class Solution {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        String str = "";
        for(int i =0; i < myString.length(); i++) {
            if(myString.charAt(i) != 120) {
                str += myString.charAt(i);
            }else {
                list.add(str);
                str = "";
            }
        }
        if(!str.equals("")) {
            list.add(str);
        }
        String[] answer = list.stream().filter(x -> !x.equals("")).sorted().toArray(String[]::new);
        return answer;
    }
}