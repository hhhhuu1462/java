package Chapter6;

import java.util.Arrays;

/*
메서드명 : shuffle
기능 : 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다. 
		처리한 배열을 반환한다.
반환타입 : int[]
매개변수 : 정수값이 담긴 배열
 */

public class Ex20 {
	
	public static int[] shuffle(int[] arr) {
		// 넘겨받은 배열이 null이거나 크기가 0이면 그대로 반환
		if (arr == null || arr.length == 0) {
			return arr;
		}
		
		// 반복문을 통해 배열의 임의의 두 요소의 값을 바꾼다.
		for (int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * arr.length);
			
			// arr[i]와 arr[j]의 값을 서로 바꾼다
			int tmp = arr[i];
			arr[i] = arr[random];
			arr[random] = tmp;
		}
		
		return arr;		
	}

	public static void main(String[] args) {

		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
		
	}

}
