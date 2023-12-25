# [level 3] 110 옮기기 - 77886 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/77886) 

### 성능 요약

메모리: 120 MB, 시간: 109.99 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 2일 1:21:15

### 문제 설명

<p>0과 1로 이루어진 어떤 문자열 x에 대해서, 당신은 다음과 같은 행동을 통해 x를 최대한 사전 순으로 앞에 오도록 만들고자 합니다.</p>

<ul>
<li>x에 있는 "110"을 뽑아서, 임의의 위치에 다시 삽입합니다.</li>
</ul>

<p>예를 들어, x = "11100" 일 때, 여기서 중앙에 있는 "110"을 뽑으면 x = "10" 이 됩니다. 뽑았던 "110"을 x의 맨 앞에 다시 삽입하면 x = "11010" 이 됩니다.</p>

<p>변형시킬 문자열 x가 여러 개 들어있는 문자열 배열 <code>s</code>가 주어졌을 때, 각 문자열에 대해서 위의 행동으로 변형해서 만들 수 있는 문자열 중 사전 순으로 가장 앞에 오는 문자열을 배열에 담아 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>s</code>의 길이 ≤ 1,000,000</li>
<li>1 ≤ <code>s</code>의 각 원소 길이 ≤ 1,000,000</li>
<li>1 ≤ <code>s</code>의 모든 원소의 길이의 합 ≤ 1,000,000</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>["1110","100111100","0111111010"]</code></td>
<td><code>["1101","100110110","0110110111"]</code></td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>다음 그림은 "1110"을 "1101"로 만드는 과정을 나타낸 것입니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/9a8fd58d-71cd-44e9-b9ad-f1f87e653975/110_ex1.png" title="" alt="110_ex1.png"></p>

<ul>
<li><p>"1101"보다 사전 순으로 더 앞에 오는 문자열을 만들 수 없으므로, 배열에 "1101"을 담아야 합니다.</p></li>
<li><p>다음 그림은 "100111100"을 "100110110"으로 만드는 과정을 나타낸 것입니다.</p></li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/a0c471b7-5bc0-4c0c-914b-f864919fed37/110_ex2.png" title="" alt="110_ex2.png"></p>

<ul>
<li>"100110110"보다 사전 순으로 더 앞에 오는 문자열을 만들 수 없으므로, 배열에 "100110110"을 담아야 합니다.</li>
<li><p>그림에 나온 방식 말고도 다른 방법으로 "100110110"을 만들 수 있습니다.</p></li>
<li><p>다음 그림은 "0111111010"을 "0110110111"로 만드는 과정을 나타낸 것입니다.</p></li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/52534d0b-8883-444e-aa5e-1ca7512a7b7b/110_ex3.png" title="" alt="110_ex3.png"></p>

<ul>
<li>"0110110111"보다 사전 순으로 더 앞에 오는 문자열을 만들 수 없으므로, 배열에 "0110110111"을 담아야 합니다.</li>
<li>그림에 나온 방식 말고도 다른 방법으로 "0110110111"을 만들 수 있습니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges