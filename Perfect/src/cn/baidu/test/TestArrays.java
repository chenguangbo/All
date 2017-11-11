package cn.baidu.test;

import java.util.Arrays;

//Arrays
public class TestArrays {

	public static void main(String[] args) {
	
		int[] arr = {1,3,57,9};
		Arrays.sort(arr);//排序
		int search = Arrays.binarySearch(arr, 3);//二分查找
		
		System.out.println(search);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	
}
