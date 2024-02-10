# [level 2] [PCCP 기출문제] 3번 / 아날로그 시계 - 250135 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250135) 

### 성능 요약

메모리: 94.2 MB, 시간: 30.01 ms

### 구분

코딩테스트 연습 > PCCP 기출문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 2월 6일 9:37:15

### 문제 설명

<p>시침, 분침, 초침이 있는 아날로그시계가 있습니다. 시계의 시침은 12시간마다, 분침은 60분마다, 초침은 60초마다 시계를 한 바퀴 돕니다. 따라서 시침, 분침, 초침이 움직이는 속도는 일정하며 각각 다릅니다. 이 시계에는 초침이 시침/분침과 겹칠 때마다 알람이 울리는 기능이 있습니다. 당신은 특정 시간 동안 알람이 울린 횟수를 알고 싶습니다.</p>

<p>다음은 0시 5분 30초부터 0시 7분 0초까지 알람이 울린 횟수를 세는 예시입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/fee10e9e-2871-4caf-94e4-b55b2dbcaea9/ex1-1.png" title="" alt="ex1-1.png"></p>

<ul>
<li>가장 짧은 바늘이 시침, 중간 길이인 바늘이 분침, 가장 긴 바늘이 초침입니다.</li>
<li>알람이 울리는 횟수를 세기 시작한 시각은 0시 5분 30초입니다.</li>
<li>이후 0시 6분 0초까지 초침과 시침/분침이 겹치는 일은 없습니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/61dd5cec-944e-4f48-a3ae-95fd498e197e/ex1-2.png" title="" alt="ex1-2.png"></p>

<ul>
<li>약 0시 6분 0.501초에 초침과 시침이 겹칩니다. 이때 알람이 한 번 울립니다.</li>
<li>이후 0시 6분 6초까지 초침과 시침/분침이 겹치는 일은 없습니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/d2274db1-cb08-45d0-a6d4-ac6d76705f67/ex1-3.png" title="" alt="ex1-3.png"></p>

<ul>
<li>약 0시 6분 6.102초에 초침과 분침이 겹칩니다. 이때 알람이 한 번 울립니다.</li>
<li>이후 0시 7분 0초까지 초침과 시침/분침이 겹치는 일은 없습니다.</li>
</ul>

<p>0시 5분 30초부터 0시 7분 0초까지는 알람이 두 번 울립니다. 이후 약 0시 7분 0.584초에 초침과 시침이 겹쳐서 울리는 세 번째 알람은 횟수에 포함되지 않습니다.</p>

<p>다음은 12시 0분 0초부터 12시 0분 30초까지 알람이 울린 횟수를 세는 예시입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/3b0781d9-0640-428e-bd9d-4d8c70a3c578/ex2-1.png" title="" alt="ex2-1.png"></p>

<ul>
<li>알람이 울리는 횟수를 세기 시작한 시각은 12시 0분 0초입니다.</li>
<li>초침과 시침, 분침이 겹칩니다. 이때 알람이 한 번 울립니다. 이와 같이 0시 정각, 12시 정각에 초침과 시침, 분침이 모두 겹칠 때는 알람이 한 번만 울립니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/9f178f43-9819-4b7a-8ed1-783cec0febe3/ex2-2.png" title="" alt="ex2-2.png"></p>

<ul>
<li>이후 12시 0분 30초까지 초침과 시침/분침이 겹치는 일은 없습니다.</li>
</ul>

<p>12시 0분 0초부터 12시 0분 30초까지는 알람이 한 번 울립니다.</p>

<p>알람이 울리는 횟수를 센 시간을 나타내는 정수 <code>h1</code>, <code>m1</code>, <code>s1</code>, <code>h2</code>, <code>m2</code>, <code>s2</code>가 매개변수로 주어집니다. 이때, 알람이 울리는 횟수를 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>0 ≤ <code>h1</code>, <code>h2</code> ≤ 23</li>
<li>0 ≤ <code>m1</code>, <code>m2</code> ≤ 59</li>
<li>0 ≤ <code>s1</code>, <code>s2</code> ≤ 59</li>
<li><code>h1시 m1분 s1초</code>부터 <code>h2시 m2분 s2초</code>까지 알람이 울리는 횟수를 센다는 의미입니다.

<ul>
<li><code>h1시 m1분 s1초</code> &lt; <code>h2시 m2분 s2초</code></li>
<li>시간이 23시 59분 59초를 초과해서 0시 0분 0초로 돌아가는 경우는 주어지지 않습니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>h1</th>
<th>m1</th>
<th>s1</th>
<th>h2</th>
<th>m2</th>
<th>s2</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>5</td>
<td>30</td>
<td>0</td>
<td>7</td>
<td>0</td>
<td>2</td>
</tr>
<tr>
<td>12</td>
<td>0</td>
<td>0</td>
<td>12</td>
<td>0</td>
<td>30</td>
<td>1</td>
</tr>
<tr>
<td>0</td>
<td>6</td>
<td>1</td>
<td>0</td>
<td>6</td>
<td>6</td>
<td>0</td>
</tr>
<tr>
<td>11</td>
<td>59</td>
<td>30</td>
<td>12</td>
<td>0</td>
<td>0</td>
<td>1</td>
</tr>
<tr>
<td>11</td>
<td>58</td>
<td>59</td>
<td>11</td>
<td>59</td>
<td>0</td>
<td>1</td>
</tr>
<tr>
<td>1</td>
<td>5</td>
<td>5</td>
<td>1</td>
<td>5</td>
<td>6</td>
<td>2</td>
</tr>
<tr>
<td>0</td>
<td>0</td>
<td>0</td>
<td>23</td>
<td>59</td>
<td>59</td>
<td>2852</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #3</strong></p>

<p>0시 6분 1초부터 0시 6분 6초까지 초침과 시침/분침이 겹치는 일은 없습니다. 따라서 알람이 울리지 않으며 0을 return 해야 합니다.</p>

<p><strong>입출력 예 #4</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/1b7bbaf3-652a-469a-ab36-3434b77920e3/ex3-1.png" title="" alt="ex3-1.png"></p>

<ul>
<li>11시 59분 30초부터 11시 59분 59초까지 초침과 시침/분침이 겹치는 일은 없습니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/3b0781d9-0640-428e-bd9d-4d8c70a3c578/ex2-1.png" title="" alt="ex2-1.png"></p>

<ul>
<li>12시 0분 0초에 초침과 시침, 분침이 겹칩니다. 이때 알람이 한 번 울립니다.</li>
</ul>

<p>11시 59분 30초부터 12시 0분 0초까지 초침과 시침/분침이 겹치는 횟수는 1이며 따라서 알람이 한 번 울립니다.</p>

<p><strong>입출력 예 #5</strong></p>

<ul>
<li>약 11시 58분 59.917초에 초침과 시침이 겹칩니다. 이때 알람이 한 번 울립니다.</li>
</ul>

<p>11시 58분 59초부터 11시 59분 0초까지 초침과 시침/분침이 겹치는 횟수는 1이며 따라서 알람이 한 번 울립니다.</p>

<p><strong>입출력 예 #6</strong></p>

<ul>
<li>약 1시 5분 5.085초에 초침과 분침이 겹칩니다. 이때 알람이 한 번 울립니다.</li>
<li>약 1시 5분 5.424초에 초침과 시침이 겹칩니다. 이때 알람이 한 번 울립니다.</li>
</ul>

<p>1시 5분 5초부터 1시 5분 6초까지 초침과 시침/분침이 겹치는 횟수는 2며 따라서 알람이 두 번 울립니다.</p>

<p><strong>입출력 예 #7</strong></p>

<p>0시 0분 0초부터 23시 59분 59초까지 초침과 시침/분침이 겹치는 횟수는 2852며 따라서 알람이 총 2852번 울립니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges