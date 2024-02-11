# [level 4] 1,2,3 떨어트리기 - 150364 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/150364) 

### 성능 요약

메모리: 76.7 MB, 시간: 0.27 ms

### 구분

코딩테스트 연습 > 2023 KAKAO BLIND RECRUITMENT

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 2월 1일 8:31:14

### 문제 설명

<p><code>춘식이</code>는 트리의 1번 노드에 숫자 1, 2, 3 중 하나씩을 계속해서 떨어트려 트리의 리프 노드<sup id="fnref1"><a href="#fn1">1</a></sup>에 숫자를 쌓는 게임을 하려고 합니다. <br>
아래 그림은 게임의 예시를 나타냅니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/8c0e537f-10d8-470b-b034-a9f532e2ccee/railload.jpg" title="" alt="railroad.jpg"></p>

<ul>
<li>트리의 모든 간선은 부모 노드가 자식 노드를 가리키는 단방향 간선입니다.</li>
<li><strong>모든 부모 노드는 자식 노드와 연결된 간선 중 하나를 길로 설정합니다.</strong>

<ul>
<li>실선 화살표는 길인 간선입니다.</li>
<li>점선 화살표는 길이 아닌 간선입니다.</li>
</ul></li>
<li>모든 부모 노드는 자신의 자식 노드 중 가장 번호가 작은 노드를 가리키는 간선을 초기 길로 설정합니다.</li>
</ul>

<p>[게임의 규칙]은 아래와 같습니다.</p>

<ol>
<li>1번 노드(루트 노드)에 숫자 1, 2, 3 중 하나를 떨어트립니다.</li>
<li>숫자는 길인 간선을 따라 리프 노드까지 떨어집니다.</li>
<li>숫자가 리프 노드에 도착하면, 숫자가 지나간 각 노드는 <code>현재 길로 연결된 자식 노드 다음으로 번호가 큰 자식 노드</code>를 가리키는 간선을 새로운 길로 설정하고 기존의 길은 끊습니다. 

<ul>
<li>만약 현재 길로 연결된 노드의 번호가 가장 크면, 번호가 가장 작은 노드를 가리키는 간선을 길로 설정합니다.</li>
<li>노드의 간선이 하나라면 계속 하나의 간선을 길로 설정합니다.</li>
</ul></li>
<li>원하는 만큼 계속해서 루트 노드에 숫자를 떨어트릴 수 있습니다.

<ul>
<li>단, 앞서 떨어트린 숫자가 리프 노드까지 떨어진 후에 새로운 숫자를 떨어트려야 합니다.</li>
</ul></li>
</ol>

<p>[게임의 목표]는 각각의 리프 노드에 쌓인 숫자의 합을 <code>target</code>에서 가리키는 값과 같게 만드는 것입니다.<br>
예를 들어, <code>target</code>이 [0, 0, 0, 3, 0, 0, 5, 1, 2, 3]일 경우 아래 표와 같은 의미를 가집니다.</p>
<table class="table">
        <thead><tr>
<th>노드 번호</th>
<th>노드에 쌓인 숫자의 합</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>2</td>
<td>0</td>
</tr>
<tr>
<td>3</td>
<td>0</td>
</tr>
<tr>
<td>4</td>
<td>3</td>
</tr>
<tr>
<td>5</td>
<td>0</td>
</tr>
<tr>
<td>6</td>
<td>0</td>
</tr>
<tr>
<td>7</td>
<td>5</td>
</tr>
<tr>
<td>8</td>
<td>1</td>
</tr>
<tr>
<td>9</td>
<td>2</td>
</tr>
<tr>
<td>10</td>
<td>3</td>
</tr>
</tbody>
      </table>
<p><code>target</code>대로 리프 노드에 쌓인 숫자의 합을 맞추기 위해서는 [2, 1, 2, 2, 1, 3, 3]순으로 숫자를 떨어트리면 됩니다.</p>

<p>아래 두 그림은 순서대로 1, 2번째 숫자 [2, 1]을 떨어트린 뒤의 길 상황을 나타냅니다.<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/93b09e90-73db-4ec8-851c-66fb4bf428a8/railroad21.jpg" title="" alt="railroad21.jpg"></p>

<ul>
<li>숫자 2는 떨어지면서 1번 노드와 2번 노드를 지나갔습니다. 

<ul>
<li>1번 노드는 3번 노드를 가리키는 간선을 길로 설정합니다.</li>
<li>2번 노드는 5번 노드를 가리키는 간선을 길로 설정합니다.</li>
</ul></li>
<li>숫자 1은 떨어지면서 1번 노드, 3번 노드, 6번 노드를 지나갔습니다.

<ul>
<li>1번 노드는 3번 노드보다 번호가 큰 노드를 가리키는 간선이 없으므로 다시 2번 노드를 가리키는 간선을 길로 설정합니다.</li>
<li>3번 노드는 간선이 하나이므로 계속해서 6번 노드를 가리키는 간선을 길로 설정합니다.</li>
<li>6번 노드는 9번 노드를 가리키는 간선을 길로 설정합니다.</li>
</ul></li>
</ul>

<p>아래 두 그림은 순서대로 3, 4번째 숫자 [2, 2]를 떨어트린 뒤의 길 상황을 나타냅니다.<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/fc3a6a07-1a1e-41b7-9ce8-d08113d42a2c/railroad2122.jpg" title="" alt="railroad2122.jpg"></p>

<p>아래 세 그림은 순서대로 5, 6, 7번째 숫자 [1, 3, 3]을 떨어트린 뒤의 길 상황을 나타냅니다.<br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/791e4e74-7017-44b2-93e6-68503e1f24a1/railroad2122133.jpg" title="" alt="railroad2122133.jpg"></p>

<p>각 리프 노드에 쌓인 숫자를 모두 더해 배열로 나타내면 <code>target</code>과 같습니다.</p>

<p>트리의 각 노드들의 연결 관계를 담은 2차원 정수 배열 <code>edges</code>, 각 노드별로 만들어야 하는 숫자의 합을 담은 1차원 정수 배열 <code>target</code>이 매개변수로 주어집니다. 이때, <code>target</code> 대로 리프 노드에 쌓인 숫자의 합을 맞추기 위해 숫자를 떨어트리는 모든 경우 중 가장 적은 숫자를 사용하며 그중 사전 순으로 가장 빠른 경우를 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해주세요. 만약, <code>target</code>대로 숫자의 합을 만들 수 없는 경우 <code>[-1]</code>을 return 해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>edges</code>의 길이 ≤ 100

<ul>
<li><code>edges[i]</code>는 [부모 노드 번호, 자식 노드 번호] 형태로, 단방향으로 연결된 두 노드를 나타냅니다.

<ul>
<li>1 ≤ 노드 번호 ≤ <code>edges</code>의 길이 + 1</li>
</ul></li>
<li>동일한 간선에 대한 정보가 중복해서 주어지지 않습니다.</li>
<li>항상 하나의 트리 형태로 입력이 주어지며, 잘못된 데이터가 주어지는 경우는 없습니다.</li>
<li>1번 노드는 항상 루트 노드입니다.</li>
</ul></li>
<li><code>target</code>의 길이 = <code>edges</code>의 길이 + 1

<ul>
<li><code>target[i]</code>는 i + 1번 노드에 쌓인 숫자의 합으로 만들어야 하는 수를 나타냅니다.

<ul>
<li>0 ≤ 리프 노드의 <code>target</code>값 ≤ 100</li>
<li>리프 노드를 제외한 노드의 <code>target</code>값 = 0</li>
</ul></li>
<li><code>target</code>의 원소의 합은 1 이상입니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>edges</th>
<th>target</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[2, 4], [1, 2], [6, 8], [1, 3], [5, 7], [2, 5], [3, 6], [6, 10], [6, 9]]</td>
<td>[0, 0, 0, 3, 0, 0, 5, 1, 2, 3]</td>
<td>[1, 1, 2, 2, 2, 3, 3]</td>
</tr>
<tr>
<td>[[1, 2], [1, 3]]</td>
<td>[0, 7, 3]</td>
<td>[1, 1, 3, 2, 3]</td>
</tr>
<tr>
<td>[[1, 3], [1, 2]]</td>
<td>[0, 7, 1]</td>
<td>[-1]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다. 위의 설명처럼 [2, 1, 2, 2, 1, 3, 3]순으로 숫자를 떨어트리면 target과 같게 만들 수 있지만, 가장 적은 숫자를 사용하며 그중 사전 순으로 가장 빠른 경우는 [1, 1, 2, 2, 2, 3, 3]입니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>[3, 2, 1, 1, 3]순으로 숫자를 떨어트리거나 [1, 1, 1, 1, 2, 1, 3]순으로 숫자를 떨어트려도 target과 같게 만들 수 있지만, 가장 적은 숫자를 사용하며 그중 사전 순으로 가장 빠른 경우는 [1, 1, 3, 2, 3]입니다.  </p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b66b8fd9-ce35-4f5f-8502-401328e1e10a/railroad%20ex2.jpg" title="" alt="railroad ex2.jpg"></p>

<p><strong>입출력 예 #3</strong></p>

<p>예제 3번의 트리는 주어지는 <code>edges</code>의 순서만 다를 뿐, 예제 2번과 같은 트리입니다. 2번 노드에 쌓인 숫자의 합을 7로 만들면서 3번 노드에 쌓인 숫자의 합을 1로 만들도록 숫자를 떨어트리는 방법은 없습니다.<br>
따라서 [-1]을 return 해야 합니다.</p>

<div class="footnotes">
<hr>
<ol>

<li id="fn1">
<p>리프 노드는 자식 노드가 없는 노드를 뜻합니다.&nbsp;<a href="#fnref1">↩</a></p>
</li>

</ol>
</div>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges