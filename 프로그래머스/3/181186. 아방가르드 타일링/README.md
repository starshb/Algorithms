# [level 3] 아방가르드 타일링 - 181186 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181186) 

### 성능 요약

메모리: 87.5 MB, 시간: 33.95 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 6일 23:57:14

### 문제 설명

<p>정우는 예술적 감각이 뛰어난 타일공입니다. 그는 단순한 타일을 활용하여 불규칙하면서도 화려하게 타일링을 하곤 합니다.</p>

<p>어느 날 정우는 가로 길이 <code>n</code>, 세로 길이 3 인 판을 타일링하는 의뢰를 맡았습니다. 아방가르드한 디자인 영감이 떠오른 정우는 다음과 같은 두 가지 종류의 타일로 타일링을 하기로 결정했습니다.<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b5b950b2-b995-418a-a40b-6e0ef6bb04d2/%EA%B7%B8%EB%A6%BC1.png" title="" alt="그림1.png"><br>
각 타일은 90도씩 회전할 수 있으며 타일의 개수는 제한이 없습니다.</p>

<p><code>n</code>이 주어졌을 때, 이 두 가지 종류의 타일로 <code>n</code> x 3 크기의 판을 타일링하는 방법의 수를 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한 사항</h5>

<ul>
<li>1 ≤ <code>n</code> ≤ 100,000</li>
<li>결과는 매우 클 수 있으므로 1,000,000,007 로 나눈 나머지를 return합니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>2</td>
<td>3</td>
</tr>
<tr>
<td>3</td>
<td>10</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/090901c7-5579-43e4-9614-ceb6024d4f8e/%EA%B7%B8%EB%A6%BC2.png" title="" alt="그림2.png"><br>
위 그림과 같이 3 가지 방법으로 타일링할 수 있습니다.</p>

<p>입출력 예 #2<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/adb2e512-60a7-4911-854b-068d63ca8f50/%EA%B7%B8%EB%A6%BC3.png" title="" alt="그림3.png"><br>
위 그림과 같이 10 가지 방법으로 타일링할 수 있습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges