# [level 2] 줄 서는 방법 - 12936 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12936) 

### 성능 요약

메모리: 55.4 MB, 시간: 0.05 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 73.7<br/>효율성: 26.3<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 11월 6일 1:53:42

### 문제 설명

<p>n명의 사람이 일렬로 줄을 서고 있습니다.  n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다. n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.</p>

<ul>
<li>[1, 2, 3]</li>
<li>[1, 3, 2]</li>
<li>[2, 1, 3]</li>
<li>[2, 3, 1]</li>
<li>[3, 1, 2]</li>
<li>[3, 2, 1]</li>
</ul>

<p>사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return하는 solution 함수를 완성해주세요.</p>

<h6>제한사항</h6>

<ul>
<li>n은 20이하의 자연수 입니다.</li>
<li>k는 n! 이하의 자연수 입니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>k</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>3</td>
<td>5</td>
<td>[3,1,2]</td>
</tr>
</tbody>
      </table>
<h5>입출력 예시 설명</h5>

<p>입출력 예 #1<br>
문제의 예시와 같습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges