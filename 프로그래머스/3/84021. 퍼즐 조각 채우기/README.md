# [level 3] 퍼즐 조각 채우기 - 84021 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84021) 

### 성능 요약

메모리: 73.2 MB, 시간: 0.48 ms

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 0일 8:27:31

### 문제 설명

<p>테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈 공간에 적절히 올려놓으려 합니다. 게임 보드와 테이블은 모두 각 칸이 1x1 크기인 정사각 격자 모양입니다. 이때, 다음 규칙에 따라 테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈칸에 채우면 됩니다.</p>

<ul>
<li>조각은 한 번에 하나씩 채워 넣습니다.</li>
<li>조각을 회전시킬 수 있습니다.</li>
<li>조각을 뒤집을 수는 없습니다.</li>
<li>게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.</li>
</ul>

<p>다음은 퍼즐 조각을 채우는 예시입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/ab4d8aa2-f282-4764-bb46-84d405464b90/puzzle_5.png" title="" alt="puzzle_5.png"></p>

<p>위 그림에서 왼쪽은 현재 게임 보드의 상태를, 오른쪽은 테이블 위에 놓인 퍼즐 조각들을 나타냅니다. 테이블 위에 놓인 퍼즐 조각들 또한 마찬가지로 [상,하,좌,우]로 인접해 붙어있는 경우는 없으며, 흰 칸은 퍼즐이 놓이지 않은 빈 공간을 나타냅니다. 모든 퍼즐 조각은 격자 칸에 딱 맞게 놓여있으며, 격자 칸을 벗어나거나, 걸쳐 있는 등 잘못 놓인 경우는 없습니다.</p>

<p>이때, 아래 그림과 같이 3,4,5번 조각을 격자 칸에 놓으면 규칙에 어긋나므로 불가능한 경우입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/70e371ad-4306-412b-b53b-25208e52a513/puzzle_6.png" title="" alt="puzzle_6.png"></p>

<ul>
<li>3번 조각을 놓고 4번 조각을 놓기 전에 위쪽으로 인접한 칸에 빈칸이 생깁니다.</li>
<li>5번 조각의 양 옆으로 인접한 칸에 빈칸이 생깁니다.</li>
</ul>

<p>다음은 규칙에 맞게 최대한 많은 조각을 게임 보드에 채워 넣은 모습입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/dadd0bc1-8e38-4689-a480-26afa799a5a3/puzzle_7.png" title="" alt="puzzle_7.png"></p>

<p>최대한 많은 조각을 채워 넣으면 총 14칸을 채울 수 있습니다.</p>

<p>현재 게임 보드의 상태 <code>game_board</code>, 테이블 위에 놓인 퍼즐 조각의 상태 <code>table</code>이 매개변수로 주어집니다. 규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>3 ≤ <code>game_board</code>의 행 길이 ≤ 50</li>
<li><code>game_board</code>의 각 열 길이 = <code>game_board</code>의 행 길이

<ul>
<li>즉, 게임 보드는 정사각 격자 모양입니다.</li>
<li><code>game_board</code>의 모든 원소는 0 또는 1입니다.</li>
<li>0은 빈칸, 1은 이미 채워진 칸을 나타냅니다.</li>
<li>퍼즐 조각이 놓일 빈칸은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.</li>
</ul></li>
<li><code>table</code>의 행 길이 = <code>game_board</code>의 행 길이</li>
<li><code>table</code>의 각 열 길이 = <code>table</code>의 행 길이

<ul>
<li>즉, 테이블은 <code>game_board</code>와 같은 크기의 정사각 격자 모양입니다.</li>
<li><code>table</code>의 모든 원소는 0 또는 1입니다.</li>
<li>0은 빈칸, 1은 조각이 놓인 칸을 나타냅니다.</li>
<li>퍼즐 조각은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.</li>
</ul></li>
<li><code>game_board</code>에는 반드시 하나 이상의 빈칸이 있습니다.</li>
<li><code>table</code>에는 반드시 하나 이상의 블록이 놓여 있습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>game_board</th>
<th>table</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]</td>
<td>[[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]</td>
<td>14</td>
</tr>
<tr>
<td>[[0,0,0],[1,1,0],[1,1,1]]</td>
<td>[[1,1,1],[1,0,0],[0,0,0]]</td>
<td>0</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>입력은 다음과 같은 형태이며, 문제의 예시와 같습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/653b44d8-0fa6-42f8-aa9d-ceca639b0ad4/puzzle_9.png" title="" alt="puzzle_9.png"></p>

<p><strong>입출력 예 #2</strong></p>

<p>블록의 회전은 가능하지만, 뒤집을 수는 없습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges