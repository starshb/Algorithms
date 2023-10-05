import java.util.HashMap;
class Solution {
     public int solution(String[] babbling) {
        HashMap<Character,String> words = new HashMap<>() {{
            put('a',"aya");
            put('y',"ye");
            put('w',"woo");
            put('m',"ma");
        }};
        int answer = 0;

        for(String s: babbling) {
            char prev='\u0000';
            int i=0;
            for(;i<s.length();) {
                if(prev==s.charAt(i)) break;
                String word = words.getOrDefault(s.charAt(i),"");
                if(word.equals("")) break;
                String curStr = s.substring(i,Math.min(s.length(),i+word.length()));

                if(curStr.equals(word)) {
                    prev = s.charAt(i);
                    i+= word.length();
                } else break;
            }
            if(i==s.length()) answer++;
        }
        return answer;
    }
}