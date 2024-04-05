# [level 2] 조건에 맞는 아이템들의 가격의 총합 구하기 - 273709 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/273709) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > SUM， MAX， MIN

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 04월 05일 17:38:48

### 문제 설명

<p>다음은 어느 한 게임에서 사용되는 아이템들의 아이템 정보를 담은 <code>ITEM_INFO</code> 테이블입니다. <code>ITEM_INFO</code> 테이블은 다음과 같으며, <code>ITEM_ID</code>, <code>ITEM_NAME</code>, <code>RARITY</code>, <code>PRICE</code>는 각각 아이템 ID, 아이템 명, 아이템의 희귀도, 아이템의 가격을 나타냅니다.</p>
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
<hr>

<h5>문제</h5>

<p><code>ITEM_INFO</code> 테이블에서 희귀도가 'LEGEND'인  아이템들의 가격의 총합을 구하는 SQL문을 작성해 주세요. 이때 컬럼명은 'TOTAL_PRICE'로 지정해 주세요.</p>

<hr>

<h5>예시</h5>

<p>예를 들어 <code>ITEM_INFO</code> 테이블이 다음과 같다면</p>
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
<p>조건에 해당되는 아이템의 아이템 ID는 1, 2, 4이며 각 아이템들의 가격은 9000, 11000, 12000 이므로 조건에 해당되는 아이템들의 가격의 합은 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th>TOTAL_PRICE</th>
</tr>
</thead>
        <tbody><tr>
<td>32000</td>
</tr>
</tbody>
      </table>
<hr>

<p>※ 참고: 본 문제는 제출 내역 확인 기능을 지원하지 않습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges