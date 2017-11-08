package cn.baidu.algorithm;

import java.util.Arrays;

/*
 * 			选择排序 
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 2 , 3 , 1 , 4 };
		select(arr);
		systemSelect(arr);
	}
	
	public static void select(int[] arr){
		
		int y = 0;
		//外层控制循环次数
		              //外层循环小于数字最大长度减一
		              //为什么是arr.length-1        因为是所有元素进行比较      最后一次只剩下     自身一个  就不用比较了   所以减一
		for(int i=0; i<arr.length-1;i++){
		//内层控制比较的元素
					  //为什么是i+1                            因为内层循环控制的是每次比较的元素        只要从被比较的数组的下一位开始       
			          //为什么是arr.length    因为内层循环控制的是每次比较的元素        只有小于数组的最大长的才能比较到每一位
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					y = arr[j];
					arr[j] = arr[i];
					arr[i] = y;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void systemSelect(int[] arr){
		Arrays.sort(arr);
		System.err.println(Arrays.toString(arr));
		
	}
	
}
