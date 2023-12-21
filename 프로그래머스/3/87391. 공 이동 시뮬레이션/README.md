# [level 3] 공 이동 시뮬레이션 - 87391 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87391) 

### 성능 요약

메모리: 115 MB, 시간: 0.16 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 5일 6:38:12

### 문제 설명

<p><code>n</code>행 <code>m</code>열의 격자가 있습니다. 격자의 각 행은 0, 1, ..., <code>n-1</code>번의 번호, 그리고 각 열은 0, 1, ..., <code>m-1</code>번의 번호가 순서대로 매겨져 있습니다. 당신은 이 격자에 공을 하나 두고, 그 공에 다음과 같은 쿼리들을 날리고자 합니다.</p>

<ul>
<li>열 번호가 감소하는 방향으로 <code>dx</code>칸 이동하는 쿼리 (<code>query(0, dx)</code>)</li>
<li>열 번호가 증가하는 방향으로 <code>dx</code>칸 이동하는 쿼리 (<code>query(1, dx)</code>)</li>
<li>행 번호가 감소하는 방향으로 <code>dx</code>칸 이동하는 쿼리 (<code>query(2, dx)</code>)</li>
<li>행 번호가 증가하는 방향으로 <code>dx</code>칸 이동하는 쿼리 (<code>query(3, dx)</code>)</li>
</ul>

<p>단, 공은 격자 바깥으로 이동할 수 없으며, 목적지가 격자 바깥인 경우 공은 이동하다가 더 이상 이동할 수 없을 때 멈추게 됩니다. 예를 들어, 5행 × 4열 크기의 격자 내의 공이 3행 2열에 있을 때 <code>query(3, 10)</code> 쿼리를 받은 경우 공은 4행 2열에서 멈추게 됩니다. (격자의 크기가 5행 × 4열이므로, 0~4번 행과 0~3번 열로 격자가 구성되기 때문입니다.)</p>

<p>격자의 행의 개수 <code>n</code>, 열의 개수 <code>m</code>, 정수 <code>x</code>와 <code>y</code>, 그리고 쿼리들의 목록을 나타내는 2차원 정수 배열 <code>queries</code>가 매개변수로 주어집니다. <code>n × m</code>개의 가능한 시작점에 대해서 해당 시작점에 공을 두고 <code>queries</code> 내의 쿼리들을 순서대로 시뮬레이션했을 때, <code>x</code>행 <code>y</code>열에 도착하는 시작점의 개수를 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>n</code> ≤ 10<sup>9</sup></li>
<li>1 ≤ <code>m</code> ≤ 10<sup>9</sup></li>
<li>0 ≤ <code>x</code> &lt; n</li>
<li>0 ≤ <code>y</code> &lt; m</li>
<li>1 ≤ <code>queries</code>의 행의 개수 ≤ 200,000

<ul>
<li><code>queries</code>의 각 행은 <code>[command,dx]</code> 두 정수로 이루어져 있습니다.</li>
<li>0 ≤ <code>command</code> ≤ 3</li>
<li>1 ≤ <code>dx</code> ≤ 10<sup>9</sup></li>
<li>이는 <code>query(command, dx)</code>를 의미합니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>m</th>
<th>x</th>
<th>y</th>
<th>queries</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>2</td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>[[2,1],[0,1],[1,1],[0,1],[2,1]]</td>
<td>4</td>
</tr>
<tr>
<td>2</td>
<td>5</td>
<td>0</td>
<td>1</td>
<td>[[3,1],[2,2],[1,1],[2,3],[0,1],[2,1]]</td>
<td>2</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>다음 애니메이션은 4개의 가능한 시작점에 대한 모든 시뮬레이션을 나타낸 것입니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.amazonaws.com/production/file_resource/101/Ball_ex1.gif" title="" alt="ex1"></p>

<ul>
<li>어떤 곳에서 출발하더라도 항상 0행 0열에 도착하기 때문에, 4를 return 해야 합니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>다음 애니메이션은 10개의 가능한 시작점에 대한 모든 시뮬레이션을 나타낸 것입니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.amazonaws.com/production/file_resource/107/Ball_ex2_faster.gif" title="" alt="ex2"></p>

<ul>
<li>0행 1열, 1행 1열에서 출발했을 때만 0행 1열에 도착하므로, 2를 return 해야 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges