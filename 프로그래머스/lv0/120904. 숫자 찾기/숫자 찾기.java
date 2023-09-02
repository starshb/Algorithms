class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        
        String s = Integer.toString(num);
        String[] array = s.split("");
        
        for (int i=0; i<array.length; i++) {
            if (array[i].equals(Integer.toString(k))) {
                return i+1;
            }
        }
        return -1;
    }
}