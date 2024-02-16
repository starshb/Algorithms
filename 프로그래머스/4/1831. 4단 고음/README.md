# [level 4] 4단 고음 - 1831 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/1831) 

### 성능 요약

메모리: 94.1 MB, 시간: 769.81 ms

### 구분

코딩테스트 연습 > 2017 카카오코드 예선

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 2월 6일 1:21:49

### 문제 설명

<h2>4단 고음</h2>

<p><img src="http://t1.kakaocdn.net/codefestival/IU1.png" title="IU1" alt="alt text"><br>
<img src="http://t1.kakaocdn.net/codefestival/IU2.png" title="IU2" alt="alt text"></p>
<div class="highlight"><pre class="codehilite"><code>I'm in my dream~↗ ~↗ ~↗
</code></pre></div>
<p>IU는 본인의 장기인 3단 고음으로 유명하다. 그러던 그녀가 어느 날 4단 고음을 성공했고 그녀의 고음은 학계에서 연구가 될 만큼 유명해졌다 [1].</p>

<p><img src="http://t1.kakaocdn.net/codefestival/IU_paper.png" title="IU Paper" alt="alt text"><br>
[1] 견두헌, 배명진. “아이유의 고음 발성 특성 분석”, 한국음향학회, 2011년 춘계학술대회 학술발표논문지</p>

<p>폭포 밑 득음 수련을 하던 어느 날, 그녀는 4단 고음이 끝이 아님을 깨달았다. 3단 고음 직후 3단 고음을 연이어하거나, 3단 고음 중 다시 3단 고음을 해서 음높이를 올리는 방법이다. 어떤 순서로 3단 고음을 했는지에 따라 최종 음높이가 달라지기 때문에, 연속 3단 고음을 연습할 때마다 그 결과를 기록으로 남기기로 했다.</p>

<p>3단 고음은 다음과 같이 적용된다. 1단계에서는 음높이가 세 배가 되며, 2단계와 3단계에서 음높이가 각각 1씩 증가한다. 이를 기록으로 남길 때 * 와 + 기호를 사용하기로 했다. 즉, 3단 고음을 한 번 한 경우는 문자열로 나타내면 다음과 같다.</p>

<p>*++</p>

<p>이때 3단 고음을 마치고 연달아 3단 고음을 한 경우는 *++<code>*++</code> 와 같이 표현할 수 있다. 3단 고음의 2단계를 마친 후 3단 고음을 새로 시작한 다음, 나머지 단계를 이어서 하는 경우는 *+<code>*++</code>+로 표현할 수 있다. (강조된 부분이 2번째 3단 고음을 부른 부분이다.)</p>

<p>이와 같이 * 와 + 로 구성된 문자열이 3단 고음의 규칙을 적용하여 만들 수 있는 문자열인 경우 '올바른 문자열'이라고 하자. 다음의 문자열은 3단 고음의 규칙으로 만들 수 있는 문자열이 아니므로 올바른 문자열이 아니다.</p>

<ul>
<li>+**+++</li>
<li>*+++*+</li>
</ul>

<p>올바른 문자열에 대해 음높이는 다음과 같이 계산할 수 있다. 시작 음높이는 항상 1이며, 문자열의 처음부터 순서대로 * 기호의 경우 3을 곱하고 + 기호의 경우 1을 더한다. *+*+++ 의 음높이를 계산하는 과정을 예로 들면 아래와 같다.</p>

<p>시작 음 높이: 1</p>
<table class="table">
        <thead><tr>
<th>*</th>
<th>+</th>
<th>*</th>
<th>+</th>
<th>+</th>
<th>+</th>
</tr>
</thead>
        <tbody><tr>
<td>*3</td>
<td>+1</td>
<td>*3</td>
<td>+1</td>
<td>+1</td>
<td>+1</td>
</tr>
</tbody>
      </table>
<p>최종 음높이: 15</p>

<p>그날 기분에 따라 최종 음높이를 정하는 IU는 최종 음높이를 결정했을 때 서로 다른 3단 고음 문자열이 몇 가지나 있는지 궁금하다. 여러분의 도움이 필요하다.</p>

<h3>입력 형식</h3>

<ul>
<li>입력은 <code>5</code> 이상 <code>2^31-1</code> 이하의 정수 <code>n</code>으로 주어진다.</li>
</ul>

<h3>출력 형식</h3>

<ul>
<li>입력을 만족하는 서로 다른 문자열의 수를 리턴한다.</li>
</ul>

<h3>예제 입출력</h3>
<table class="table">
        <thead><tr>
<th>n</th>
<th>answer</th>
</tr>
</thead>
        <tbody><tr>
<td>15</td>
<td>1</td>
</tr>
<tr>
<td>24</td>
<td>0</td>
</tr>
<tr>
<td>41</td>
<td>2</td>
</tr>
<tr>
<td>2147483647</td>
<td>1735</td>
</tr>
</tbody>
      </table>
<h3>예제에 대한 설명</h3>

<p>세 번째 예제의 두 가지 경우는 다음과 같다.</p>

<p><code>**++++*++</code><br>
<code>*+**+++++</code></p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges