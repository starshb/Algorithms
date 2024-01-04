import java.util.Arrays;
import java.util.HashSet;
public class Solution {
    static boolean[] check;//방문 배열
    static HashSet<String> set;//경우의 수를 담기위한 HashSet
	public static int solution(String[] userid, String[] banid) {
        check = new boolean[userid.length];
        set = new HashSet<String>();
        
        //정규식표현을 위해 '*'를 '.'로 바꾼다.
        //정규식표현에서 '.'은 해당 위치의 모든 문자를 대변한다.
        for(int i=0; i<banid.length; i++) 
        	banid[i] = banid[i].replace('*', '.');
        
        back(0,"",banid,userid);//조합
        
		return set.size();
	}
	
	public static void back(int depth, String res, String[] banid, String[] userid) {
		if(depth==banid.length) {//불량유저id 개수만큼 조합이 만들질때 종료
			//조합된 아아디 배열에 담고 정렬
			String[] arr = res.split(" ");
			Arrays.sort(arr);
			
			String str="";
			for(String s:arr) str+=s;//정렬된 id들을 하나의 문자열로 추가
			set.add(str);//중복되는 경우의수는 HashSet로 하나만 남음.
			
			return;
		}
		
		for(int i=0; i<userid.length; i++) {//유저id 조합
			//이미 쓴 유저id or 불량 id중 '.'을 제오하고 유저id랑 다른 부분이 있으면 탐색안함.
			if(check[i] || !userid[i].matches(banid[depth])) continue;			
			check[i]=true;
			back(depth+1,userid[i]+" "+res,banid,userid);
			check[i]=false;
		}
	}
}