import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int dayForM = 28;
        int todayY = Integer.parseInt(today.substring(0,4));
        int todayM = Integer.parseInt(today.substring(5,7));
        int todayD = Integer.parseInt(today.substring(8,10));

        int totalD = (todayY*dayForM*12) + (todayM*28) + todayD;
        List<Integer> answerArr = new ArrayList<>();
        HashMap<Character,Integer> termsMap = new HashMap<>();
        for(String term : terms){
            char termO = term.charAt(0);
            int termM = Integer.parseInt(term.substring(2));
            termsMap.put(termO,termM);
        }
        for(int i=0; i<privacies.length; i++){
            char privacyO = privacies[i].charAt(11);
            int privacyY = Integer.parseInt(privacies[i].substring(0,4));
            int privacyM = Integer.parseInt(privacies[i].substring(5,7));
            int privacyD = Integer.parseInt(privacies[i].substring(8,10));
            int totalPrivacyD = (privacyY*12*dayForM) + (privacyM*dayForM) + privacyD;
            int termM = termsMap.get(privacyO);
            int termDay = termM * dayForM;
            if(totalPrivacyD+termDay <=totalD){
                answerArr.add(i+1);
            }
        }

        return answerArr;
    }
}