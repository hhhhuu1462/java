package Chapter5;

public class Ex11 {
	// 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성
	// 그 배열의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력

	public static void main(String[] args) {

		int[][] score = {
				{100, 100, 100}
				, {20, 20, 20}
				, {30, 30, 30}
				, {40, 40, 40}
				, {50, 50, 50}
		};
		
		int[][] result = new int[score.length+1][score[0].length+1];
		
		for(int i=0; i < score.length;i++) {
			for(int j=0; j < score[i].length;j++) {
				result[i][j] = score[i][j];
				result[i][score[0].length] += result[i][j]; // 각 행 추가 된 마지막 열 : 각 행의 값 합계
				result[score.length][j] += result[i][j]; // 각 열 추가된 마지막 행 : 각 열의 값 합계
				result[score.length][score[0].length] += result[i][j]; // 추가된 마지막 행 마지막 열 : 마지막 행 모든 값의 합

			}
		}
		
		for(int i=0; i < result.length;i++) {
			for(int j=0; j < result[i].length;j++) {
				System.out.printf("%4d",result[i][j]);
			}
			System.out.println();
		}


	}

}
