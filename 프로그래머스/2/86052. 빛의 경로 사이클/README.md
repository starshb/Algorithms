# [level 2] 빛의 경로 사이클 - 86052 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86052) 

### 성능 요약

메모리: 129 MB, 시간: 62.28 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 11월 2일 8:37:11

### 문제 설명

<p>각 칸마다 S, L, 또는 R가 써져 있는 격자가 있습니다. 당신은 이 격자에서 빛을 쏘고자 합니다. 이 격자의 각 칸에는 다음과 같은 특이한 성질이 있습니다.</p>

<ul>
<li>빛이 "S"가 써진 칸에 도달한 경우, 직진합니다.</li>
<li>빛이 "L"이 써진 칸에 도달한 경우, 좌회전을 합니다.</li>
<li>빛이 "R"이 써진 칸에 도달한 경우, 우회전을 합니다.</li>
<li>빛이 격자의 끝을 넘어갈 경우, 반대쪽 끝으로 다시 돌아옵니다. 예를 들어, 빛이 1행에서 행이 줄어드는 방향으로 이동할 경우, 같은 열의 반대쪽 끝 행으로 다시 돌아옵니다.</li>
</ul>

<p>당신은 이 격자 내에서 빛이 이동할 수 있는 경로 사이클이 몇 개 있고, 각 사이클의 길이가 얼마인지 알고 싶습니다. 경로 사이클이란, 빛이 이동하는 순환 경로를 의미합니다.</p>

<p>예를 들어, 다음 그림은 격자 <code>["SL","LR"]</code>에서 1행 1열에서 2행 1열 방향으로 빛을 쏠 경우, 해당 빛이 이동하는 경로 사이클을 표현한 것입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/f3c02c50-f82e-45d0-b633-ad3ecadba316/ex1.png" title="" alt="ex1.png"></p>

<p>이 격자에는 길이가 16인 사이클 1개가 있으며, 다른 사이클은 존재하지 않습니다.</p>

<p>격자의 정보를 나타내는 1차원 문자열 배열 <code>grid</code>가 매개변수로 주어집니다. 주어진 격자를 통해 만들어지는 빛의 경로 사이클의 모든 길이들을 배열에 담아 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>grid</code>의 길이 ≤ 500

<ul>
<li>1 ≤ <code>grid</code>의 각 문자열의 길이 ≤ 500</li>
<li><code>grid</code>의 모든 문자열의 길이는 서로 같습니다.</li>
<li><code>grid</code>의 모든 문자열은 <code>'L', 'R', 'S'</code>로 이루어져 있습니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>grid</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>["SL","LR"]</code></td>
<td>[16]</td>
</tr>
<tr>
<td><code>["S"]</code></td>
<td>[1,1,1,1]</td>
</tr>
<tr>
<td><code>["R","R"]</code></td>
<td>[4,4]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>문제 예시와 같습니다.</li>
<li>길이가 16인 사이클이 하나 존재하므로(다른 사이클은 없습니다.), <code>[16]</code>을 return 해야 합니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>주어진 격자를 통해 만들 수 있는 사이클들은 다음 그림과 같습니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/88a2717d-14ab-4297-af06-00baab718080/ex2.png" title="" alt="ex2.png"></p>

<ul>
<li>4개의 사이클의 길이가 모두 1이므로, <code>[1,1,1,1]</code>을 return 해야 합니다.</li>
</ul>

<p><strong>입출력 예 #3</strong></p>

<ul>
<li>주어진 격자를 통해 만들 수 있는 사이클들은 다음 그림과 같습니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/076dbe07-2b33-414e-b6db-1e73ae2055f3/ex3.png" title="" alt="ex3.png"></p>

<ul>
<li>2개의 사이클의 길이가 모두 4이므로, <code>[4,4]</code>를 return 해야 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges