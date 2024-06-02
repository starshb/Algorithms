# [Platinum III] 괄호 문자열 - 1023 

[문제 링크](https://www.acmicpc.net/problem/1023) 

### 성능 요약

메모리: 14288 KB, 시간: 128 ms

### 분류

조합론, 다이나믹 프로그래밍, 수학

### 제출 일자

2024년 6월 3일 01:03:48

### 문제 설명

<p>괄호 문자열은 다음과 같이 정의 한다.</p>

<ol>
	<li>빈 문자열은 괄호 문자열이다.</li>
	<li><code>S</code>가 괄호 문자열일 때, <code>(S)</code>도 괄호 문자열이다.</li>
	<li><code>S</code>와 <code>T</code>가 괄호 문자열이라면, <code>ST</code>도 괄호 문자열이다.</li>
	<li>모든 괄호 문자열은 위의 3개 규칙으로만 만들 수 있다.</li>
</ol>

<p>이 문제에서는 괄호 문자열이 아닌 문자열이 나온다. 만약 문자열이 ‘<code>(</code>’와 ‘<code>)</code>’로만 이루어져 있고, 괄호 문자열이 아니라면, 그 문자열을 괄호ㄴㄴ문자열이라고 한다.</p>

<p>길이가 N인 괄호ㄴㄴ문자열 중에 사전순으로 K번째인 문자열을 출력하는 프로그램을 작성하시오. 그러한 것이 없으면 -1을 출력한다. ‘<code>(</code>’가 ‘<code>)</code>’보다 사전순으로 앞선다. 사전순으로 가장 앞서는 문자열은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>번째 문자열이다.</p>

### 입력 

 <p>첫째 줄에 두 정수 N과 K가 주어진다.</p>

### 출력 

 <p>첫째 줄에 문제의 정답을 출력한다.</p>

