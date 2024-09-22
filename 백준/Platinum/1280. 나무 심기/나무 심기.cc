#include<iostream>

using namespace std;
//범위가 20만이므로 20만보다 큰 2^18이 리프노드의 갯수이므로 2 ^19로 잡음
//나무의 좌표 구간 합 저장용 세그먼트 트리
long long segSumTree[524288];
//나무의 갯수 구간 합 저장용 세그먼트 
int segCntTree[524288];
int N, firstLeafNodeIdx= 524288 / 2;
//모듈러
const int Modular = 1'000'000'007;

int FindCntValueInTargetRange(int targetL, int targetR, int nodeNum, int curL, int curR) {
	if (targetR < curL || curR < targetL) return 0;
	if (targetL <= curL && curR <= targetR) return segCntTree[nodeNum];
	int mid = (curL + curR) / 2;
	return FindCntValueInTargetRange(targetL, targetR, nodeNum*2, curL, mid) + 
		FindCntValueInTargetRange(targetL, targetR, nodeNum*2+1, mid + 1, curR);
}
long long FindSumValueInTargetRange(int targetL, int targetR, int nodeNum, int curL, int curR) {
	if (curR < targetL || targetR < curL) return 0;
	if (targetL <= curL && curR <= targetR) return segSumTree[nodeNum];

	int mid = (curL + curR) / 2;
	return FindSumValueInTargetRange(targetL, targetR, nodeNum*2, curL, mid) + 
		FindSumValueInTargetRange(targetL, targetR, nodeNum*2+1, mid + 1, curR);
}


void SetAnscestorNode(int n, int k) {
	int tmpIdx = firstLeafNodeIdx + n;
	//같은 자리에 나무가 심어질 수 있으므로 += 연산자 사용
	segCntTree[tmpIdx]++;
	segSumTree[tmpIdx] += k;
	while (tmpIdx > 1) {
		tmpIdx /= 2;
		segCntTree[tmpIdx] = segCntTree[tmpIdx * 2] + segCntTree[tmpIdx * 2 + 1];
		segSumTree[tmpIdx] = segSumTree[tmpIdx * 2] + segSumTree[tmpIdx * 2 + 1];
	}
}

//원래는 리프노드 개수를 N에 비례해서 맞췄는데 이건 리프노드가 저장하는 값이 해당 좌표이다,\
이전 좌표에 나무를 또 박을 수 있어서 리프노드 인덱스와 값을 좌표로 둘다 설정해야하는데\
 N에 비례해서 해버리면 N이 5인데 좌표가 20만일때 처리가 불가능하다. 
void Input() {
	int tmp = 0;
	//Ans값을 0으로 초기화해버리니 답이 걍 계속 0나옴
	int Ans = 1;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		//0번째 값은 비용계산 안하고 세그먼트트리에만 집어넣기
		if (i == 0) {
			SetAnscestorNode(tmp, tmp);
			continue;
		}

		//0~i로 범위를 설정했었는데 tmp값이 이전에 나온값이 나올수도있으므로 범위도 0~tmp로 조정해야함
		long long left = 1LL*(tmp) * FindCntValueInTargetRange(0, tmp, 1, 0, firstLeafNodeIdx )
			- FindSumValueInTargetRange(0, tmp, 1, 0, firstLeafNodeIdx);

		//범위를 tmp+1부터 N-1까지 했었는데 리프노드 갯수 20만개로 하기로 해서 tmp+1에서 20만으로 
		long long right = FindSumValueInTargetRange(tmp+1, 200'000, 1, 0, firstLeafNodeIdx)
			- 1LL*FindCntValueInTargetRange(tmp+1, 200'000, 1, 0, firstLeafNodeIdx ) * (tmp);

		Ans = (right+left) % Modular * Ans % Modular;
		// (i,tmp)로 인덱스순서대로 지정해줬는데 생각해보니 이전값이 나올수도있으므로 걍 tmp로 해야함
		SetAnscestorNode(tmp, tmp);
	}
	cout << Ans;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	Input();
}