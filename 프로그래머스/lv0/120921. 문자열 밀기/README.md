# [level 0] 문자열 밀기 - 120921 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120921) 

### 성능 요약

메모리: 74.6 MB, 시간: 0.05 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

Empty

### 문제 설명

<p>문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다. 이것을 문자열을 민다고 정의한다면 문자열 <code>A</code>와 <code>B</code>가 매개변수로 주어질 때, <code>A</code>를 밀어서 <code>B</code>가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 <code>B</code>가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>0 &lt; <code>A</code>의 길이 = <code>B</code>의 길이 &lt; 100</li>
<li><code>A</code>, <code>B</code>는 알파벳 소문자로 이루어져 있습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>A</th>
<th>B</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"hello"</td>
<td>"ohell"</td>
<td>1</td>
</tr>
<tr>
<td>"apple"</td>
<td>"elppa"</td>
<td>-1</td>
</tr>
<tr>
<td>"atat"</td>
<td>"tata"</td>
<td>1</td>
</tr>
<tr>
<td>"abc"</td>
<td>"abc"</td>
<td>0</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>"hello"를 오른쪽으로 한 칸 밀면 "ohell"가 됩니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>"apple"은 몇 번을 밀어도 "elppa"가 될 수 없습니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>"atat"는 오른쪽으로 한 칸, 세 칸을 밀면 "tata"가 되므로 최소 횟수인 1을 반환합니다.</li>
</ul>

<p>입출력 예 #4</p>

<ul>
<li>"abc"는 밀지 않아도 "abc"이므로 0을 반환합니다.</li>
</ul>

<hr>

<p>※ 공지 - 2023년 4월 24일 테스트케이스가 추가되었습니다. 기존에 제출한 코드가 통과하지 못할 수도 있습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges