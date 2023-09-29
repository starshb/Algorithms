class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;                     //리턴값으로 쓸 정수
        for(int i=0; i<array.length; i++)   //0부터 매개변수로 들어온 array배열의 크기까지 for문 돌림
            if(array[i]==n) {               //만약 array의 i번째 수와 매개변수로 들어온 정수n과 같다면
                answer++;                   //answer에 +1
            }
        return answer;                      //answer를 리턴
    }
}
