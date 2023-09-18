class Solution {
    public String solution(String rsp) {
        String answer = "";
        // rsp 분리 후 
        // if문을 통해 answer에 이기는 경우 문자열 추가
        for(int i = 0; i < rsp.length(); i++){
            if(rsp.split("")[i].equals("0")){
                answer += "5";
            }
            else if(rsp.split("")[i].equals("2")){
                answer += "0";
            }
            else answer += "2";
        }
        return answer;
    }
}