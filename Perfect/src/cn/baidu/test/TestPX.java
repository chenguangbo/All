package cn.baidu.test;

import java.util.Arrays;

public class TestPX {

	//排序算法
	//小的向前  大的向后
	public static void main(String[] args) {

		int[] arr={1,4,3,9};
		//外层控制循环次数
		for(int i=0;i<arr.length-1;i++){
			//内层控制比较的元素
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int y = 0;
					y = arr[i];
					arr[i] = arr[j];
					arr[j] = y;
				}
			}
		}
		System.err.println(Arrays.toString(arr));
		
	}

}
