class Solution {
    public int solution(int[] date1, int[] date2) {
        if(date1[0] != date2[0]){
            return date1[0] < date2[0] ? 1 : 0;
        }
        if(date1[1] != date2[1]) {
            return date1[1] < date2[1] ? 1 : 0;
        }
        if(date1[2] != date2[2]) {
            return date1[2] < date2[2] ? 1 : 0;
        }
        return 0;
    }
}