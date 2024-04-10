# [level 2] 노선별 평균 역 사이 거리 조회하기 - 284531 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284531) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 04월 11일 00:01:52

### 문제 설명

<p><code>SUBWAY_DISTANCE</code> 테이블은 서울지하철 2호선의 역 간 거리 정보를 담은 테이블입니다. <code>SUBWAY_DISTANCE</code> 테이블의 구조는 다음과 같으며 <code>LINE</code>, <code>NO</code>, <code>ROUTE</code>, <code>STATION_NAME</code>, <code>D_BETWEEN_DIST</code>, <code>D_CUMULATIVE</code>는 각각 호선, 순번, 노선, 역 이름, 역 사이 거리, 노선별 누계 거리를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>LINE</td>
<td>VARCHAR(10)</td>
<td>FALSE</td>
</tr>
<tr>
<td>NO</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
<tr>
<td>ROUTE</td>
<td>VARCHAR(50)</td>
<td>FALSE</td>
</tr>
<tr>
<td>STATION_NAME</td>
<td>VARCHAR(100)</td>
<td>FLASE</td>
</tr>
<tr>
<td>D_BETWEEN_DIST</td>
<td>NUMBER</td>
<td>FLASE</td>
</tr>
<tr>
<td>D_CUMULATIVE</td>
<td>NUMBER</td>
<td>FLASE</td>
</tr>
</tbody>
      </table>
<hr>

<h5>문제</h5>

<p><code>SUBWAY_DISTANCE</code> 테이블에서 노선별로 노선, 총 누계 거리, 평균 역 사이 거리를 노선별로 조회하는 SQL문을 작성해주세요.</p>

<p>총 누계거리는 테이블 내 존재하는 역들의 <code>역 사이 거리</code>의 총 합을 뜻합니다. 총 누계 거리와 평균 역 사이 거리의 컬럼명은 각각 <code>TOTAL_DISTANCE</code>, <code>AVERAGE_DISTANCE</code>로 해주시고, 총 누계거리는 소수 둘째자리에서, 평균 역 사이 거리는 소수 셋째 자리에서 반올림 한 뒤 단위(km)를 함께 출력해주세요.<br>
결과는 총 누계 거리를 기준으로 내림차순 정렬해주세요.</p>

<hr>

<h5>예시</h5>

<p><code>SUBWAY_DISTANCE</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th>LINE</th>
<th>NO</th>
<th>ROUTE</th>
<th>STATION_NAME</th>
<th>D_BETWEEN_DIST</th>
<th>D_CUMULATIVE</th>
</tr>
</thead>
        <tbody><tr>
<td>2호선</td>
<td>45</td>
<td>성수지선</td>
<td>용답</td>
<td>2.3</td>
<td>51.1</td>
</tr>
<tr>
<td>2호선</td>
<td>46</td>
<td>성수지선</td>
<td>신답</td>
<td>1</td>
<td>52.1</td>
</tr>
<tr>
<td>2호선</td>
<td>47</td>
<td>성수지선</td>
<td>용두(동대문구청)</td>
<td>0.9</td>
<td>53</td>
</tr>
<tr>
<td>2호선</td>
<td>48</td>
<td>성수지선</td>
<td>신설동</td>
<td>1.2</td>
<td>54.2</td>
</tr>
<tr>
<td>2호선</td>
<td>49</td>
<td>신정지선</td>
<td>도림천</td>
<td>1</td>
<td>55.2</td>
</tr>
<tr>
<td>2호선</td>
<td>50</td>
<td>신정지선</td>
<td>양천구청</td>
<td>1.7</td>
<td>56.9</td>
</tr>
<tr>
<td>2호선</td>
<td>51</td>
<td>신정지선</td>
<td>신정네거리</td>
<td>1.9</td>
<td>58.8</td>
</tr>
<tr>
<td>2호선</td>
<td>52</td>
<td>신정지선</td>
<td>까치산</td>
<td>1.4</td>
<td>60.2</td>
</tr>
</tbody>
      </table>
<p>SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th>ROUTE</th>
<th>TOTAL_DISTANCE</th>
<th>AVERAGE_DISTANCE</th>
</tr>
</thead>
        <tbody><tr>
<td>신정지선</td>
<td>6km</td>
<td>1.5km</td>
</tr>
<tr>
<td>성수지선</td>
<td>5.4km</td>
<td>1.35km</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges