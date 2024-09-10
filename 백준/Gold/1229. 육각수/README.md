# [Gold IV] 육각수 - 1229 

[문제 링크](https://www.acmicpc.net/problem/1229) 

### 성능 요약

메모리: 5932 KB, 시간: 904 ms

### 분류

다이나믹 프로그래밍, 수학, 런타임 전의 전처리

### 제출 일자

2024년 9월 10일 09:03:59

### 문제 설명

<p>육각수는 육각형을 이용해 정의할 수 있다. h<sub>n</sub>은 한 변에 점 1, 2, ..., n개가 있는 육각형을 점 하나만 겹치게 그렸을 때 존재하는 서로 다른 점의 개수이다.</p>

<p style="text-align: center;"><img alt="" src="" style="width: 320px; height: 109px;"></p>

<p style="text-align: center;">그림 1</p>

<p>그림1은 h<sub>1</sub>, h<sub>2</sub>, h<sub>3</sub>, h<sub>4</sub>를 의미하며, 처음 육각수 6개는 1, 6, 15, 28, 45, 66이다.</p>

<p>자연수 N이 주어졌을 때, 합이 N이 되는 육각수 개수의 최솟값을 구해보자.</p>

<table class="table table-bordered table-center-20">
	<thead>
		<tr>
			<th>N</th>
			<th>최소 개수</th>
			<th>합</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>1</td>
			<td>1</td>
		</tr>
		<tr>
			<td>2</td>
			<td>2</td>
			<td>1+1</td>
		</tr>
		<tr>
			<td>3</td>
			<td>3</td>
			<td>1+1+1</td>
		</tr>
		<tr>
			<td>4</td>
			<td>4</td>
			<td>1+1+1+1</td>
		</tr>
		<tr>
			<td>5</td>
			<td>5</td>
			<td>1+1+1+1+1</td>
		</tr>
		<tr>
			<td>6</td>
			<td>1</td>
			<td>6</td>
		</tr>
		<tr>
			<td>7</td>
			<td>2</td>
			<td>1+6</td>
		</tr>
		<tr>
			<td>8</td>
			<td>3</td>
			<td>1+1+6</td>
		</tr>
		<tr>
			<td>9</td>
			<td>4</td>
			<td>1+1+1+6</td>
		</tr>
		<tr>
			<td>10</td>
			<td>5</td>
			<td>1+1+1+1+6</td>
		</tr>
		<tr>
			<td>11</td>
			<td>6</td>
			<td>1+1+1+1+1+6</td>
		</tr>
		<tr>
			<td>12</td>
			<td>2</td>
			<td>6+6</td>
		</tr>
	</tbody>
</table>

<p>1791보다 큰 정수는 항상 육각수 4개의 합으로 만들 수 있다. 또한, 수가 충분히 크다면 항상 육각수 3개의 합으로 만들 수 있다. 또, 최소 개수는 항상 6 이하이고, 이것이 최소인 N은 11과 26밖에 없다. 답이 6인 가장 큰 N은 26, 5인 가장 큰 N은 130, 4인 가장 큰 N은 146858이다.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다.</p>

### 출력 

 <p>첫째 줄에 N을 만들기 위해 필요한 육각수 개수의 최솟값을 출력한다.</p>

