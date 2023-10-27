import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // String 배열은 Int 배열로 변환
        int[][] bookTimeInt = new int[book_time.length][2];
        
        // String[] 배열을 빠른 확인을 위해 Int[] 배열로 변환
        for(int i=0; i<book_time.length; i++) {
            int startTime = Integer.parseInt(book_time[i][0].replace(":", ""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            // 이 때 뒤에 10분을 붙여서 저장
            endTime+=10;
            // 10분이 더해져서 60분을 초과했을 경우 1시간 추가 후 60분 차감
            if(endTime%100 >= 60) {
                endTime+=40;
            }
            
            bookTimeInt[i][0] = startTime;
            bookTimeInt[i][1] = endTime;
        }
        
        // 시작 시간이 빠른 순으로 정렬
        // 시작 시간이 같다면 종료 시간이 빠른 순으로 정렬
        Arrays.sort(bookTimeInt, (a, b)->{
            
            if(a[0] > b[0]) return 1;
            else if(a[0] < b[0]) return -1;
            else {
                if(a[1] > b[1]) return 1;
                else return -1;
            }
        });
        
        // 항상 가장 빨리 비는 방을 찾기 위해 PriorityQueue 사용
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for(int[] timeArr : bookTimeInt) {
            if(rooms.size() == 0) {
                // 첫 예약일 경우 종료 시간 저장
                rooms.add(timeArr[1]);
                continue;
            }
            
            // 두 번째 예약일 경우 빈 방이 있으면 해당 방에 넣고, 아니면 새 방 배정
            int earliestEmptyRoom = rooms.peek();
            if(timeArr[0] >= earliestEmptyRoom) {
                rooms.poll();
                rooms.add(timeArr[1]);
            }
            else {
                rooms.add(timeArr[1]);
            }
        }
        
        return rooms.size();
    }
}