# [level 3] 2차원 동전 뒤집기 - 131703 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131703) 

### 성능 요약

메모리: 78.8 MB, 시간: 0.03 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 3일 2:1:30

### 문제 설명

<p>한수는 직사각형 모양의 공간에 놓인 동전들을 뒤집는 놀이를 하고 있습니다. 모든 동전들은 앞과 뒤가 구분되어 있으며, 동전을 뒤집기 위해서는 같은 줄에 있는 모든 동전을 뒤집어야 합니다. 동전들의 초기 상태와 목표 상태가 주어졌을 때, 초기 상태에서 최소 몇 번의 동전을 뒤집어야 목표 상태가 되는지 알아봅시다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7efaaecf-e627-40a8-ab90-60550523ccb0/2%EC%B0%A8%EC%9B%90%201.png" title="" alt="2차원 1.png"></p>

<p>예를 들어, 위 그림에서 맨 왼쪽이 초기 상태, 맨 오른쪽이 목표 상태인 경우에 대해 알아봅시다. 그림에서 검은색 원은 앞면인 동전, 흰색 원은 뒷면인 동전을 의미합니다. 초기 상태에서 2행과 4행의 돌들을 뒤집으면, 두 번째 그림이 됩니다. 그 후, 2열, 4열, 5열의 돌들을 순서대로 뒤집는 다면, 총 5번의 동전 뒤집기를 통해 목표 상태가 되며, 이 경우가 최소인 경우입니다.</p>

<p>직사각형 모양의 공간에 놓인 동전들의 초기 상태를 나타내는 2차원 정수 배열 <code>beginning</code>, 목표 상태를 나타내는 <code>target</code>이 주어졌을 때, 초기 상태에서 목표 상태로 만들기 위해 필요한 동전 뒤집기 횟수의 최솟값을 return 하는 solution 함수를 완성하세요. 단, 목표 상태를 만들지 못하는 경우에는 -1을 return 합니다.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>beginning</code>의 길이 = <code>target</code>의 길이 ≤ 10</li>
<li>1 ≤ <code>beginning[i]</code>의 길이 = <code>target[i]</code>의 길이 ≤ 10

<ul>
<li><code>beginning[i][j]</code>와 <code>target[i][j]</code>는 i + 1행 j + 1열의 동전의 상태를 나타내며, 0 또는 1의 값으로 주어집니다.</li>
<li>0은 동전의 앞면을, 1은 동전의 뒷면을 의미합니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>beginning</th>
<th>target</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[0, 1, 0, 0, 0], [1, 0, 1, 0, 1], [0, 1, 1, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 1, 0]]</td>
<td>[[0, 0, 0, 1, 1], [0, 0, 0, 0, 1], [0, 0, 1, 0, 1], [0, 0, 0, 1, 0], [0, 0, 0, 0, 1]]</td>
<td>5</td>
</tr>
<tr>
<td>[[0, 0, 0], [0, 0, 0], [0, 0, 0]]</td>
<td>[[1, 0, 1], [0, 0, 0], [0, 0, 0]]</td>
<td>-1</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>문제 예시와 같습니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>목표 상태를 만들지 못합니다. 따라서 -1을 return 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges