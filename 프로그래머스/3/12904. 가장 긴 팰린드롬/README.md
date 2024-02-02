# [level 3] 가장 긴 팰린드롬 - 12904 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12904) 

### 성능 요약

메모리: 51.7 MB, 시간: 0.06 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 72.1<br/>효율성: 27.9<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 2월 6일 5:52:13

### 문제 설명

<p>앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.<br>
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.</p>

<p>예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.</p>

<h5>제한사항</h5>

<ul>
<li>문자열 s의 길이 : 2,500 이하의 자연수</li>
<li>문자열 s는 알파벳 소문자로만 구성</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th>answer</th>
</tr>
</thead>
        <tbody><tr>
<td>"abcdcba"</td>
<td>7</td>
</tr>
<tr>
<td>"abacde"</td>
<td>3</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return합니다.</p>

<p>입출력 예 #2<br>
2번째자리 'b'를 기준으로 "aba"가 팰린드롬이 되므로 3을 return합니다.</p>

<hr>

<p>※ 공지 - 2023년 8월 21일 테스트케이스가 추가되었습니다. 기존에 제출한 코드가 통과하지 못할 수도 있습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges