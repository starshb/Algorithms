# [level 0] 안전지대 - 120866 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120866) 

### 성능 요약

메모리: 58.9 MB, 시간: 0.03 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

Empty

### 문제 설명

<p>다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/124a2c93-da99-4643-96a8-292bb871f553/image.png" title="" alt="image.png"><br>
지뢰는 2차원 배열 <code>board</code>에 1로 표시되어 있고 <code>board</code>에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.<br>
지뢰가 매설된 지역의 지도 <code>board</code>가&nbsp;매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li><code>board</code>는 n * n 배열입니다.</li>
<li>1 ≤ n ≤ 100</li>
<li>지뢰는 1로 표시되어 있습니다.</li>
<li><code>board</code>에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>board</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]</td>
<td>16</td>
</tr>
<tr>
<td>[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]</td>
<td>13</td>
</tr>
<tr>
<td>[[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]</td>
<td>0</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>(3, 2)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선 총 8칸은 위험지역입니다. 따라서 16을 return합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>(3, 2), (3, 3)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선은 위험지역입니다. 따라서 위험지역을 제외한 칸 수 13을 return합니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>모든 지역에 지뢰가 있으므로 안전지역은 없습니다. 따라서 0을 return합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges