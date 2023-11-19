import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();

        if(cacheSize == 0){ //캐시 크기가 0이면
            return cities.length * 5;
        }

        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase(); //대소문자 구분 안하니까

            if(cache.contains(city)){ //만약 있다면
                cache.remove(city); //해당 도시 지우고
                cache.add(city); //맨 뒤에 추가
                answer+=1;
            }

            else{ //없다면
                if(cache.size()==cacheSize){ //이미 캐시 꽉차있으면
                    cache.remove(0); //맨 앞 도시 지우고
                }

              //캐시가 다 안찼으면
                cache.add(city); //맨 뒤에 추가
                answer+=5;
            }
        }

        return answer;
    }
}