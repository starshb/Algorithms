# [level 3] 억억단을 외우자 - 138475 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/138475) 

### 성능 요약

메모리: 305 MB, 시간: 5879.61 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 6일 0:1:47

### 문제 설명

<p>영우는 천하제일 암산대회를 앞두고 있습니다. 암산보다는 암기에 일가견이 있는 영우는 구구단을 확장하여 억억단을 만들고 외워버리기로 하였습니다.<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/cc875dfd-d9d5-4594-8c3c-06e7e1ba9e22/%EA%B7%B8%EB%A6%BC1.png" title="" alt="그림1.png"><br>
억억단은 1억 x 1억 크기의 행렬입니다. 억억단을 외우던 영우는 친구 수연에게 퀴즈를 내달라고 부탁하였습니다.<br>
수연은 평범하게 문제를 내봐야 영우가 너무 쉽게 맞히기 때문에 좀 어렵게 퀴즈를 내보려고 합니다. 적당한 수 <code>e</code>를 먼저 정하여 알려주고 <code>e</code> 이하의 임의의 수 <code>s</code>를 여러 개 얘기합니다. 영우는 각 <code>s</code>에 대해서 <code>s</code>보다 크거나 같고 <code>e</code> 보다 작거나 같은 수 중에서 억억단에서 가장 많이 등장한 수를 답해야 합니다. 만약 가장 많이 등장한 수가 여러 개라면 그 중 가장 작은 수를 답해야 합니다.<br>
수연은 영우가 정답을 말하는지 확인하기 위해 당신에게 프로그램 제작을 의뢰하였습니다. <code>e</code>와 <code>s</code>의 목록 <code>starts</code>가 매개변수로 주어질 때 각 퀴즈의 답 목록을 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>e</code> ≤ 5,000,000</li>
<li>1 ≤ <code>starts</code>의 길이 ≤ min {<code>e</code>,100,000}</li>
<li>1 ≤ <code>starts</code>의 원소 ≤ <code>e</code></li>
<li><code>starts</code>에는 중복되는 원소가 존재하지 않습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>e</th>
<th>starts</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>8</td>
<td>[1,3,7]</td>
<td>[6,6,8]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>억억단에서 1 ~ 8이 등장하는 횟수는 다음과 같습니다.</p>

<blockquote>
<p>1번 등장 : 1<br>
2번 등장 : 2, 3, 5, 7<br>
3번 등장 : 4<br>
4번 등장 : 6, 8</p>
</blockquote>

<p>[1, 8] 범위에서는 6과 8이 각각 4번씩 등장하여 가장 많은데 6이 더 작은 수이므로 6이 정답입니다.<br>
[3, 8] 범위에서도 위와 같으므로 6이 정답입니다.<br>
[7, 8] 범위에서는 7은 2번, 8은 4번 등장하므로 8이 정답입니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges