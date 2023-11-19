class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxPlayTime = -1;
        String answer = "";
        
      	// 멜로디에 들어있는 # 붙은 음 치환
        m = changeMelody(m);
        
        for (String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");
            String title = info[2];
          	// 악보 정보에 들어있는 # 붙은 음 치환
            String melodyInfo = changeMelody(info[3]);
            
            String[] timeInfo = info[0].split(":");
          	// 시작 시간 분단위로 변환
            int start = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);
            int end = 0;
            
            timeInfo = info[1].split(":");
            // 끝난 시간 분단위로 변환
            end = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);
            
            // 지속 시간 구함
            int play = end - start;
            
            // 음악의 길이보다 재생 지속 시간이 길 때
            if (play > melodyInfo.length()) {
                StringBuilder newMelody = new StringBuilder();
                
                // 나눈 몫 만큼 악보 처음부터 반복
                for (int i = 0; i < play / melodyInfo.length(); i++)
                    newMelody.append(melodyInfo);
                
              	// 나머지만큼 악보에서 잘라서 붙임
                newMelody.append(melodyInfo.substring(0, play % melodyInfo.length()));
                melodyInfo = newMelody.toString();
            } else {
                // 재생 지속 시간 만큼만 재생
                melodyInfo = melodyInfo.substring(0, play);
            }
            
          	// 조건이 일치하는 음악이 여러개면
            // 재생된 시간이 제일 긴 음악 제목을 반환해야 하기 때문에
            // 조건에 멜로디 포함뿐만 아니라, 재생된 시간가지 비교
            if (melodyInfo.contains(m) && play > maxPlayTime) {
                answer = title;
                maxPlayTime = play;
            }
            
        }
        
        return maxPlayTime != -1 ? answer : "(None)";
    }
    
    String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        String newMelody = oldMelody.replaceAll("A#", "L");
        
        return newMelody;
    }
}