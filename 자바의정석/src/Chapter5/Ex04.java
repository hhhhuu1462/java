package Chapter5;

import javax.servlet.http.HttpServletRequest

public class Ex04 {
	public static void main(String[] args) {
		// 2李⑥썝 諛곗뿴 arr�뿉 �떞湲� 紐⑤뱺 媛믪쓽 珥앺빀怨� �룊洹�
		int[][] arr = {
				{ 5, 5, 5, 5, 5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};

		int total = 0;
		float average = 0;

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				count++;
			}
		}
		average = (float)total / count;

		System.out.println("total="+total);
		System.out.println("average="+average);
	}
}
