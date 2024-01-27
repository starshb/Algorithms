import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static int solution(int N, int number) {
        //통만들기
    	List<HashSet<Integer>> list=  new ArrayList<HashSet<Integer>>();
        
    	//총 8개 통 만들자~(i는 곧 쓰인 숫자의 개수가됨)
        for(int i=0; i<=8; i++)
        	list.add(new HashSet<Integer>());
        list.get(1).add(N);//숫자 1개만 쓸땐 무조건 자기자신밖에 못드감. 초기화 
        if(number==N) return 1;
        
        //숫자 1개 쓸때는 이미 초기화 했으니 숫자 2개 쓸때부터 탐색 ㄱㄱ
        for(int i=2; i<=8; i++) {
        	//total = 숫자를 i개 썼을때 숫자들이 들어갈 통.
        	HashSet<Integer> total = list.get(i);
        	
        	//이전 통들을 가지고 경우의수 찾기.
        	//예를 들어 3번통에 드갈 숫자들을 찾으려면 
        	//3번통 = 1번통(+,-,*,/)2번통 , 3번통 =  2번통(+,-,*,/)1번통 이됨.
        	for(int j=1; j<i; j++) {
        		HashSet<Integer> a = list.get(j);
        		HashSet<Integer> b = list.get(i-j);
        		
        		//즉, i번째 통 = a(+,-,*,/)b , i번째 통 = b(+,-,*,/)a 
        		for(int x:a) {
        			for(int y:b) {
        				total.add(x+y);
        				total.add(x-y);
        				total.add(x*y);
        				if(x!=0 && y!=0) total.add(x/y);
        			}
        		}
        		//같은숫자로 된거 추가.
        		//예를들어 n=8일때 5번째 통에선 88888 를 넣어줘야함. 
        		total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        	}
        	
        	//i번째통에 숫자 다채웠을때 통안에 number가 있다면 바로 i번째 통을 반환
        	if(total.contains(number)) return i;
        }
        
        //통 8개를 찾았는데 숫자가 없다? -> 최소값 8이상 -> -1반환
        return -1;
    }
}