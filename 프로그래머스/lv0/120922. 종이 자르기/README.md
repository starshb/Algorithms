# [level 0] 종이 자르기 - 120922 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120922) 

### 성능 요약

메모리: 78.7 MB, 시간: 0.04 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

Empty

### 문제 설명

<p>머쓱이는 큰 종이를 1 x 1 크기로 자르려고 합니다. 예를 들어 2 x 2 크기의 종이를 1 x 1 크기로 자르려면 최소 가위질 세 번이 필요합니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/37cec804-18c5-4c58-95fc-37b4d52e6e7f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-07-25%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%204.49.44.png" title="" alt="스크린샷 2022-07-25 오후 4.49.44.png"></p>

<p>정수 <code>M</code>, <code>N</code>이 매개변수로 주어질 때, <code>M</code> x <code>N</code> 크기의 종이를 최소로 가위질 해야하는 횟수를 return 하도록 solution 함수를 완성해보세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>0 &lt; <code>M</code>, <code>N</code> &lt; 100</li>
<li>종이를 겹쳐서 자를 수 없습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>M</th>
<th>N</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>2</td>
<td>2</td>
<td>3</td>
</tr>
<tr>
<td>2</td>
<td>5</td>
<td>9</td>
</tr>
<tr>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>본문과 동일합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>가로 2 세로 5인 종이는 가로로 1번 세로로 8번 총 가위질 9번이 필요합니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>이미 1 * 1 크기이므로 0을 return 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges