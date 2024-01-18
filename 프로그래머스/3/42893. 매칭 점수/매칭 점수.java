import java.util.*;

class Solution {
    public int N;
    public int[] normalScore;          //노말 스코어
    public List<List<String>> outLink; //외부 링크맵
    public String[] url;               //url 정보
    public double[] linkScore;           //링크 스코어

    public int solution(String word, String[] pages) {
        //초기화
        N = pages.length;
        normalScore = new int[N];
        outLink = new ArrayList<>();
        for (int i = 0; i < N; i++)
            outLink.add(new ArrayList<>());
        url = new String[N];
        linkScore = new double[N];
        word = word.toLowerCase();

        //1. 모든 링크의 기본점수, url, 외부링크맵 생성
        for (int i = 0; i < N; i++) {
            //모든 줄 확인
            StringTokenizer st = new StringTokenizer(pages[i], "\n");
            while(st.hasMoreTokens()) {
                String line = st.nextToken();
                //url 찾기
                if (line.contains("meta") && line.contains("content") && url[i] == null) {
                    StringTokenizer inner = new StringTokenizer(line, "\"");
                    while(inner.hasMoreTokens()) {
                        String text = inner.nextToken();
                        if (text.startsWith("https")) {
                            url[i] = text;
                            break;
                        }
                    }
                }
                //외부 링크맵 만들기
                if (line.contains("<a href=")) {
                    StringTokenizer inner = new StringTokenizer(line, "\"");
                    while(inner.hasMoreTokens()) {
                        String text = inner.nextToken();
                        if (text.startsWith("https")) {
                            outLink.get(i).add(text);
                        }
                    }
                }
                //기본 점수 계산
                line = line.toLowerCase();
                line = line.replaceAll("[^a-z]", " ");
                StringTokenizer inner = new StringTokenizer(line);
                while(inner.hasMoreTokens()) {
                    if (word.equals(inner.nextToken()))
                        normalScore[i]++;
                }
            }
        }

        //2 각 url의 링크 점수 계산
        for (int i = 0; i < N; i++) {
            double result = normalScore[i] / (double)outLink.get(i).size();
            for (int j = 0; j < outLink.get(i).size(); j++) {
                String outLinkUrl = outLink.get(i).get(j);
                for (int ind = 0; ind < N; ind++) {
                    if (url[ind].equals(outLinkUrl))
                        linkScore[ind] += result;
                }
            }
        }
        //3. 결과 계산
        int resultInd = 0;
        double maxScore = 0;
        for (int i =0; i < N; i++) {
            double totalScore = normalScore[i] + linkScore[i];
            if (totalScore > maxScore) {
                maxScore = totalScore;
                resultInd = i;
            }
        }
        return resultInd;
    }
}