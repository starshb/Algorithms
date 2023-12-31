# [level 3] 스타 수열 - 70130 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/70130) 

### 성능 요약

메모리: 72.4 MB, 시간: 0.14 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 1월 1일 1:9:31

### 문제 설명

<p>다음과 같은 것들을 정의합니다.</p>

<ul>
<li><p>어떤 수열 x의 <a href="https://en.wikipedia.org/wiki/Subsequence" target="_blank" rel="noopener">부분 수열(Subsequence)</a>이란, x의 몇몇 원소들을 제거하거나 그러지 않고 남은 원소들이 원래 순서를 유지하여 얻을 수 있는 새로운 수열을 말합니다.</p>

<ul>
<li>예를 들어, <code>[1,3]</code>은 <code>[1,2,3,4,5]</code>의 부분수열입니다. 원래 수열에서 2, 4, 5를 제거해서 얻을 수 있기 때문입니다.</li>
</ul></li>
<li><p>다음과 같은 조건을 모두 만족하는 수열 x를 <strong>스타 수열</strong>이라고 정의합니다.</p>

<ul>
<li>x의 길이가 2 이상의 짝수입니다. (빈 수열은 허용되지 않습니다.)</li>
<li>x의 길이를 2n이라 할 때, 다음과 같은 n개의 집합 <code>{x[0], x[1]}, {x[2], x[3]}, ..., {x[2n-2], x[2n-1]}</code> 의 교집합의 원소의 개수가 1 이상입니다.</li>
<li><code>x[0] != x[1], x[2] != x[3], ..., x[2n-2] != x[2n-1]</code> 입니다.</li>
<li>예를 들어, <code>[1,2,1,3,4,1,1,3]</code>은 스타 수열입니다. <code>{1,2}, {1,3}, {4,1}, {1,3}</code> 의 교집합은 <code>{1}</code> 이고, 각 집합 내의 숫자들이 서로 다르기 때문입니다.</li>
</ul></li>
</ul>

<p>1차원 정수 배열 a가 매개변수로 주어집니다. a의 모든 부분 수열 중에서 가장 길이가 긴 스타 수열의 길이를 return 하도록 solution 함수를 완성해주세요. 이때, a의 모든 부분 수열 중에서 스타 수열이 없다면, 0을 return 해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>a의 길이는 1 이상 500,000 이하입니다.

<ul>
<li>a의 모든 수는 0 이상 (a의 길이) 미만입니다.</li>
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
<td><code>[0]</code></td>
<td>0</td>
</tr>
<tr>
<td><code>[5,2,3,3,5,3]</code></td>
<td>4</td>
</tr>
<tr>
<td><code>[0,3,3,0,7,2,0,2,2,0]</code></td>
<td>8</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>a의 부분 수열 중에서 주어진 조건을 모두 만족하는 스타 수열이 없으므로, 0을 return 해야 합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li><code>[5,2,5,3]</code>, <code>[5,3,3,5]</code> 는 a의 부분 수열인 동시에 스타 수열입니다. a의 부분 수열 중 이보다 더 긴 스타 수열은 없으므로, 4를 return 해야 합니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li><code>[0,3,3,0,7,0,2,0]</code> 는 a의 부분 수열인 동시에 스타 수열입니다. a의 부분 수열 중 이보다 더 긴 스타 수열은 없으므로, 8을 return 해야 합니다.</li>
</ul>

<p>※ 공지 - 2020년 11월 27일 테스트케이스가 추가되었습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges