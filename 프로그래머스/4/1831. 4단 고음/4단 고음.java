class Solution {
        public int solution(int n) {
            int answer = 0;
            return check(n-2,2);
        }

        private int check(int n, int p) { // n이 현재 값 , p가 plus의 개수
            if(n==3 && p==2)return 1;
            else if( n<3 ||  Math.log(n)/Math.log(3) *2 < p)return 0;
            else if(n==3 && p==3) return 0;

            return check(n-1,p+1)+(n%3==0&&p>1?check(n/3,p-2):0);
        }
    }