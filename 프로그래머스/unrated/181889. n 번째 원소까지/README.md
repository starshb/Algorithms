# [unrated] n 번째 원소까지 - 181889 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181889) 

### 성능 요약

메모리: 88.9 MB, 시간: 0.01 ms

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

### 채점결과

Empty

### 문제 설명

<p>정수 리스트 <code>num_list</code>와 정수 <code>n</code>이 주어질 때, <code>num_list</code>의 첫 번째 원소부터 <code>n</code> 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>2 ≤ <code>num_list</code>의 길이 ≤ 30</li>
<li>1 ≤ <code>num_list</code>의 원소 ≤ 9</li>
<li>1 ≤ <code>n</code> ≤ <code>num_list</code>의 길이
___</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>num_list</th>
<th>n</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[2, 1, 6]</td>
<td>1</td>
<td>[2]</td>
</tr>
<tr>
<td>[5, 2, 1, 7, 5]</td>
<td>3</td>
<td>[5, 2, 1]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>[2, 1, 6]의 첫 번째 원소부터 첫 번째 원소까지의 모든 원소는 [2]입니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>[5, 2, 1, 7, 5]의 첫 번째 원소부터 세 번째 원소까지의 모든 원소는 [5, 2, 1]입니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges