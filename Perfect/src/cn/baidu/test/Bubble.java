package cn.baidu.test;

import java.util.Arrays;

public class Bubble {

	// 冒泡排序
	public static void main(String[] args) {

		int[] arr = { 3, 6, 1, 8 };
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[i] > arr[j]) {
					int y = 0;
					y = arr[i];
					arr[i] = arr[j];
					arr[j] = y;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}
