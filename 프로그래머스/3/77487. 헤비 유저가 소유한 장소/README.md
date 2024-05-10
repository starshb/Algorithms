# [level 3] 헤비 유저가 소유한 장소 - 77487 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/77487) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > 2021 Dev－Matching： 웹 백엔드 개발자（상반기）

### 채점결과

Empty

### 제출 일자

2024년 05월 10일 20:56:10

### 문제 설명

<p><code>PLACES</code> 테이블은 공간 임대 서비스에 등록된 공간의 정보를 담은 테이블입니다. <code>PLACES</code> 테이블의 구조는 다음과 같으며 <code>ID</code>, <code>NAME</code>, <code>HOST_ID</code>는 각각 공간의 아이디, 이름, 공간을 소유한 유저의 아이디를 나타냅니다. <code>ID</code>는 기본키입니다.</p>
<table class="table">
        <thead><tr>
<th>NAME</th>
<th>TYPE</th>
</tr>
</thead>
        <tbody><tr>
<td>ID</td>
<td>INT</td>
</tr>
<tr>
<td>NAME</td>
<td>VARCHAR</td>
</tr>
<tr>
<td>HOST_ID</td>
<td>INT</td>
</tr>
</tbody>
      </table>
<h5>문제</h5>

<p>이 서비스에서는 공간을 둘 이상 등록한 사람을 "헤비 유저"라고 부릅니다. 헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회하는 SQL문을 작성해주세요.</p>

<h5>예시</h5>

<p>예를 들어, <code>PLACES</code> 테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th>ID</th>
<th>NAME</th>
<th>HOST_ID</th>
</tr>
</thead>
        <tbody><tr>
<td>4431977</td>
<td>BOUTIQUE STAYS - Somerset Terrace, Pet Friendly</td>
<td>760849</td>
</tr>
<tr>
<td>5194998</td>
<td>BOUTIQUE STAYS - Elwood Beaches 3, Pet Friendly</td>
<td>760849</td>
</tr>
<tr>
<td>16045624</td>
<td>Urban Jungle in the Heart of Melbourne</td>
<td>30900122</td>
</tr>
<tr>
<td>17810814</td>
<td>Stylish Bayside Retreat with a Luscious Garden</td>
<td>760849</td>
</tr>
<tr>
<td>22740286</td>
<td>FREE PARKING - The Velvet Lux in Melbourne CBD</td>
<td>30900122</td>
</tr>
<tr>
<td>22868779</td>
<td>★ Fresh Fitzroy Pad with City Views! ★</td>
<td>21058208</td>
</tr>
</tbody>
      </table>
<ul>
<li>760849번 유저는 공간을 3개 등록했으므로 이 유저는 헤비유저입니다. </li>
<li>30900122번 유저는 공간을 2개 등록했으므로 이 유저는 헤비유저입니다.</li>
<li>21058208번 유저는 공간을 1개 등록했으므로 이 유저는 헤비유저가 아닙니다.</li>
</ul>

<p>따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다.</p>
<table class="table">
        <thead><tr>
<th>ID</th>
<th>NAME</th>
<th>HOST_ID</th>
</tr>
</thead>
        <tbody><tr>
<td>4431977</td>
<td>BOUTIQUE STAYS - Somerset Terrace, Pet Friendly</td>
<td>760849</td>
</tr>
<tr>
<td>5194998</td>
<td>BOUTIQUE STAYS - Elwood Beaches 3, Pet Friendly</td>
<td>760849</td>
</tr>
<tr>
<td>16045624</td>
<td>Urban Jungle in the Heart of Melbourne</td>
<td>30900122</td>
</tr>
<tr>
<td>17810814</td>
<td>Stylish Bayside Retreat with a Luscious Garden</td>
<td>760849</td>
</tr>
<tr>
<td>22740286</td>
<td>FREE PARKING - The Velvet Lux in Melbourne CBD</td>
<td>30900122</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges