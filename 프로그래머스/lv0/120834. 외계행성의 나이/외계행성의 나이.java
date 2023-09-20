class Solution {
     public String solution(int age) {
        String answer="";
        String temp= Integer.toString(age);                 //매개변수로 들어온 int 를 String으로 바꿈
            for(int i=0; i<temp.length(); i++) {            //String의 크기만큼 for문
                answer+=(char) ((char) temp.charAt(i)+49);  //String의 i번째 리터럴에 49를 더한 char값을 넣음
            }
            return answer;
    }
}
