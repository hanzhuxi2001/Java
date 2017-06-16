package sort;

import java.util.Arrays;

public class InsetSort {

	static int count = 0;

	public static int[] sort(int[] input) {
		int length = input.length;
		int current = 0;
		for (int i = 0; i < length - 1; i++) {
			current = input[i + 1];
			int j = i;
			for (; j >= 0; j--) {
				if (current < input[j]) {
					input[j + 1] = input[j];
				} else {
					break;
				}

			}
			input[j + 1] = current;
		}
		return input;
	}

	/**
	 * the current is from 1, that is i+1, so the last out look will be length
	 * -2
	 * 
	 * @param a
	 * @return
	 */
	public static int[] sort2(int[] a) {
		int length = a.length;
		int current = 0;
		for (int i = 0; i < length - 1; i++) {
			current = a[i + 1];
			int j = i;
			for (; j >= 0; j--) {
				if (current < a[j]) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			a[j + 1] = current;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] input = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15,
				35, 25, 53 };
		// String[] input2 = { "4", "6" };

		int outPut[] = sort2(input);
		System.out.println(Arrays.toString(outPut));
		System.out.println(count);
		// main(input2);

	}

	public static void main(int[] args) {
		System.out.println("sdadadas");

	}

}
