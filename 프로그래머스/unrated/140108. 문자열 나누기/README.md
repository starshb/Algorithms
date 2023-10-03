# [unrated] 문자열 나누기 - 140108 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/140108) 

### 성능 요약

메모리: 74.5 MB, 시간: 0.67 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p>문자열 <code>s</code>가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.</p>

<ul>
<li>먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.</li>
<li>이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.</li>
<li><code>s</code>에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.</li>
<li>만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.</li>
</ul>

<p>문자열 <code>s</code>가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>s</code>의 길이 ≤ 10,000</li>
<li><code>s</code>는 영어 소문자로만 이루어져 있습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"banana"</td>
<td>3</td>
</tr>
<tr>
<td>"abracadabra"</td>
<td>6</td>
</tr>
<tr>
<td>"aaabbaccccabba"</td>
<td>3</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
<code>s</code>="banana"인 경우 ba - na - na와 같이 분해됩니다.</p>

<p>입출력 예 #2<br>
<code>s</code>="abracadabra"인 경우 ab - ra - ca - da - br - a와 같이 분해됩니다.</p>

<p>입출력 예 #3<br>
<code>s</code>="aaabbaccccabba"인 경우 aaabbacc - ccab - ba와 같이 분해됩니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges