# [level 3] 에어컨 - 214289 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/214289) 

### 성능 요약

메모리: 78.8 MB, 시간: 6.23 ms

### 구분

코딩테스트 연습 > 2023 현대모비스 알고리즘 경진대회 예선

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 6일 0:38:12

### 문제 설명

<p>현대모비스에서 개발한 실내공조 제어 시스템은 차내에 승객이 탑승 중일 때 항상 쾌적한 실내온도(<code>t1</code> ~ <code>t2</code><sup id="fnref1"><a href="#fn1">1</a></sup>)를 유지할 수 있도록 합니다. 현재(0분) 실내온도는 실외온도와 같습니다.</p>

<p>실내공조 제어 시스템은 실내온도를 조절하기 위해 에어컨의 전원을 켜 희망온도를 설정합니다. 희망온도는 에어컨의 전원이 켜져 있는 동안 <strong>원하는 값으로</strong> 변경할 수 있습니다. 실내온도와 희망온도가 다르다면 1분 뒤 실내온도가 <strong>희망온도와 같아지는 방향으로</strong> 1도 상승 또는 하강합니다. 실내온도가 희망온도와 같다면 에어컨이 켜져 있는 동안은 실내온도가 변하지 않습니다. </p>

<p>에어컨의 전원을 끄면 실내온도가 <strong>실외온도와 같아지는 방향으로</strong> 매 분 1도 상승 또는 하강합니다. 실내온도와 실외온도가 같다면 실내온도는 변하지 않습니다.</p>

<p>에어컨의 소비전력은 현재 실내온도에 따라 달라집니다. 에어컨의 희망온도와 실내온도가 다르다면 매 분 전력을 <code>a</code>만큼 소비하고, 희망온도와 실내온도가 같다면 매 분 전력을 <code>b</code>만큼 소비합니다. 에어컨이 꺼져 있다면 전력을 소비하지 않으며, 에어컨을 켜고 끄는데 필요한 시간과 전력은 0이라고 가정합니다.</p>

<p>실내공조 제어 시스템은 차내에 승객이 탑승 중일 때 실내온도를 <code>t1</code> ~ <code>t2</code>도 사이로 유지하면서, 에어컨의 소비전력을 최소화합니다. </p>

<p>다음은 실외온도가 28도, <code>t1</code>= 18, <code>t2</code> = 26, <code>a</code> = 10 <code>b</code> = 8인 예시입니다.</p>
<table class="table">
        <thead><tr>
<th>시간(분)</th>
<th>승객 탑승</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>x</td>
</tr>
<tr>
<td>1</td>
<td>x</td>
</tr>
<tr>
<td>2</td>
<td>o</td>
</tr>
<tr>
<td>3</td>
<td>o</td>
</tr>
<tr>
<td>4</td>
<td>o</td>
</tr>
<tr>
<td>5</td>
<td>o</td>
</tr>
<tr>
<td>6</td>
<td>o</td>
</tr>
</tbody>
      </table>
<ul>
<li>승객이 탑승 중인 2 ~ 6분의 실내온도를 18 ~ 26도 사이로 유지해야 합니다.</li>
</ul>

<p>다음은 2 ~ 6분의 실내온도를 쾌적한 온도로 유지하는 방법 중 하나입니다.</p>
<table class="table">
        <thead><tr>
<th>시간(분)</th>
<th>승객 탑승</th>
<th>실내온도</th>
<th>희망온도</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>x</td>
<td>28</td>
<td>26</td>
</tr>
<tr>
<td>1</td>
<td>x</td>
<td>27</td>
<td>26</td>
</tr>
<tr>
<td>2</td>
<td>o</td>
<td>26</td>
<td>26</td>
</tr>
<tr>
<td>3</td>
<td>o</td>
<td>26</td>
<td>26</td>
</tr>
<tr>
<td>4</td>
<td>o</td>
<td>26</td>
<td>26</td>
</tr>
<tr>
<td>5</td>
<td>o</td>
<td>26</td>
<td>26</td>
</tr>
<tr>
<td>6</td>
<td>o</td>
<td>26</td>
<td>off</td>
</tr>
</tbody>
      </table>
<ul>
<li>0분의 실내온도는 항상 실외온도와 같습니다.</li>
<li>6분에 에어컨의 전원을 껐습니다.</li>
</ul>

<p>0 ~ 5분에 에어컨의 희망온도를 26도로 설정했습니다. 0 ~ 1분에 희망온도와 실내온도가 다르므로 전력을 매 분 10씩, 2 ~ 5분에 희망온도와 실내온도가 같으므로 전력을 매 분 8씩 소비했습니다. 이때 총 소비전력은 52(= 2 × 10 + 4 × 8)입니다.</p>

<p>다음은 2 ~ 6분의 실내온도를 쾌적한 온도로 유지하는 또 다른 방법입니다.</p>
<table class="table">
        <thead><tr>
<th>시간(분)</th>
<th>승객 탑승</th>
<th>실내온도</th>
<th>희망온도</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>x</td>
<td>28</td>
<td>24</td>
</tr>
<tr>
<td>1</td>
<td>x</td>
<td>27</td>
<td>24</td>
</tr>
<tr>
<td>2</td>
<td>o</td>
<td>26</td>
<td>24</td>
</tr>
<tr>
<td>3</td>
<td>o</td>
<td>25</td>
<td>24</td>
</tr>
<tr>
<td>4</td>
<td>o</td>
<td>24</td>
<td>off</td>
</tr>
<tr>
<td>5</td>
<td>o</td>
<td>25</td>
<td>off</td>
</tr>
<tr>
<td>6</td>
<td>o</td>
<td>26</td>
<td>off</td>
</tr>
</tbody>
      </table>
<p>0 ~ 3분에 에어컨의 희망온도를 24도로 설정해 전력을 매 분 10씩 소비했습니다. 이때 총 소비전력은 40(= 4 × 10)이며, 이보다 소비전력이 적어지는 방법은 없습니다.</p>

<p>실외온도를 나타내는 정수 <code>temperature</code>, 쾌적한 실내온도의 범위를 나타내는 정수 <code>t1</code>, <code>t2</code>, 에어컨의 소비전력을 나타내는 정수 <code>a</code>, <code>b</code>와 승객이 탑승 중인 시간을 나타내는 1차원 정수 배열 <code>onboard</code>가 매개변수로 주어집니다. 승객이 탑승 중인 시간에 쾌적한 실내온도를 유지하기 위한 최소 소비전력을 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>-10 ≤ <code>temperature</code> ≤ 40</li>
<li>-10 ≤ <code>t1</code> &lt; <code>t2</code> ≤ 40

<ul>
<li><code>temperature</code>는 <code>t1</code> ~ <code>t2</code> 범위 밖의 값입니다.</li>
</ul></li>
<li>1 ≤ <code>a</code>, <code>b</code> ≤ 100

<ul>
<li><code>a</code>는 에어컨의 희망온도와 실내온도가 다를 때의 1분당 소비전력을 나타냅니다.</li>
<li><code>b</code>는 에어컨의 희망온도와 실내온도가 같을 때의 1분당 소비전력을 나타냅니다.</li>
</ul></li>
<li>2 ≤ <code>onboard</code>의 길이 ≤ 1,000

<ul>
<li><code>onboard[i]</code>는 0 혹은 1이며, <code>onboard[i]</code>가 1이라면 <code>i</code>분에 승객이 탑승 중이라는 것을 의미합니다.</li>
<li><code>onboard[0]</code> = 0</li>
<li><code>onboard</code>에 1이 최소 한 번 이상 등장합니다.</li>
</ul></li>
<li>승객이 탑승 중인 시간에 쾌적한 실내온도를 유지하는 것이 불가능한 경우는 주어지지 않습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>temperature</th>
<th>t1</th>
<th>t2</th>
<th>a</th>
<th>b</th>
<th>onboard</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>28</td>
<td>18</td>
<td>26</td>
<td>10</td>
<td>8</td>
<td>[0, 0, 1, 1, 1, 1, 1]</td>
<td>40</td>
</tr>
<tr>
<td>-10</td>
<td>-5</td>
<td>5</td>
<td>5</td>
<td>1</td>
<td>[0, 0, 0, 0, 0, 1, 0]</td>
<td>25</td>
</tr>
<tr>
<td>11</td>
<td>8</td>
<td>10</td>
<td>10</td>
<td>1</td>
<td>[0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1]</td>
<td>20</td>
</tr>
<tr>
<td>11</td>
<td>8</td>
<td>10</td>
<td>10</td>
<td>100</td>
<td>[0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1]</td>
<td>60</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>
<table class="table">
        <thead><tr>
<th>시간(분)</th>
<th>승객 탑승</th>
<th>실내온도</th>
<th>희망온도</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>x</td>
<td>-10</td>
<td>40</td>
</tr>
<tr>
<td>1</td>
<td>x</td>
<td>-9</td>
<td>40</td>
</tr>
<tr>
<td>2</td>
<td>x</td>
<td>-8</td>
<td>40</td>
</tr>
<tr>
<td>3</td>
<td>x</td>
<td>-7</td>
<td>40</td>
</tr>
<tr>
<td>4</td>
<td>x</td>
<td>-6</td>
<td>40</td>
</tr>
<tr>
<td>5</td>
<td>o</td>
<td>-5</td>
<td>off</td>
</tr>
<tr>
<td>6</td>
<td>x</td>
<td>-6</td>
<td>off</td>
</tr>
</tbody>
      </table>
<p>0 ~ 4분에 에어컨의 희망온도를 40도로 설정하고, 5 ~ 6분에 에어컨의 전원을 끕니다. 이때 총 소비전력은 25(= 5 × 5)며, 이보다 소비전력이 적어지는 방법은 없습니다. 따라서 25를 return 해야 합니다.</p>

<p><strong>입출력 예 #3</strong></p>

<p>아래 표와 같이 에어컨을 조작하면 소비전력이 최소가 됩니다.</p>
<table class="table">
        <thead><tr>
<th>시간(분)</th>
<th>승객 탑승</th>
<th>실내온도</th>
<th>희망온도</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>x</td>
<td>11</td>
<td>10</td>
</tr>
<tr>
<td>1</td>
<td>o</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>2</td>
<td>o</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>3</td>
<td>o</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>4</td>
<td>o</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>5</td>
<td>o</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>6</td>
<td>o</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>7</td>
<td>x</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>8</td>
<td>x</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>9</td>
<td>x</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>10</td>
<td>o</td>
<td>10</td>
<td>10</td>
</tr>
<tr>
<td>11</td>
<td>o</td>
<td>10</td>
<td>off</td>
</tr>
</tbody>
      </table>
<p>이때 총 소비전력은 20이며, 이보다 소비전력이 적어지는 방법은 없습니다. 따라서 20을 return 해야 합니다.</p>

<p><strong>입출력 예 #4</strong></p>

<p>3번째 예시와 비교했을 때 <code>b</code>의 값이 다릅니다. 아래 표와 같이 에어컨을 조작하면 소비전력이 최소가 됩니다.</p>
<table class="table">
        <thead><tr>
<th>시간(분)</th>
<th>승객 탑승</th>
<th>실내온도</th>
<th>희망온도</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>x</td>
<td>11</td>
<td>8</td>
</tr>
<tr>
<td>1</td>
<td>o</td>
<td>10</td>
<td>8</td>
</tr>
<tr>
<td>2</td>
<td>o</td>
<td>9</td>
<td>8</td>
</tr>
<tr>
<td>3</td>
<td>o</td>
<td>8</td>
<td>off</td>
</tr>
<tr>
<td>4</td>
<td>o</td>
<td>9</td>
<td>off</td>
</tr>
<tr>
<td>5</td>
<td>o</td>
<td>10</td>
<td>8</td>
</tr>
<tr>
<td>6</td>
<td>o</td>
<td>9</td>
<td>off</td>
</tr>
<tr>
<td>7</td>
<td>x</td>
<td>10</td>
<td>off</td>
</tr>
<tr>
<td>8</td>
<td>x</td>
<td>11</td>
<td>off</td>
</tr>
<tr>
<td>9</td>
<td>x</td>
<td>11</td>
<td>9</td>
</tr>
<tr>
<td>10</td>
<td>o</td>
<td>10</td>
<td>9</td>
</tr>
<tr>
<td>11</td>
<td>o</td>
<td>9</td>
<td>off</td>
</tr>
</tbody>
      </table>
<p>이때 총 소비전력은 60이며, 이보다 소비전력이 적어지는 방법은 없습니다. 따라서 60을 return 해야 합니다.</p>

<div class="footnotes">
<hr>
<ol>

<li id="fn1">
<p><code>t1</code> ~ <code>t2</code>는 <code>t1</code>도 이상 <code>t2</code>도 이하의 온도 범위를 나타냅니다.&nbsp;<a href="#fnref1">↩</a></p>
</li>

</ol>
</div>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges