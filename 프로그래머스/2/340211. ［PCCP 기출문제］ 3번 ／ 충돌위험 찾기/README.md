# [level 2] [PCCP 기출문제] 3번 / 충돌위험 찾기 - 340211 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/340211) 

### 성능 요약

메모리: 161 MB, 시간: 270.40 ms

### 구분

코딩테스트 연습 > PCCP 기출문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 02월 08일 20:25:55

### 문제 설명

<p>어떤 물류 센터는 로봇을 이용한 자동 운송 시스템을 운영합니다. 운송 시스템이 작동하는 규칙은 다음과 같습니다.</p>

<ol>
<li>물류 센터에는 (r, c)와 같이 2차원 좌표로 나타낼 수 있는 <code>n</code>개의 포인트가 존재합니다. 각 포인트는 1~<code>n</code>까지의 서로 다른 번호를 가집니다.</li>
<li>로봇마다 정해진 운송 경로가 존재합니다. 운송 경로는 <code>m</code>개의 포인트로 구성되고 로봇은 첫 포인트에서 시작해 할당된 포인트를 순서대로 방문합니다.</li>
<li>운송 시스템에 사용되는 로봇은 <code>x</code>대이고, 모든 로봇은 0초에 동시에 출발합니다. 로봇은 1초마다 r 좌표와 c 좌표 중 하나가 1만큼 감소하거나 증가한 좌표로 이동할 수 있습니다.</li>
<li>다음 포인트로 이동할 때는 항상 최단 경로로 이동하며 최단 경로가 여러 가지일 경우, r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.</li>
<li>마지막 포인트에 도착한 로봇은 운송을 마치고 물류 센터를 벗어납니다. 로봇이 물류 센터를 벗어나는 경로는 고려하지 않습니다.</li>
</ol>

<p><strong>이동 중 같은 좌표에 로봇이 2대 이상 모인다면 충돌할 가능성이 있는 위험 상황으로 판단합니다.</strong> 관리자인 당신은 현재 설정대로 로봇이 움직일 때 위험한 상황이 총 몇 번 일어나는지 알고 싶습니다. 만약 어떤 시간에 여러 좌표에서 위험 상황이 발생한다면 그 횟수를 모두 더합니다. </p>

<p>운송 포인트 <code>n</code>개의 좌표를 담은 2차원 정수 배열 <code>points</code>와 로봇 <code>x</code>대의 운송 경로를 담은 2차원 정수 배열 <code>routes</code>가 매개변수로 주어집니다. 이때 모든 로봇이 운송을 마칠 때까지 발생하는 위험한 상황의 횟수를 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>2 ≤ <code>points</code>의 길이 = <code>n</code> ≤ 100

<ul>
<li><code>points[i]</code>는 <code>i + 1</code>번 포인트의 [<code>r 좌표</code>, <code>c 좌표</code>]를 나타내는 길이가 2인 정수 배열입니다.</li>
<li>1 ≤ <code>r</code> ≤ 100</li>
<li>1 ≤ <code>c</code> ≤ 100</li>
<li>같은 좌표에 여러 포인트가 존재하는 입력은 주어지지 않습니다.</li>
</ul></li>
<li>2 ≤ <code>routes</code>의 길이 = 로봇의 수 = <code>x</code> ≤ 100

<ul>
<li>2 ≤ <code>routes[i]</code>의 길이 = <code>m</code> ≤ 100</li>
<li><code>routes[i]</code>는 <code>i + 1</code>번째 로봇의 운송경로를 나타냅니다. <code>routes[i]</code>의 길이는 모두 같습니다.</li>
<li><code>routes[i][j]</code>는 <code>i + 1</code>번째 로봇이 <code>j + 1</code>번째로 방문하는 포인트 번호를 나타냅니다.</li>
<li>같은 포인트를 연속으로 방문하는 입력은 주어지지 않습니다.</li>
<li>1 ≤ <code>routes[i][j]</code> ≤ <code>n</code></li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>points</th>
<th>routes</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[3, 2], [6, 4], [4, 7], [1, 4]]</td>
<td>[[4, 2], [1, 3], [2, 4]]</td>
<td>1</td>
</tr>
<tr>
<td>[[3, 2], [6, 4], [4, 7], [1, 4]]</td>
<td>[[4, 2], [1, 3], [4, 2], [4, 3]]</td>
<td>9</td>
</tr>
<tr>
<td>[[2, 2], [2, 3], [2, 7], [6, 6], [5, 2]]</td>
<td>[[2, 3, 4, 5], [1, 3, 4, 5]]</td>
<td>0</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/43dea513-36b0-493b-bb52-ac5d9dc49bf4/%E1%84%8E%E1%85%AE%E1%86%BC%E1%84%83%E1%85%A9%E1%86%AF%E1%84%8B%E1%85%B1%E1%84%92%E1%85%A5%E1%86%B71.gif" title="" alt="충돌위험1.gif"></p>

<p>그림처럼 로봇들이 움직입니다. 3초가 지났을 때 1번 로봇과 2번 로봇이 (4, 4)에서 충돌할 위험이 있습니다. 따라서 1을 return 해야 합니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b1b127d3-679b-4d54-ac3f-1e3131e7a6fa/%E1%84%8E%E1%85%AE%E1%86%BC%E1%84%83%E1%85%A9%E1%86%AF%E1%84%8B%E1%85%B1%E1%84%92%E1%85%A5%E1%86%B72.gif" title="" alt="충돌위험2.gif"></p>

<p>그림처럼 로봇들이 움직입니다. 1, 3, 4번 로봇의 경로가 같아 이동하는 0 ~ 2초 내내 충돌 위험이 존재합니다. 3초에는 1, 2, 3, 4번 로봇이 모두 (4, 4)를 지나지만 위험 상황은 한 번만 발생합니다. </p>

<p>4 ~ 5초에는 1, 3번과 2, 4번 로봇의 경로가 각각 같아 위험 상황이 매 초 2번씩 발생합니다. 6초에 2, 4번 로봇의 충돌 위험이 발생합니다. 따라서 9를 return 해야 합니다.</p>

<p><strong>입출력 예 #3</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/eb0fe259-fe92-44fc-bddb-c55afac4e12f/%E1%84%8E%E1%85%AE%E1%86%BC%E1%84%83%E1%85%A9%E1%86%AF%E1%84%8B%E1%85%B1%E1%84%92%E1%85%A5%E1%86%B73.gif" title="" alt="충돌위험3.gif"></p>

<p>그림처럼 로봇들이 움직입니다. 두 로봇의 경로는 같지만 한 칸 간격으로 움직이고 2번 로봇이 5번 포인트에 도착할 때 1번 로봇은 운송을 완료하고 센터를 벗어나 충돌 위험이 없습니다. 따라서 0을 return 해야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges