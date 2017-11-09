package cn.baidu.BubbleSort;

import java.util.Arrays;

/*
 * 冒泡排序
 */
public class BubbleSort {

	public static void main(String[] args) {

		
		int[] arr = { 10 , 30 , 5 , 17};
		sort(arr);
		
	}

	public static void sort(int[] arr){
		
	    //外层循环控制
					//为什么是arr.length-1      因为最后一次不用比较
		for(int i = 0 ;i<arr.length-1;i++){
			
			//内层控制比较的元素                                                             比完第一次最大的就到最后了所以最后一次就不用比较了
			                                       //减I是因为每一次比较都会有一个大的到最后        下一次比较就不用比了  每次都减少一个  而i恰好每次增加一所以直接减I
						    //为什么是arr-1-i   减一是因为每次都不用比较最后一个元素
			for(int j = 0 ; j < arr.length-1-i ; j++){
				if(arr[j]>arr[j+1]){
					int y = 0;
					y = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] =y;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
