package sort;

import java.util.Arrays;

public class SelectSort {

	public static int[] sort(int[] input) {
		int length = input.length;
		int temp = 0;
		int minIndex = 0;
		for (int i = 0; i < length - 1; i++) {
			minIndex = i;
			// j is just from the i+1, but still need to compare till end.
			for (int j = i + 1; j < length; j++) {
				if (input[minIndex] > input[j]) {
					minIndex = j;
				}
			}
			temp = input[i];
			input[i] = input[minIndex];
			input[minIndex] = temp;
		}

		return input;

	}

	public static int[] sort2(int[] input) {
		int length = 0;
		int minIndex = 0;
		int temp = 0;
		for (int i = 0; i < length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (input[minIndex] > input[j]) {
					minIndex = j;
				}
			}
			temp = input[i];
			input[i] = input[minIndex];
			input[minIndex] = temp;
		}

		return input;
	}

	public static void main(String[] args) {
		int[] input = { 4, 6, 2, 1, 10, 10, 20, 11, 9, -1 };
		int outPut[] = sort(input);
		System.out.println(Arrays.toString(outPut));

	}

}
