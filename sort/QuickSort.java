package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] input = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15,
				35, 25, 53 };
		// qsort(input);
		sort1(input);
		System.out.println(Arrays.toString(input));
	}

	private static void qsort(int[] input) {
		int length = input.length;
		if (length > 0) {
			quickSort(input, 0, length - 1);

		}
	}

	private static void quickSort(int[] input, int l, int r) {
		if (l < r) {
			int mid = getPivot(input, l, r);
			quickSort(input, l, mid - 1);
			quickSort(input, mid + 1, r);

		}

	}

	private static int getPivot(int[] input, int l, int r) {
		int temp = input[l];
		while (l < r) {
			while (l < r && temp <= input[r]) {
				r--;
			}
			if (l < r) {
				input[l] = input[r];
				l++;
			}

			while (l < r && temp > input[l]) {
				l++;
			}
			if (l < r) {
				input[r] = input[l];
				r--;
			}

		}
		input[l] = temp;

		return l;
	}

	static int AdjustArray(int s[], int l, int r) // 返回调整后基准数的位置
	{
		int i = l, j = r;
		int x = s[l]; // s[l]即s[i]就是第一个坑
		while (i < j) {
			// 从右向左找小于x的数来填s[i]
			while (i < j && s[j] >= x)
				j--;
			if (i < j) {
				s[i] = s[j]; // 将s[j]填到s[i]中，s[j]就形成了一个新的坑
				i++;
			}

			// 从左向右找大于或等于x的数来填s[j]
			while (i < j && s[i] < x)
				i++;
			if (i < j) {
				s[j] = s[i]; // 将s[i]填到s[j]中，s[i]就形成了一个新的坑
				j--;
			}
		}
		// 退出时，i等于j。将x填到这个坑中。
		s[i] = x;

		return i;
	}

	public static void sort1(int[] input) {
		int length=input.length;
		
		if(length>0){
			quickSort1(input,0,length-1);
		}

	}

	private static void quickSort1(int[] input, int l, int r) {
		if(l<r){
			int pivot=getPivot1(input,l,r);
			quickSort1(input,l,pivot-1);
			quickSort1(input,pivot+1,r);
		}
		
	}

	private static int getPivot1(int[] input, int l, int r) {
		int pivot=input[l];
		while(l<r){
			while(l<r&&pivot<input[r]){
				r--;
			}
			if(l<r){
				input[l]=input[r];
				l++;
			}
			while(l<r&&pivot>input[l]){
				l++;
				
			}
			
			if(l<r){
				input[r]=input[l];
				r--;
			}
			input[l]=pivot;
		}
		return l;
	}

	

}
