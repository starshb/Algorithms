# [level 0] 삼각형의 완성조건 (2) - 120868 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120868) 

### 성능 요약

메모리: 62.1 MB, 시간: 0.02 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

Empty

### 문제 설명

<p>선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.</p>

<ul>
<li>가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.</li>
</ul>

<p>삼각형의 두 변의 길이가 담긴 배열 <code>sides</code>이 매개변수로 주어집니다. 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li><code>sides</code>의 원소는 자연수입니다.</li>
<li><code>sides</code>의 길이는 2입니다.</li>
<li>1 ≤ <code>sides</code>의 원소 ≤ 1,000</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>sides</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[1, 2]</td>
<td>1</td>
</tr>
<tr>
<td>[3, 6]</td>
<td>5</td>
</tr>
<tr>
<td>[11, 7]</td>
<td>13</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>두 변이 1, 2 인 경우 삼각형을 완성시키려면 나머지 한 변이 2여야 합니다. 따라서 1을 return합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>가장 긴 변이 6인 경우

<ul>
<li>될 수 있는 나머지 한 변은 4, 5, 6 로 3개입니다.</li>
</ul></li>
<li>나머지 한 변이 가장 긴 변인 경우

<ul>
<li>될 수 있는 한 변은 7, 8 로 2개입니다.</li>
</ul></li>
<li>따라서 3 + 2 = 5를 return합니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>가장 긴 변이 11인 경우

<ul>
<li>될 수 있는 나머지 한 변은 5, 6, 7, 8, 9, 10, 11 로 7개입니다.</li>
</ul></li>
<li>나머지 한 변이 가장 긴 변인 경우

<ul>
<li>될 수 있는 한 변은 12, 13, 14, 15, 16, 17 로 6개입니다.</li>
</ul></li>
<li>따라서 7 + 6 = 13을 return합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges