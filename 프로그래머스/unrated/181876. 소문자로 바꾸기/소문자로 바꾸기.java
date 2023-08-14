class Solution {
    public String solution(String myString) {
        String answer = "";
        int tmp;
        for(int i=0; i<myString.length(); i++){
            tmp = (int)myString.charAt(i);
            if((65<=tmp)&&(tmp<=90)){
                answer += (char)(tmp+32);
            }else{
                answer += (char)tmp;
            }
        }
        return answer;
    }
}