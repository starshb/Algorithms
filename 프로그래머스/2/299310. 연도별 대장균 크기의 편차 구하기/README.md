# [level 2] 연도별 대장균 크기의 편차 구하기 - 299310 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/299310) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > SUM， MAX， MIN

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 04월 16일 00:05:54

### 문제 설명

<p>대장균들은 일정 주기로 분화하며, 분화를 시작한 개체를 부모 개체, 분화가 되어 나온 개체를 자식 개체라고 합니다.<br>
다음은 실험실에서 배양한 대장균들의 정보를 담은 <code>ECOLI_DATA</code> 테이블입니다. <code>ECOLI_DATA</code> 테이블의 구조는 다음과 같으며,  <code>ID</code>, <code>PARENT_ID</code>, <code>SIZE_OF_COLONY</code>, <code>DIFFERENTIATION_DATE</code>, <code>GENOTYPE</code> 은 각각 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질을 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>ID</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>PARENT_ID</td>
<td>INTEGER</td>
<td>TRUE</td>
</tr>
<tr>
<td>SIZE_OF_COLONY</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>DIFFERENTIATION_DATE</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>GENOTYPE</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p>최초의 대장균 개체의 <code>PARENT_ID</code> 는 NULL 값입니다.</p>

<hr>

<h5>문제</h5>

<p>분화된 연도(<code>YEAR</code>), 분화된 연도별 대장균 크기의 편차(<code>YEAR_DEV</code>), 대장균 개체의 ID(<code>ID</code>) 를 출력하는 SQL 문을 작성해주세요. 분화된 연도별 대장균 크기의 편차는 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기로 구하며 결과는 연도에 대해 오름차순으로 정렬하고 같은 연도에 대해서는 대장균 크기의 편차에 대해 오름차순으로 정렬해주세요.</p>

<hr>

<h5>예시</h5>

<p>예를 들어 <code>ECOLI_DATA</code> 테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th>ID</th>
<th>PARENT_ID</th>
<th>SIZE_OF_COLONY</th>
<th>DIFFERENTIATION_DATE</th>
<th>GENOTYPE</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td>NULL</td>
<td>10</td>
<td>2019/01/01</td>
<td>5</td>
</tr>
<tr>
<td>2</td>
<td>NULL</td>
<td>2</td>
<td>2019/01/01</td>
<td>3</td>
</tr>
<tr>
<td>3</td>
<td>1</td>
<td>100</td>
<td>2020/01/01</td>
<td>4</td>
</tr>
<tr>
<td>4</td>
<td>2</td>
<td>10</td>
<td>2020/01/01</td>
<td>4</td>
</tr>
<tr>
<td>5</td>
<td>2</td>
<td>17</td>
<td>2020/01/01</td>
<td>6</td>
</tr>
<tr>
<td>6</td>
<td>4</td>
<td>101</td>
<td>2021/01/01</td>
<td>22</td>
</tr>
</tbody>
      </table>
<p>분화된 연도별 가장 큰 대장균의 크기는 다음과 같습니다.</p>

<p>2019 : 10<br>
2020 : 100<br>
2021 : 101</p>

<p>따라서 각 대장균의 분화된 연도별 대장균 크기의 편차는 다음과 같습니다.</p>

<p>ID 1 : 10 - 10 = 0<br>
ID 2 : 10 -2 = 8<br>
ID 3 : 100 - 100 = 0<br><br>
ID 4 : 100 - 10 = 90<br>
ID 5 : 100 - 17 = 83<br>
ID 6 : 101 -101 - 0</p>

<p>이를 분화된 연도에 대해 오름차순으로 정렬하고 같은 연도에 대해서는 대장균 크기의 편차에 대해 오름차순으로 정렬하면 결과는 다음과 같아야 합니다.</p>
<table class="table">
        <thead><tr>
<th>YEAR</th>
<th>YEAR_DEV</th>
<th>ID</th>
</tr>
</thead>
        <tbody><tr>
<td>2019</td>
<td>0</td>
<td>1</td>
</tr>
<tr>
<td>2019</td>
<td>8</td>
<td>2</td>
</tr>
<tr>
<td>2020</td>
<td>0</td>
<td>3</td>
</tr>
<tr>
<td>2020</td>
<td>83</td>
<td>5</td>
</tr>
<tr>
<td>2020</td>
<td>90</td>
<td>4</td>
</tr>
<tr>
<td>2021</td>
<td>0</td>
<td>6</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges