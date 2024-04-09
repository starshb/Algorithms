# [level 2] 조건에 맞는 사원 정보 조회하기 - 284527 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284527) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 04월 09일 17:16:41

### 문제 설명

<p><code>HR_DEPARTMENT</code> 테이블은 회사의 부서 정보를 담은 테이블입니다. <code>HR_DEPARTMENT</code> 테이블의 구조는 다음과 같으며 <code>DEPT_ID</code>, <code>DEPT_NAME_KR</code>, <code>DEPT_NAME_EN</code>, <code>LOCATION</code>은 각각 부서 ID, 국문 부서명, 영문 부서명, 부서 위치를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>DEPT_ID</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>DEPT_NAME_KR</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>DEPT_NAME_EN</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>LOCATION</td>
<td>VARCHAR</td>
<td>FLASE</td>
</tr>
</tbody>
      </table>
<p><code>HR_EMPLOYEES</code> 테이블은 회사의 사원 정보를 담은 테이블입니다. <code>HR_EMPLOYEES</code> 테이블의 구조는 다음과 같으며 <code>EMP_NO</code>, <code>EMP_NAME</code>, <code>DEPT_ID</code>, <code>POSITION</code>, <code>EMAIL</code>, <code>COMP_TEL</code>, <code>HIRE_DATE</code>, <code>SAL</code>은 각각 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉을 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>EMP_NO</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>EMP_NAME</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>DEPT_ID</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>POSITION</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>EMAIL</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>COMP_TEL</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>HIRE_DATE</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
<tr>
<td>SAL</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p><code>HR_GRADE</code> 테이블은 2022년 사원의 평가 정보를 담은 테이블입니다. <code>HR_GRADE</code>의 구조는 다음과 같으며 <code>EMP_NO</code>, <code>YEAR</code>, <code>HALF_YEAR</code>, <code>SCORE</code>는 각각 사번, 연도, 반기, 평가 점수를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>EMP_NO</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
<tr>
<td>YEAR</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
<tr>
<td>HALF_YEAR</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
<tr>
<td>SCORE</td>
<td>NUMBER</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<hr>

<h5>문제</h5>

<p><code>HR_DEPARTMENT</code>, <code>HR_EMPLOYEES</code>, <code>HR_GRADE</code> 테이블에서 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회하려 합니다. 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일을 조회하는 SQL문을 작성해주세요.</p>

<p>2022년도의 평가 점수는 상,하반기 점수의 합을 의미하고, 평가 점수를 나타내는 컬럼의 이름은 <code>SCORE</code>로 해주세요.</p>

<hr>

<h5>예시</h5>

<p>예를 들어 <code>HR_DEPARTMENT</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th>DEPT_ID</th>
<th>DEPT_NAME_KR</th>
<th>DEPT_NAME_EN</th>
<th>LOCATION</th>
</tr>
</thead>
        <tbody><tr>
<td>D0001</td>
<td>법무팀</td>
<td>Law Dep</td>
<td>그렙타워 4층</td>
</tr>
<tr>
<td>D0002</td>
<td>인사팀</td>
<td>Human resources</td>
<td>그렙타워 4층</td>
</tr>
<tr>
<td>D0003</td>
<td>총무팀</td>
<td>General Affairs</td>
<td>그렙타워 4층</td>
</tr>
</tbody>
      </table>
<p><code>HR_EMPLOYEES</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th>EMP_NO</th>
<th>EMP_NAME</th>
<th>DEPT_ID</th>
<th>POSITION</th>
<th>EMAIL</th>
<th>COMP_TEL</th>
<th>HIRE_DATE</th>
<th>SAL</th>
</tr>
</thead>
        <tbody><tr>
<td>2017002</td>
<td>정호식</td>
<td>D0001</td>
<td>팀장</td>
<td><a href="mailto:hosick_jung@grepp.com" target="_blank" rel="noopener">hosick_jung@grepp.com</a></td>
<td>031-8000-1101</td>
<td>2017-03-01</td>
<td>65000000</td>
</tr>
<tr>
<td>2018001</td>
<td>김민석</td>
<td>D0001</td>
<td>팀원</td>
<td><a href="mailto:minseock_kim@grepp.com" target="_blank" rel="noopener">minseock_kim@grepp.com</a></td>
<td>031-8000-1102</td>
<td>2018-03-01</td>
<td>60000000</td>
</tr>
<tr>
<td>2019001</td>
<td>김솜이</td>
<td>D0002</td>
<td>팀장</td>
<td><a href="mailto:somi_kim@grepp.com" target="_blank" rel="noopener">somi_kim@grepp.com</a></td>
<td>031-8000-1106</td>
<td>2019-03-01</td>
<td>60000000</td>
</tr>
<tr>
<td>2020002</td>
<td>김연주</td>
<td>D0002</td>
<td>팀원</td>
<td><a href="mailto:yeonjoo_kim@grepp.com" target="_blank" rel="noopener">yeonjoo_kim@grepp.com</a></td>
<td>031-8000-1107</td>
<td>2020-03-01</td>
<td>53000000</td>
</tr>
<tr>
<td>2020005</td>
<td>양성태</td>
<td>D0003</td>
<td>팀원</td>
<td><a href="mailto:sungtae_yang@grepp.com" target="_blank" rel="noopener">sungtae_yang@grepp.com</a></td>
<td>031-8000-1112</td>
<td>2020-03-01</td>
<td>53000000</td>
</tr>
</tbody>
      </table>
<p><code>HR_GRADE</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th>EMP_NO</th>
<th>YEAR</th>
<th>HALF_YEAR</th>
<th>SCORE</th>
</tr>
</thead>
        <tbody><tr>
<td>2017002</td>
<td>2022</td>
<td>1</td>
<td>92</td>
</tr>
<tr>
<td>2018001</td>
<td>2022</td>
<td>1</td>
<td>89</td>
</tr>
<tr>
<td>2019001</td>
<td>2022</td>
<td>1</td>
<td>94</td>
</tr>
<tr>
<td>2020002</td>
<td>2022</td>
<td>1</td>
<td>90</td>
</tr>
<tr>
<td>2020005</td>
<td>2022</td>
<td>1</td>
<td>92</td>
</tr>
<tr>
<td>2017002</td>
<td>2022</td>
<td>2</td>
<td>84</td>
</tr>
<tr>
<td>2018001</td>
<td>2022</td>
<td>2</td>
<td>89</td>
</tr>
<tr>
<td>2019001</td>
<td>2022</td>
<td>2</td>
<td>81</td>
</tr>
<tr>
<td>2020002</td>
<td>2022</td>
<td>2</td>
<td>91</td>
</tr>
<tr>
<td>2020005</td>
<td>2022</td>
<td>2</td>
<td>81</td>
</tr>
</tbody>
      </table>
<p>다음과 같이 평가 점수가 가장 높은 사원 정보를 출력해야 합니다.</p>
<table class="table">
        <thead><tr>
<th>SCORE</th>
<th>EMP_NO</th>
<th>EMP_NAME</th>
<th>POSITION</th>
<th>EMAIL</th>
</tr>
</thead>
        <tbody><tr>
<td>181</td>
<td>202002</td>
<td>김연주</td>
<td>팀원</td>
<td><a href="mailto:yeonjoo_kim@grepp.com" target="_blank" rel="noopener">yeonjoo_kim@grepp.com</a></td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges