# [level 2] ROOT 아이템 구하기 - 273710 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/273710) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > IS NULL

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 04월 06일 08:53:39

### 문제 설명

<p>어느 한 게임에서 사용되는 아이템들은 업그레이드가 가능합니다.<br>
'ITEM_A'-&gt;'ITEM_B'와 같이 업그레이드가 가능할 때 <br>
'ITEM_A'를 'ITEM_B'의 PARENT 아이템,<br>
 PARENT 아이템이 없는 아이템을 ROOT 아이템이라고 합니다.</p>

<p>예를 들어 'ITEM_A'-&gt;'ITEM_B'-&gt;'ITEM_C' 와 같이 업그레이드가 가능한 아이템이 있다면<br>
'ITEM_C'의 PARENT 아이템은 'ITEM_B'<br>
'ITEM_B'의 PARENT 아이템은 'ITEM_A'<br>
ROOT 아이템은 'ITEM_A'가 됩니다.</p>

<p>다음은 해당 게임에서 사용되는 아이템 정보를 담은 <code>ITEM_INFO</code> 테이블과 아이템 관계를 나타낸 <code>ITEM_TREE</code> 테이블입니다. <code>ITEM_INFO</code> 테이블은 다음과 같으며, <code>ITEM_ID</code>, <code>ITEM_NAME</code>, <code>RARITY</code>, <code>PRICE</code>는 각각 아이템 ID, 아이템 명, 아이템의 희귀도, 아이템의 가격을 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>ITEM_ID</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>ITEM_NAME</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
<tr>
<td>RARITY</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>PRICE</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p><code>ITEM_TREE</code> 테이블은 다음과 같으며, <code>ITEM_ID</code>, <code>PARENT_ITEM_ID</code>는 각각 아이템 ID, PARENT 아이템의 ID를 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>ITEM_ID</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>PARENT_ITEM_ID</td>
<td>INTEGER</td>
<td>TRUE</td>
</tr>
</tbody>
      </table>
<p>단, 각 아이템들은 오직 하나의 PARENT 아이템 ID를 가지며, ROOT 아이템의 PARENT 아이템 ID는 NULL 입니다.</p>

<p>ROOT 아이템이 없는 경우는 존재하지 않습니다.</p>

<hr>

<h5>문제</h5>

<p>ROOT 아이템을 찾아 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME)을 출력하는 SQL문을 작성해 주세요. 이때, 결과는 아이템 ID를 기준으로 오름차순 정렬해 주세요.</p>

<hr>

<h5>예시</h5>

<p>예를 들어 <code>ITEM_INFO</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th>ITEM_ID</th>
<th>ITEM_NAME</th>
<th>RARITY</th>
<th>PRICE</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>ITEM_A</td>
<td>COMMON</td>
<td>10000</td>
</tr>
<tr>
<td>1</td>
<td>ITEM_B</td>
<td>LEGEND</td>
<td>9000</td>
</tr>
<tr>
<td>2</td>
<td>ITEM_C</td>
<td>LEGEND</td>
<td>11000</td>
</tr>
<tr>
<td>3</td>
<td>ITEM_D</td>
<td>UNIQUE</td>
<td>10000</td>
</tr>
<tr>
<td>4</td>
<td>ITEM_E</td>
<td>LEGEND</td>
<td>12000</td>
</tr>
</tbody>
      </table>
<p><code>ITEM_TREE</code>  테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th>ITEM_ID</th>
<th>PARENT_ITEM_ID</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>NULL</td>
</tr>
<tr>
<td>1</td>
<td>0</td>
</tr>
<tr>
<td>2</td>
<td>0</td>
</tr>
<tr>
<td>3</td>
<td>NULL</td>
</tr>
<tr>
<td>4</td>
<td>3</td>
</tr>
</tbody>
      </table>
<p>ROOT 아이템의 아이템 ID는 PARENT 아이템 ID(PARENT_ITEM_ID)가 NULL 인 0, 3 이므로 SQL문을 실행하면 다음과 같은 결과가 나와야 합니다.</p>
<table class="table">
        <thead><tr>
<th>ITEM_ID</th>
<th>ITEM_NAME</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>ITEM_A</td>
</tr>
<tr>
<td>3</td>
<td>ITEM_D</td>
</tr>
</tbody>
      </table>
<hr>

<p>※ 참고: 본 문제는 제출 내역 확인 기능을 지원하지 않습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges