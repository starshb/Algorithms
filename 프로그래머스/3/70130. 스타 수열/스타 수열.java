import java.util.*;
class Solution {
    public int solution(int[] a) {
        int ret = 0;
		Map<Integer, List<Integer>> hm = new HashMap<>();
        // 숫자별 index 저장
        for(int i=0; i<a.length ; i++) {
        	int n = a[i];
        	if(!hm.containsKey(n)) hm.put(n, new ArrayList<>());
        	hm.get(n).add(i);
        }
        for(Map.Entry<Integer, List<Integer>> e : hm.entrySet()) {
        	int s=0, len=0;
        	for(int idx : e.getValue()) {
                if(idx<s) continue;
        		while(s<a.length && a[s]==e.getKey()) {
        			s++;
        		}
        		if(s<a.length) len+=2;
        		if(s<idx) s = idx;
        		s++;
        	}
        	ret = Math.max(ret, len);
        }
        return ret;
    }
}