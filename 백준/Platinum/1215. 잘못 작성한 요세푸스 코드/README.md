# [Platinum IV] 잘못 작성한 요세푸스 코드 - 1215 

[문제 링크](https://www.acmicpc.net/problem/1215) 

### 성능 요약

메모리: 2020 KB, 시간: 0 ms

### 분류

수학, 정수론

### 제출 일자

2024년 9월 9일 09:39:40

### 문제 설명

<p>요세푸스 문제는 아래와 같이 풀 수 있다.</p>

<div><div id="highlighter_994119" class="syntaxhighlighter  c"><table border="0" cellpadding="0" cellspacing="0"><tbody><tr><td class="gutter"><div class="line number1 index0 alt2">1</div><div class="line number2 index1 alt1">2</div><div class="line number3 index2 alt2">3</div><div class="line number4 index3 alt1">4</div></td><td class="code"><div class="container"><div class="line number1 index0 alt2"><code class="c plain">r := 0;</code></div><div class="line number2 index1 alt1"><code class="c keyword bold">for</code> <code class="c plain">i from 1 to n </code><code class="c keyword bold">do</code></div><div class="line number3 index2 alt2"><code class="c spaces">    </code><code class="c plain">r := (r + k) mod i;</code></div><div class="line number4 index3 alt1"><code class="c keyword bold">return</code> <code class="c plain">r;</code></div></div></td></tr></tbody></table></div></div>

<p>하지만 상근이는 코드를 잘못 읽고 아래와 같이 작성했다.</p>

<div><div id="highlighter_846726" class="syntaxhighlighter  c"><table border="0" cellpadding="0" cellspacing="0"><tbody><tr><td class="gutter"><div class="line number1 index0 alt2">1</div><div class="line number2 index1 alt1">2</div><div class="line number3 index2 alt2">3</div><div class="line number4 index3 alt1">4</div></td><td class="code"><div class="container"><div class="line number1 index0 alt2"><code class="c plain">r := 0;</code></div><div class="line number2 index1 alt1"><code class="c keyword bold">for</code> <code class="c plain">i from 1 to n </code><code class="c keyword bold">do</code></div><div class="line number3 index2 alt2"><code class="c spaces">    </code><code class="c plain">r := r + (k mod i);</code></div><div class="line number4 index3 alt1"><code class="c keyword bold">return</code> <code class="c plain">r;</code></div></div></td></tr></tbody></table></div></div>

<p>n과 k가 주어졌을 때, 상근이의 잘못 작성한 소스를 실행시킨 결과를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 줄에 n과 k가 주어진다. (1 ≤ n, k ≤ 10<sup>9</sup>)<br>
 </p>

### 출력 

 <p>첫째 줄에 주어진 n과 k로 상근이의 잘못 작성한 소스의 결과를 출력한다.</p>

