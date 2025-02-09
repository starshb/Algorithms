# [level 4] 안티 세포 - 86054 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86054) 

### 성능 요약

메모리: 209 MB, 시간: 414.01 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 02월 10일 00:00:34

### 문제 설명

<p>당신에게 자연수로 이루어진 길이가 <code>n</code>인 배열 <code>b</code>가 주어집니다. 초기에는 모든 수들이 "안티 세포" 안에 들어있습니다. 일반적인 세포는 분열을 하지만, 이 안티 세포는 반대로 여러 안티 세포가 모여 합성을 합니다. 당신은 다음과 같은 과정을 통해 인접한 두 안티 세포를 합치거나 또는 그대로 두려고 합니다.</p>

<ol>
<li><code>i=0</code>로 설정하고, 빈 배열 <code>c</code>를 하나 만듭니다. </li>
<li><code>i</code>가 <code>n</code>이라면 과정을 종료합니다.</li>
<li><code>b[i]</code>를 포함하는 안티 세포를 <code>X</code>, 그리고 <code>X</code> 바로 왼쪽에 있는 안티 세포를 Y라고 정의합니다. 만약 <strong><code>Y</code>가 존재하고 <code>X</code>의 모든 숫자의 합과 <code>Y</code>의 모든 숫자의 합이 같다면</strong>, 당신은 이 두 안티 세포를 합치거나 합치지 않는 행동 중에서 <strong>하나를 선택할 수 있습니다.</strong>

<ol>
<li>만약 <code>X</code>와 <code>Y</code>를 합친다면, 둘을 합치고, <strong><code>c</code>의 맨 뒤에 <code>i</code>를 추가한 뒤</strong> 다시 3번 과정으로 돌아갑니다.</li>
<li>만약 <code>X</code>와 <code>Y</code>를 합치지 않는다면(또는 <code>Y</code>가 존재하지 않는다면), <strong><code>i</code>를 1 증가시키고</strong> 2번 과정으로 돌아갑니다.</li>
</ol></li>
</ol>

<p>예를 들어, 다음은 <code>b = [1,1,1,1]</code>일 때 위와 같은 과정을 거치는 것을 나타낸 것입니다.</p>
<table class="table">
        <thead><tr>
<th>i</th>
<th>안티 세포</th>
<th>c</th>
<th>비고</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td><code>(1)(1)(1)(1)</code></td>
<td><code>[]</code></td>
<td>초기 상태입니다.</td>
</tr>
<tr>
<td>1</td>
<td><code>(1)(1)(1)(1)</code></td>
<td><code>[]</code></td>
<td><code>i=0</code> 일 때는 <code>Y</code>가 존재하지 않으므로 <code>i</code>를 1 증가시켰습니다.</td>
</tr>
<tr>
<td>1</td>
<td><code>(1,1)(1)(1)</code></td>
<td><code>[1]</code></td>
<td><code>b[1]</code>을 포함하는 안티 세포(<code>X</code>)와 그 왼쪽의 안티 세포(<code>Y</code>)를 합쳤습니다. 따라서 <code>c</code>에 <code>i=1</code>이 추가됩니다.</td>
</tr>
<tr>
<td>2</td>
<td><code>(1,1)(1)(1)</code></td>
<td><code>[1]</code></td>
<td><code>b[1]</code>을 포함하는 안티 세포(<code>X</code>) 왼쪽의 안티 세포 <code>Y</code>가 존재하지 않으므로 <code>i</code>를 1 증가시켰습니다.</td>
</tr>
<tr>
<td>3</td>
<td><code>(1,1)(1)(1)</code></td>
<td><code>[1]</code></td>
<td><code>X</code>의 모든 수의 합은 1이고, <code>Y</code>의 모든 수의 합은 2이므로, 둘은 합칠 수 없습니다. 따라서 <code>i</code>을 1 증가시켰습니다.</td>
</tr>
<tr>
<td>3</td>
<td><code>(1,1)(1,1)</code></td>
<td><code>[1,3]</code></td>
<td><code>b[3]</code>을 포함하는 안티 세포(<code>X</code>)와 그 왼쪽의 안티 세포(<code>Y</code>)를 합쳤습니다. 따라서 <code>c</code>에 <code>i=3</code>이 추가됩니다.</td>
</tr>
<tr>
<td>4</td>
<td><code>(1,1)(1,1)</code></td>
<td><code>[1,3]</code></td>
<td><code>b[3]</code>을 포함하는 안티 세포(<code>X</code>)와 그 왼쪽의 안티 세포(<code>Y</code>)를 합칠 수 있었지만 그러지 않았습니다. 따라서 <code>i</code>를 1 증가시켰습니다.</td>
</tr>
</tbody>
      </table>
<p>이 경우 <code>c = [1,3]</code>이 됩니다. 물론 이는 <code>c</code>를 만들 수 있는 하나의 경우일 뿐이며, 당신의 선택에 따라 <code>[]</code>, <code>[1]</code>, <code>[3]</code>, <code>[1,3]</code>, <code>[2]</code>, <code>[1,3,3]</code>으로 <code>c</code>배열을 다양하게 만들 수 있습니다. 당신이 어떤 선택을 하더라도 유한한 횟수 안에 <code>c</code> 배열을 만들 수 있음은 증명될 수 있습니다.</p>

<p>당신은 <code>b</code>가 주어졌을 때 만들 수 있는 서로 다른 배열 <code>c</code>의 개수가 몇 개인지 알고 싶습니다.</p>

<p>정수로 이루어진 배열 <code>a</code>와 <code>s</code>가 매개변수로 주어집니다. <code>a</code>는 여러 개의 <code>b</code> 배열을 순서대로 이어 붙인 배열이며, <code>s</code>는 각 <code>b</code> 배열의 길이가 순서대로 담긴 배열입니다. 각 <code>b</code> 배열에 대해 문제의 답을 10<sup>9</sup> + 7로 나눈 나머지를 구하여 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.</p>

<p>예를 들어, <code>a = [1,2,3,4,5,6,7,8,9]</code>, <code>s = [2,3,4]</code> 라면, 다음 3가지 <code>b</code> 배열에 대해서 답을 구해야 합니다.</p>

<ul>
<li><code>b = [1,2]</code> (<code>s[0] = 2</code> 이므로, <code>a</code>의 첫 2개 원소가 <code>b</code> 배열을 이룹니다.)</li>
<li><code>b = [3,4,5]</code> (<code>s[1] = 3</code> 이므로, <code>a</code>의 그다음 3개 원소가 <code>b</code> 배열을 이룹니다.)</li>
<li><code>b = [6,7,8,9]</code> (<code>s[2] = 4</code> 이므로, <code>a</code>의 그다음 4개 원소가 <code>b</code> 배열을 이룹니다.)</li>
</ul>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>a</code>의 길이 ≤ 200,000

<ul>
<li>1 ≤ <code>a</code>의 모든 수 ≤ 10<sup>9</sup></li>
</ul></li>
<li>1 ≤ <code>s</code>의 길이 ≤ <code>a</code>의 길이

<ul>
<li>1 ≤ <code>s</code>의 모든 수 ≤ <code>a</code>의 길이</li>
<li><code>s</code>의 모든 수의 합 = <code>a</code>의 길이</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>a</th>
<th>s</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>[1,1,1,1,1,1,2,5,8,2,1,1,4,8,8,8,12,6,6]</code></td>
<td><code>[4,3,1,5,6]</code></td>
<td><code>[6,3,1,5,9]</code></td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>다음 5개의 <code>b</code> 배열에 대한 답을 구해야 합니다.</li>
</ul>
<table class="table">
        <thead><tr>
<th><code>b</code></th>
<th>답</th>
</tr>
</thead>
        <tbody><tr>
<td><code>[1,1,1,1]</code></td>
<td>6</td>
</tr>
<tr>
<td><code>[1,1,2]</code></td>
<td>3</td>
</tr>
<tr>
<td><code>[5]</code></td>
<td>1</td>
</tr>
<tr>
<td><code>[8,2,1,1,4]</code></td>
<td>5</td>
</tr>
<tr>
<td><code>[8,8,8,12,6,6]</code></td>
<td>9</td>
</tr>
</tbody>
      </table>
<ul>
<li>따라서, <code>[6,3,1,5,9]</code>를 return 해야 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges