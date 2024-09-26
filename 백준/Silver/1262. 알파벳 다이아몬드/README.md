# [Silver I] 알파벳 다이아몬드 - 1262 

[문제 링크](https://www.acmicpc.net/problem/1262) 

### 성능 요약

메모리: 1112 KB, 시간: 0 ms

### 분류

구현

### 제출 일자

2024년 9월 26일 10:53:07

### 문제 설명

<p>알파벳 다이아몬드는 정수 길이의 마름모가 여러 개 누적되는 모양이다. 각각의 마름모는 하나의 알파벳 소문자로 그리며, a로 시작해서 z로 끝난다. (가운데에서부터) 그리고, z 이후에는 다시 a로 시작한다.</p>

<p>알파벳 다이아몬드는 다음과 같이 생겼다.</p>

<table class="table table-bordered td-center td-middle">
	<tbody>
		<tr>
			<td>
			<pre>a</pre>
			</td>
			<td>
			<pre>.b.
bab
.b.</pre>
			</td>
			<td>
			<pre>..c..
.cbc.
cbabc
.cbc.
..c..</pre>
			</td>
			<td>
			<pre>...d...
..dcd..
.dcbcd.
dcbabcd
.dcbcd.
..dcd..
...d...</pre>
			</td>
			<td>
			<pre>....e....
...ede...
..edcde..
.edcbcde.
edcbabcde
.edcbcde.
..edcde..
...ede...
....e....</pre>
			</td>
			<td>
			<pre>.....f.....
....fef....
...fedef...
..fedcdef..
.fedcbcdef.
fedcbabcdef
.fedcbcdef.
..fedcdef..
...fedef...
....fef....
.....f.....</pre>
			</td>
			<td>
			<pre>......g......
.....gfg.....
....gfefg....
...gfedefg...
..gfedcdefg..
.gfedcbcdefg.
gfedcbabcdefg
.gfedcbcdefg.
..gfedcdefg..
...gfedefg...
....gfefg....
.....gfg.....
......g......</pre>
			</td>
		</tr>
		<tr>
			<td>N = 1</td>
			<td>N = 2</td>
			<td>N = 3</td>
			<td>N = 4</td>
			<td>N = 5</td>
			<td>N = 6</td>
			<td>N = 7</td>
		</tr>
	</tbody>
</table>

<p style="text-align: left">동호는 이런 알파벳 다이아몬드를 타일로 만들어서, 방 바닥을 타일로 모두 채웠다. 예를 들어, N = 5인 아스키 다이아몬드를 세로 크기가 17, 가로 크기가 46인 방에 채운다면 다음과 같은 모양이 된다.</p>

<pre style="text-align: center;">....e........e........e........e........e.....
...ede......ede......ede......ede......ede....
..edcde....edcde....edcde....edcde....edcde...
.edcbcde..edcbcde..edcbcde..edcbcde..edcbcde..
edcbabcdeedcbabcdeedcbabcdeedcbabcdeedcbabcdee
.edcbcde..edcbcde..edcbcde..edcbcde..edcbcde..
..edcde....edcde....edcde....edcde....edcde...
...ede......ede......ede......ede......ede....
....e........e........e........e........e.....
....e........e........e........e........e.....
...ede......ede......ede......ede......ede....
..edcde....edcde....edcde....edcde....edcde...
.edcbcde..edcbcde..edcbcde..edcbcde..edcbcde..
edcbabcdeedcbabcdeedcbabcdeedcbabcdeedcbabcdee
.edcbcde..edcbcde..edcbcde..edcbcde..edcbcde..
..edcde....edcde....edcde....edcde....edcde...
...ede......ede......ede......ede......ede....</pre>

<p style="text-align: left">타일 하나위 위치는 행과 열을 이용해 표현한다. 행은 위에서부터 0행, 1행 이고, 열은 왼쪽부터 0열, 1열이다.</p>

<p style="text-align: left">동호는 자신의 방의 어떤 부분 직사각형에 쓰여 있는 알파벳이 궁금해졌다. N이 주어지고, 동호가 알고 싶어하는 직사각형의 왼쪽 위 좌표 (R<sub>1</sub>, C<sub>1</sub>)와 오른쪽 아래 좌표 (R<sub>2</sub>, C<sub>2</sub>)가 주어질 때, 그 직사각형에 쓰여 있는 알파벳을 출력하는 프로그램을 작성하시오. 동호의 방의 크기는 무한하다. (x, y)는 x행 y열을 의미한다.</p>

### 입력 

 <p>첫째 줄에 5개의 정수 N, R<sub>1</sub>, C<sub>1</sub>, R<sub>2</sub>, C<sub>2</sub>가 주어진다.</p>

### 출력 

 <p>(R<sub>2</sub> - R<sub>1</sub> + 1)줄에 (C<sub>2</sub> - C<sub>1</sub> + 1)개의 문자를 출력한다.</p>

