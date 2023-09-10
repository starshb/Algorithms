# [level 0] 겹치는 선분의 길이 - 120876 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120876) 

### 성능 요약

메모리: 61.4 MB, 시간: 10.08 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

Empty

### 문제 설명

<p>선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 <code>lines</code>가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.</p>

<p><code>lines</code>가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e4122d8b-9ce2-49ce-a360-3d1284babd8a/line_2.png" title="" alt="line_2.png"></p>

<p>선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li><code>lines</code>의 길이 = 3</li>
<li><code>lines</code>의 원소의 길이 = 2</li>
<li>모든 선분은 길이가 1 이상입니다.</li>
<li><code>lines</code>의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.

<ul>
<li>-100 ≤ a &lt; b ≤ 100</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>lines</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[0, 1], [2, 5], [3, 9]]</td>
<td>2</td>
</tr>
<tr>
<td>[[-1, 1], [1, 3], [3, 9]]</td>
<td>0</td>
</tr>
<tr>
<td>[[0, 5], [3, 9], [1, 10]]</td>
<td>8</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>두 번째, 세 번째 선분 [2, 5], [3, 9]가 [3, 5] 구간에 겹쳐있으므로 2를 return 합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>겹친 선분이 없으므로 0을 return 합니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>첫 번째와 두 번째 선분이 [3, 5] 구간에서&nbsp;겹칩니다.</li>
<li>첫 번째와 세 번째 선분 [1, 5] 구간에서&nbsp;겹칩니다.</li>
<li>두 번째와 세 번째 선분 [3, 9] 구간에서&nbsp;겹칩니다.</li>
<li>따라서 [1, 9] 구간에 두 개 이상의 선분이 겹쳐있으므로, 8을 return 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges