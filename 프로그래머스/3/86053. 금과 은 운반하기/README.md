# [level 3] 금과 은 운반하기 - 86053 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86053) 

### 성능 요약

메모리: 76.8 MB, 시간: 0.11 ms

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 6일 7:16:21

### 문제 설명

<p>어느 왕국에 하나 이상의 도시들이 있습니다. 왕국의 왕은 새 도시를 짓기로 결정하였습니다. 해당 도시를 짓기 위해서는 도시를 짓는 장소에 금 <code>a</code> kg과 은 <code>b</code> kg이 전달되어야 합니다.</p>

<p>각 도시에는 번호가 매겨져 있는데, <code>i</code>번 도시에는 금 <code>g[i]</code> kg, 은 <code>s[i]</code> kg, 그리고 트럭 한 대가 있습니다. <code>i</code>번 도시의 트럭은 오직 새 도시를 짓는 건설 장소와 <code>i</code>번 도시만을 왕복할 수 있으며, 편도로 이동하는 데 <code>t[i]</code> 시간이 걸리고, 최대 <code>w[i]</code> kg 광물을 운반할 수 있습니다. (광물은 금과 은입니다. 즉, 금과 은을 동시에 운반할 수 있습니다.) 모든 트럭은 같은 도로를 여러 번 왕복할 수 있으며 연료는 무한대라고 가정합니다.</p>

<p>정수 <code>a</code>, <code>b</code>와 정수 배열 <code>g</code>, <code>s</code>, <code>w</code>, <code>t</code>가 매개변수로 주어집니다. 주어진 정보를 바탕으로 각 도시의 트럭을 최적으로 운행했을 때, 새로운 도시를 건설하기 위해 금 <code>a</code> kg과 은 <code>b</code> kg을 전달할 수 있는 가장 빠른 시간을 구해 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>0 ≤ <code>a</code>, <code>b</code> ≤ 10<sup>9</sup></li>
<li>1 ≤ <code>g</code>의 길이 = <code>s</code>의 길이 = <code>w</code>의 길이 = <code>t</code>의 길이 = 도시 개수 ≤ 10<sup>5</sup>

<ul>
<li>0 ≤ <code>g[i]</code>, <code>s[i]</code> ≤ 10<sup>9</sup></li>
<li>1 ≤ <code>w[i]</code> ≤ 10<sup>2</sup></li>
<li>1 ≤ <code>t[i]</code> ≤ 10<sup>5</sup></li>
<li><code>a</code> ≤ <code>g</code>의 모든 수의 합</li>
<li><code>b</code> ≤ <code>s</code>의 모든 수의 합</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>a</th>
<th>b</th>
<th>g</th>
<th>s</th>
<th>w</th>
<th>t</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>10</td>
<td>10</td>
<td>[100]</td>
<td>[100]</td>
<td>[7]</td>
<td>[10]</td>
<td>50</td>
</tr>
<tr>
<td>90</td>
<td>500</td>
<td>[70,70,0]</td>
<td>[0,0,500]</td>
<td>[100,100,2]</td>
<td>[4,8,1]</td>
<td>499</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>도시가 오직 하나뿐이므로, 0번 도시의 유일한 트럭이 모든 운반을 해결해야 합니다. 이 트럭은 최대 7kg만큼의 광물을 운반할 수 있으며 편도 완주에는 10시간이 걸립니다.</li>
<li>맨 처음에 10시간을 써서 7kg만큼의 금을 운반하고, 10시간을 써서 다시 도시로 돌아오고, 10시간을 써서 7kg만큼의 은을 운반하고, 10시간을 써서 다시 도시로 돌아오고, 마지막으로 10시간을 써서 3kg만큼의 금과 3kg만큼의 은을 운반하면, 총 50시간 만에 필요한 모든 금과 은을 조달할 수 있습니다.</li>
<li>따라서, 50을 return 해야 합니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>도시가 3개이고, 0번과 1번 도시는 금만 70kg씩 가지고 있고 2번 도시는 은을 500kg 가지고 있습니다.

<ul>
<li>0번 도시의 트럭은 용량은 100kg, 편도 완주 시간은 4시간입니다.</li>
<li>1번 도시의 트럭은 용량은 100kg, 편도 완주 시간은 8시간입니다.</li>
<li>2번 도시의 트럭은 용량은 2kg, 편도 완주 시간은 1시간입니다.</li>
</ul></li>
<li>금은 0번 도시의 트럭과 1번 도시의 트럭이 각각 45kg씩 나누어서 운반하면 8시간 안에 필요한 모든 금을 조달할 수 있습니다.</li>
<li>은은 2번 도시의 트럭이 한 번에 2kg씩 250번 운반하면(249번 왕복 + 1번 편도) 총 499시간 만에 필요한 모든 은을 조달할 수 있습니다.</li>
<li>따라서, 499를 return 해야 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges