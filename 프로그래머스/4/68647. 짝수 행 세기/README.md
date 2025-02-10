# [level 4] 짝수 행 세기 - 68647 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/68647) 

### 성능 요약

메모리: 97.7 MB, 시간: 94.32 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 02월 11일 00:34:42

### 문제 설명

<p>모든 수가 0 또는 1로 이루어진 2차원 배열 a가 주어집니다. 다음 조건을 모두 만족하는 2차원 배열 b의 경우의 수를 (10<sup>7</sup> + 19)로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.</p>

<ul>
<li>b의 모든 원소는 0 아니면 1입니다.</li>
<li>a의 행/열의 개수와 b의 행/열의 개수가 같습니다. (= a와 b의 크기가 같습니다.)</li>
<li><code>i = 1, 2, ..., (a의 열의 개수)</code>에 대해서 a의 i번째 열과 b의 i번째 열에 들어 있는 1의 개수가 같습니다.</li>
<li>b의 각 행에 들어 있는 1의 개수가 짝수입니다. (0도 짝수입니다.)</li>
</ul>

<hr>

<h5>제한 사항</h5>

<ul>
<li>a의 행의 개수는 1 이상 300 이하입니다.

<ul>
<li>a의 각 행의 길이는 1 이상 300 이하로 모두 동일합니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>a</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>[[0,1,0],[1,1,1],[1,1,0],[0,1,1]]</code></td>
<td>6</td>
</tr>
<tr>
<td><code>[[1,0,0],[1,0,0]]</code></td>
<td>0</td>
</tr>
<tr>
<td><code>[[1,0,0,1,1],[0,0,0,0,0],[1,1,0,0,0],[0,0,0,0,1]]</code></td>
<td>72</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>주어진 a는 다음 표와 같은 4행 3열의 배열입니다.</li>
</ul>
<table class="table">
        <thead><tr>
<th>a</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>0</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>2행</td>
<td>1</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>3행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>4행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
</tbody>
      </table>
<ul>
<li>주어진 조건을 만족하는 2차원 배열 b는 다음과 같이 총 6개입니다.</li>
</ul>
<table class="table">
        <thead><tr>
<th>b</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>2행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>3행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>4행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>b</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>2행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>3행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>4행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>b</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>2행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>3행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>4행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>b</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>2행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>3행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>4행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>b</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>2행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>3행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>4행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>b</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>2행</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>3행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>4행</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
</tbody>
      </table>
<p>입출력 예 #2</p>

<ul>
<li>주어진 a는 다음 표와 같은 2행 3열의 배열입니다.</li>
</ul>
<table class="table">
        <thead><tr>
<th>a</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>1</td>
<td>0</td>
<td>0</td>
</tr>
<tr>
<td>2행</td>
<td>1</td>
<td>0</td>
<td>0</td>
</tr>
</tbody>
      </table>
<ul>
<li>주어진 조건을 만족하는 2차원 배열 b가 없으므로, 0을 return 해야 합니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>주어진 a는 다음 표와 같은 4행 5열의 배열입니다.</li>
</ul>
<table class="table">
        <thead><tr>
<th>a</th>
<th>1열</th>
<th>2열</th>
<th>3열</th>
<th>4열</th>
<th>5열</th>
</tr>
</thead>
        <tbody><tr>
<td>1행</td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>2행</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>0</td>
</tr>
<tr>
<td>3행</td>
<td>1</td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
</tr>
<tr>
<td>4행</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>1</td>
</tr>
</tbody>
      </table>
<ul>
<li>주어진 조건을 만족하는 2차원 배열 b는 72개이므로, 72를 return 해야 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges