# [level 3] 파괴되지 않은 건물 - 92344 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/92344) 

### 성능 요약

메모리: 216 MB, 시간: 47.58 ms

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

### 채점결과

정확성: 53.8<br/>효율성: 46.2<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 2일 4:53:37

### 문제 설명

<h5>문제 설명</h5>

<p><strong>[본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]</strong></p>

<p>N x M 크기의 행렬 모양의 게임 맵이 있습니다. 이 맵에는 내구도를 가진 건물이 각 칸마다 하나씩 있습니다. 적은 이 건물들을 공격하여 파괴하려고 합니다. 건물은 적의 공격을 받으면 내구도가 감소하고 내구도가 0이하가 되면 파괴됩니다. 반대로, 아군은 회복 스킬을 사용하여 건물들의 내구도를 높이려고 합니다.</p>

<p>적의 공격과 아군의 회복 스킬은 항상 직사각형 모양입니다.<br>
예를 들어, 아래 사진은 크기가 4 x 5인 맵에 내구도가 5인 건물들이 있는 상태입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/9932445f-244d-4188-a559-f16044cfa4d3/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_01.png" title="" alt="04_2022_공채문제_파괴되지않은건물_01.png"></p>

<p>첫 번째로 적이 맵의 <strong>(0,0)부터 (3,4)까지 공격하여 4만큼</strong> 건물의 내구도를 낮추면 아래와 같은 상태가 됩니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/2a3df058-d7b6-4317-9352-8f9713a9424a/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_02.png" title="" alt="04_2022_공채문제_파괴되지않은건물_02.png"></p>

<p>두 번째로 적이 맵의 <strong>(2,0)부터 (2,3)까지 공격하여 2만큼</strong> 건물의 내구도를 낮추면 아래와 같이 4개의 건물이 파괴되는 상태가 됩니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/94a07a93-71e3-447c-83cf-f855176e28c1/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_03.png" title="" alt="04_2022_공채문제_파괴되지않은건물_03.png"></p>

<p>세 번째로 아군이 맵의 <strong>(1,0)부터 (3,1)까지 회복하여 2만큼</strong> 건물의 내구도를 높이면 아래와 같이 <strong>2개의 건물이 파괴되었다가 복구</strong>되고 2개의 건물만 파괴되어있는 상태가 됩니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/145dfcf7-02aa-44fd-b01b-ff56fb5b0dad/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_04.png" title="" alt="04_2022_공채문제_파괴되지않은건물_04.png"></p>

<p>마지막으로 적이 맵의 <strong>(0,1)부터 (3,3)까지 공격하여 1만큼</strong> 건물의 내구도를 낮추면 아래와 같이 8개의 건물이 더 파괴되어 총 10개의 건물이 파괴된 상태가 됩니다. <strong>(내구도가 0 이하가 된 이미 파괴된 건물도, 공격을 받으면 계속해서 내구도가 하락하는 것에 유의해주세요.)</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/9ce05af0-e5b9-483a-aeb4-d7c0624c2dfb/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_05.png" title="" alt="04_2022_공채문제_파괴되지않은건물_05.png"></p>

<p>최종적으로 총 10개의 건물이 파괴되지 않았습니다.</p>

<p>건물의 내구도를 나타내는 2차원 정수 배열 <code>board</code>와 적의 공격 혹은 아군의 회복 스킬을 나타내는 2차원 정수 배열 <code>skill</code>이 매개변수로 주어집니다. 적의 공격 혹은 아군의 회복 스킬이 모두 끝난 뒤 파괴되지 않은 건물의 개수를 return하는 solution함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>board</code>의 행의 길이 (= <code>N</code>) ≤ 1,000</li>
<li>1 ≤ <code>board</code>의 열의 길이 (= <code>M</code>) ≤ 1,000</li>
<li>1 ≤ <code>board</code>의 원소 (각 건물의 내구도) ≤ 1,000</li>
<li>1 ≤ <code>skill</code>의 행의 길이 ≤ 250,000</li>
<li><code>skill</code>의 열의 길이  = 6</li>
<li><code>skill</code>의 각 행은 <code>[type, r1, c1, r2, c2, degree]</code>형태를 가지고 있습니다.

<ul>
<li>type은 1 혹은 2입니다.

<ul>
<li>type이 1일 경우는 적의 공격을 의미합니다. 건물의 내구도를 낮춥니다.</li>
<li>type이 2일 경우는 아군의 회복 스킬을 의미합니다. 건물의 내구도를 높입니다.</li>
</ul></li>
<li>(r1, c1)부터 (r2, c2)까지 직사각형 모양의 범위 안에 있는 건물의 내구도를 degree 만큼 낮추거나 높인다는 뜻입니다.

<ul>
<li>0 ≤ r1 ≤ r2 &lt; <code>board</code>의 행의 길이</li>
<li>0 ≤ c1 ≤ c2 &lt; <code>board</code>의 열의 길이 </li>
<li>1 ≤ degree ≤ 500 </li>
<li>type이 1이면 degree만큼 건물의 내구도를 낮춥니다.</li>
<li>type이 2이면 degree만큼 건물의 내구도를 높입니다.</li>
</ul></li>
</ul></li>
<li>건물은 파괴되었다가 회복 스킬을 받아 내구도가 1이상이 되면 파괴되지 않은 상태가 됩니다. 즉, 최종적으로 건물의 내구도가 1이상이면 파괴되지 않은 건물입니다.</li>
</ul>

<h5>정확성 테스트 케이스 제한 사항</h5>

<ul>
<li>1 ≤ <code>board</code>의 행의 길이 (= <code>N</code>) ≤ 100</li>
<li>1 ≤ <code>board</code>의 열의 길이 (= <code>M</code>) ≤ 100</li>
<li>1 ≤ <code>board</code>의 원소 (각 건물의 내구도) ≤ 100</li>
<li>1 ≤ <code>skill</code>의 행의 길이 ≤ 100

<ul>
<li>1 ≤ degree ≤ 100 </li>
</ul></li>
</ul>

<h5>효율성 테스트 케이스 제한 사항</h5>

<ul>
<li>주어진 조건 외 추가 제한사항 없습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>board</th>
<th>skill</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]</td>
<td>[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]</td>
<td>10</td>
</tr>
<tr>
<td>[[1,2,3],[4,5,6],[7,8,9]]</td>
<td>[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]</td>
<td>6</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>&lt;초기 맵 상태&gt;</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/aa43439f-3d2f-4307-97ce-5910105b4487/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_06.png" title="" alt="04_2022_공채문제_파괴되지않은건물_06.png"></p>

<p>첫 번째로 적이 맵의 <strong>(1,1)부터 (2,2)까지 공격하여 4만큼</strong> 건물의 내구도를 낮추면 아래와 같은 상태가 됩니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/aa361925-45e4-4bd0-9ef7-e182ed1c6f03/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_07.png" title="" alt="04_2022_공채문제_파괴되지않은건물_07.png"></p>

<p>두 번째로 적이 맵의 <strong>(0,0)부터 (1,1)까지 공격하여 2만큼</strong> 건물의 내구도를 낮추면 아래와 같은 상태가 됩니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/43c218a1-73c4-4d54-9568-0c21aa7f6365/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_08.png" title="" alt="04_2022_공채문제_파괴되지않은건물_08.png"></p>

<p>마지막으로 아군이 맵의 <strong>(2,0)부터 (2,0)까지 회복하여 100만큼</strong> 건물의 내구도를 높이면 아래와 같은 상황이 됩니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/5190fee3-8e81-45b7-a79c-1dfc31d8e05f/04_2022_%E1%84%80%E1%85%A9%E1%86%BC%E1%84%8E%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AB%E1%84%8C%E1%85%A6_%E1%84%91%E1%85%A1%E1%84%80%E1%85%AC%E1%84%83%E1%85%AC%E1%84%8C%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AD%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A5%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF_09.png" title="" alt="04_2022_공채문제_파괴되지않은건물_09.png"></p>

<p>총, 6개의 건물이 파괴되지 않았습니다. 따라서 6을 return 해야 합니다.</p>

<hr>

<h5>제한시간 안내</h5>

<ul>
<li>정확성 테스트 : 10초</li>
<li>효율성 테스트 : 언어별로 작성된 정답 코드의 실행 시간의 적정 배수</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges