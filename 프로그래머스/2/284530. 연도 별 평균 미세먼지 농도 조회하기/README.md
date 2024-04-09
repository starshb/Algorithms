# [level 2] 연도 별 평균 미세먼지 농도 조회하기 - 284530 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284530) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > String， Date

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 04월 10일 00:11:34

### 문제 설명

<p><code>AIR_POLLUTION</code> 테이블은 전국의 월별 미세먼지 정보를 담은 테이블입니다. <code>AIR_POLLUTION</code> 테이블의 구조는 다음과 같으며 <code>LOCATION1</code>, <code>LOCATION2</code>, <code>YM</code>, <code>PM_VAL1</code>, <code>PM_VAL2</code>은 각각 지역구분1, 지역구분2, 측정일, 미세먼지 오염도, 초미세먼지 오염도를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>LOCATION1</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>LOCATION2</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>YM</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>PM_VAL1</td>
<td>NUMBER</td>
<td>FLASE</td>
</tr>
<tr>
<td>PM_VAL2</td>
<td>NUMBER</td>
<td>FLASE</td>
</tr>
</tbody>
      </table>
<hr>

<h5>문제</h5>

<p><code>AIR_POLLUTION</code> 테이블에서 수원 지역의 연도 별 평균 미세먼지 오염도와 평균 초미세먼지 오염도를 조회하는 SQL문을 작성해주세요. 이때, 평균 미세먼지 오염도와 평균 초미세먼지 오염도의 컬럼명은 각각 <code>PM10</code>, <code>PM2.5</code>로 해 주시고, 값은 소수 셋째 자리에서 반올림해주세요.<br>
결과는 연도를 기준으로 오름차순 정렬해주세요.</p>

<hr>

<h5>예시</h5>

<p><code>AIR_POLLUTION</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th>LOCATION1</th>
<th>LOCATION2</th>
<th>YM</th>
<th>PM_VAL1</th>
<th>PM_VAL2</th>
</tr>
</thead>
        <tbody><tr>
<td>경기도</td>
<td>수원</td>
<td>2018-01-01</td>
<td>48</td>
<td>27</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-02-01</td>
<td>51</td>
<td>30</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-03-01</td>
<td>52</td>
<td>21</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-04-01</td>
<td>52</td>
<td>20</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-05-01</td>
<td>45</td>
<td>19</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-06-01</td>
<td>39</td>
<td>17</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-07-01</td>
<td>27</td>
<td>15</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-08-01</td>
<td>26</td>
<td>16</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-09-01</td>
<td>21</td>
<td>12</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-10-01</td>
<td>31</td>
<td>18</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-11-01</td>
<td>56</td>
<td>21</td>
</tr>
<tr>
<td>경기도</td>
<td>수원</td>
<td>2018-12-01</td>
<td>44</td>
<td>27</td>
</tr>
<tr>
<td>서울시</td>
<td>노원</td>
<td>2018-11-01</td>
<td>25</td>
<td>45</td>
</tr>
<tr>
<td>경기도</td>
<td>용인</td>
<td>2018-02-01</td>
<td>14</td>
<td>21</td>
</tr>
</tbody>
      </table>
<p>SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th>YEAR</th>
<th>PM10</th>
<th>PM2.5</th>
</tr>
</thead>
        <tbody><tr>
<td>2018</td>
<td>41</td>
<td>20.25</td>
</tr>
</tbody>
      </table>
<hr>

<p>※ 공지 - 2023년 3월 4일 문제 오탈자가 수정되었습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges