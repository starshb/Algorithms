class Solution {
    // 오프닝 건너뛰기
    public int skipOpening(int t, int op_start, int op_end) {
        if (t >= op_start && t <= op_end) {
            return op_end;
        }
        return t;
    }

    // 문자열을 초로 변환
    public int convertToSeconds(String s) {
        String[] parts = s.split(":");
        int mm = Integer.parseInt(parts[0]);
        int ss = Integer.parseInt(parts[1]);
        return mm * 60 + ss;
    }

    // 초를 문자열로 변환
    public String convertToString(int t) {
        int mm = t / 60;
        int ss = t % 60;
        return String.format("%02d:%02d", mm, ss);
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int videoLen = convertToSeconds(video_len);
        int position = convertToSeconds(pos);
        int opStart = convertToSeconds(op_start);
        int opEnd = convertToSeconds(op_end);

        // 오프닝 건너뛰기
        position = skipOpening(position, opStart, opEnd);

        // 명령어에 따른 동작
        for (String command: commands) {
            if (command.equals("prev")) {
                position = Math.max(position - 10, 0);
            } else {
                position = Math.min(position + 10, videoLen);
            }
            position = skipOpening(position, opStart, opEnd);
        }

        String answer = convertToString(position);
        return answer;
    }
}