class Solution {
    public int solution(String s) {
        
        for(int i = s.length(); i > 0; i--) {
            for(int j = 0; j+i <= s.length(); j++) {
                if(isPalindrome(s, j, j+i-1)) return i;
            }
        }

        return 0;
    }
    
    boolean isPalindrome(String value, int start, int end) {
        while(start <= end) {
            if(value.charAt(start++) != value.charAt(end--)) return false;
        }
        return true;
    }
}