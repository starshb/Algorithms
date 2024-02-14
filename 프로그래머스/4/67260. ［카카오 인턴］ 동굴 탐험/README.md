# [level 4] [카카오 인턴] 동굴 탐험 - 67260 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/67260) 

### 성능 요약

메모리: 160 MB, 시간: 178.72 ms

### 구분

코딩테스트 연습 > 2020 카카오 인턴십

### 채점결과

정확성: 50.0<br/>효율성: 50.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 2월 3일 12:42:50

### 문제 설명

<p><strong>[본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/f21e69f3-58ea-4579-b1ba-636a07dfc38e/kakao_cave1.png" title="" alt="kakao_cave1.png"></p>

<p>오지 탐험가인 <code>프로도</code>는 탐험 도중 n개의 방으로 이루어진 지하 동굴을 탐험하게 되었습니다. 모든 방에는 0부터 n - 1 까지 번호가 붙어있고, 이 동굴에 들어갈 수 있는 유일한 입구는 0번 방과 연결되어 있습니다. 각 방들은 양방향으로 통행이 가능한 통로로 서로 연결되어 있는데, 서로 다른 두 방을 직접 연결하는 통로는 오직 하나입니다. 임의의 서로 다른 두 방 사이의 최단경로는 딱 한 가지만 있으며, 또한 임의의 두 방 사이에 이동이 불가능한 경우는 없습니다.</p>

<p>탐험에 앞서 이 지하 동굴의 지도를 손에 넣은 프로도는 다음과 같이 탐험 계획을 세웠습니다.</p>

<ol>
<li>모든 방을 적어도 한 번은 방문해야 합니다.</li>
<li>특정 방은 방문하기 전에 반드시 먼저 방문할 방이 정해져 있습니다.<br>
2-1. 이는 A번 방은 방문하기 전에 반드시 B번 방을 먼저 방문해야 한다는 의미입니다.<br>
2-2. 어떤 방을 방문하기 위해 반드시 먼저 방문해야 하는 방은 없거나 또는 1개 입니다.<br>
2-3. 서로 다른 두 개 이상의 방에 대해 먼저 방문해야 하는 방이 같은 경우는 없습니다.<br>
2-4. 어떤 방이 먼저 방문해야 하는 방이면서 동시에 나중에 방문해야 되는 방인 경우는 없습니다.<br></li>
</ol>

<p>위 계획 중 2-2, 2-3, 2-4는 순서를 지켜 방문해야 하는 두 방의 쌍이 <code>A → B</code>(A를 먼저 방문하고 B를 방문함) 형태로 유일함을 의미합니다. 즉, 프로도는 아래와 같은 형태로 방문순서가 잡히지 않도록 방문 계획을 세웠습니다.</p>

<ul>
<li><code>A → B, A → C</code> (방문순서 배열 order = [...,[A,B],...,[A,C],...]) 형태로 A를 방문 후에 방문해야 할 방이 B와 C로 두 개 또는 그 이상인 경우</li>
<li><code>X → A, Z → A</code> (방문순서 배열 order = [...,[X,A],...,[Z,A],...]) 형태로 A를 방문하기 전에 방문해야 할 방이 X와 Z로 두 개 또는 그 이상인 경우</li>
<li><code>A → B → C</code> (방문순서 배열 order = [...,[A,B],...,[B,C],...) 형태로 B처럼 A 방문 후이면서 동시에 C 방문 전인 경우<br></li>
</ul>

<p>그리고 먼저 방문해야 할 방과 나중에 방문할 방을 반드시 연속해서 방문해야 할 필요는 없어 A방을 방문한 후 다른 방을 방문한 후 B방을 방문해도 좋습니다.</p>

<p>방 개수 n, 동굴의 각 통로들이 연결하는 두 방의 번호가 담긴 2차원 배열 path, 프로도가 정한 방문 순서가 담긴 2차원 배열 order가 매개변수로 주어질 때, 프로도가 규칙에 맞게 모든 방을 탐험할 수 있을 지 return 하도록 solution 함수를 완성해주세요.</p>

<h5><strong>[제한사항]</strong></h5>

<ul>
<li>n은 2 이상 200,000 이하입니다.</li>
<li>path 배열의 세로(행) 길이는 n - 1 입니다.

<ul>
<li>path 배열의 원소는 [방 번호 A, 방 번호 B] 형태입니다.</li>
<li>두 방 A, B사이를 연결하는 통로를 나타냅니다.</li>
<li>통로가 연결하는 두 방 번호가 순서없이 들어있음에 주의하세요.</li>
</ul></li>
<li>order 배열의 세로(행) 길이는 1 이상 (n / 2) 이하입니다.

<ul>
<li>order 배열의 원소는 [방 번호 A, 방 번호 B] 형태입니다.</li>
<li>A번 방을 먼저 방문한 후 B번 방을 방문해야 함을 나타냅니다.</li>
</ul></li>
</ul>

<hr>

<h5><strong>입출력 예</strong></h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>path</th>
<th>order</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>9</td>
<td>[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]</td>
<td>[[8,5],[6,7],[4,1]]</td>
<td>true</td>
</tr>
<tr>
<td>9</td>
<td>[[8,1],[0,1],[1,2],[0,7],[4,7],[0,3],[7,5],[3,6]]</td>
<td>[[4,1],[5,2]]</td>
<td>true</td>
</tr>
<tr>
<td>9</td>
<td>[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]</td>
<td>[[4,1],[8,7],[6,5]]</td>
<td>false</td>
</tr>
</tbody>
      </table>
<h5><strong>입출력 예에 대한 설명</strong></h5>

<p><strong>입출력 예 #1</strong></p>

<p>동굴 그림은 아래와 같습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/22cc2bc5-f4b4-41d9-b470-a5545e9941f3/kakao_cave2.png" title="" alt="kakao_cave2.png"></p>

<p>방문 순서를 지켜야 하는 방 번호는 다음과 같습니다.</p>

<ul>
<li>6번 → 7번</li>
<li>4번 → 1번</li>
<li>8번 → 5번</li>
</ul>

<p>따라서 모든 방을 방문할 수 있는 방법 중 하나는 다음과 같습니다.</p>

<ul>
<li>0번 → 3번 → 6번 → 3번 → 0번 → 7번 → 4번 → 7번 → 0번 → 1번 → 8번 → 1번 → 2번 → 1번 → 0번 → 7번 → 5번</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/9ca7fc3c-b85e-4156-b24a-292fcc95e9ef/kakao_cave3.png" title="" alt="kakao_cave3.png"></p>

<p>다음 순서로 각 방을 방문하면 됩니다.</p>

<ul>
<li>0번 → 7번 → 4번 → 7번 → 5번 → 7번 → 0번 → 3번 → 6번 → 3번 → 0번 → 1번 → 8번 → 1번 → 2번</li>
</ul>

<p><strong>입출력 예 #3</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/f3b22a5a-3f5a-4159-b28b-3db6b4085b30/kakao_cave4.png" title="" alt="kakao_cave4.png"></p>

<p>규칙에 맞게 모든 방을 방문할 수 있는 방법이 없습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges