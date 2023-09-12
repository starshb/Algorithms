# [level 0] 숨어있는 숫자의 덧셈 (2) - 120864 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120864) 

### 성능 요약

메모리: 62.7 MB, 시간: 10.13 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

Empty

### 문제 설명

<p>문자열 <code>my_string</code>이 매개변수로 주어집니다. <code>my_string</code>은 소문자, 대문자, 자연수로만 구성되어있습니다. <code>my_string</code>안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>my_string</code>의 길이 ≤ 1,000</li>
<li>1 ≤ <code>my_string</code> 안의 자연수 ≤ 1000</li>
<li>연속된 수는 하나의 숫자로 간주합니다.</li>
<li>000123과 같이 0이 선행하는 경우는 없습니다.</li>
<li>문자열에 자연수가 없는 경우 0을 return 해주세요.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>my_string</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"aAb1B2cC34oOp"</td>
<td>37</td>
</tr>
<tr>
<td>"1a2b3c4d123Z"</td>
<td>133</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>"aAb1B2cC34oOp"안의 자연수는 1, 2, 34 입니다. 따라서 1 + 2 + 34 = 37 을 return합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>"1a2b3c4d123Z"안의 자연수는 1, 2, 3, 4, 123 입니다. 따라서 1 + 2 + 3 + 4 + 123 = 133 을 return합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges