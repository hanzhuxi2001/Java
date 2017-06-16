package sort;

import java.util.Arrays;

public class bubbleSort {
	static int count = 0;

	public static int[] sort(int[] input) {
		int length = input.length;
		int temp = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				temp = input[j];
				if (input[j] > input[j + 1]) {
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}

		return input;

	}

	// length-1 because, this is from biggest till small, if last, then it
	// already the smallest one.
	public static int[] sort2(int[] input) {
		int length = input.length;
		int temp = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (input[j] > input[j + 1]) {
					temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}

		return input;
	}

	public static void main(String[] args) {
		int[] input = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15,
				35, 25, 53 };
		// String[] input2 = { "4", "6" };

		int outPut[] = sort2(input);
		System.out.println(Arrays.toString(outPut));
		System.out.println(count);

		// main(input);
		// main(input2);

	}

	public static void main(int[] args) {
		System.out.println("sdadadas");

	}

}
