package argorithm;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class OAmazon {
	@Test
	public void fizzBuzzz() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("fizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("fizz");
			} else if (i % 5 == 0) {

				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	public static boolean atLeastTwo(boolean a, boolean b, boolean c) {
		return a ? (b || c) : (b && c);
	}

	// String reverse;
	public String reverse(String s) {
		if (s.isEmpty()) {
			return s;
		}
		int length = s.length();
		char temp = 0;
		String result = "";
		char[] c = s.toCharArray();
		for (int i = 0, j = length - 1; i < j; i++, j--) {
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		result = String.valueOf(c);
		return result;
	}

	public String reviserStringBuilder(String s) {
		if (s.isEmpty()) {
			return s;
		}
		StringBuilder sb = new StringBuilder(100);
		char[] c = s.toCharArray();
		for (int i = c.length - 1; i >= 0; i--) {
			sb.append(c[i]);
		}
		return sb.toString();
	}

	public boolean isUniqueString(String s) {
		if (s.isEmpty()) {
			return false;
		}
		char[] c = s.toCharArray();
		Set cSet = new HashSet();
		for (int i = 0; i < c.length; i++) {
			if (cSet.contains(c[i])) {
				return false;
			} else {
				cSet.add(c[i]);
			}
		}
		return true;
	}

	// Word order reversal
	/**
	 * Question: Given a string that contains words separated by spaces, write a
	 * function that reverses the order of the words.
	 */
	public String reverseWords(String str) {
		System.out.println(str.length());

		if (str.isEmpty()) {
			return "";
		}

		char[] c = str.toCharArray();
		reverseWords(c, 0, c.length - 1);
		int start = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				reverseWords(c, start, i - 1);
				start = i + 1;
			}
		}
		// if last char is not '', still need to reverse
		reverseWords(c, start, c.length - 1);

		return String.valueOf(c);
	}

	/**
	 * from min to Max, reverse all
	 * 
	 * @param str
	 * @param min
	 * @param max
	 */
	private void reverseWords(char[] c, int min, int max) {
		char temp = 0;
		for (int i = min, j = max; i < j; i++, j--) {
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
	}

	// String to integer
	/**
	 * Dynamic Programming
	 * Given an integer represented as a string, write a function to convert it
	 * to an integer.
	 */
	public int longestPublicSubString(String s1, String s2) {
		int length = 0;
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		int max = 0;
		int[][] memorized = new int[l1][l2];
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i == 0 || j == 0) {
						memorized[i][j] = 1;
					} else {
						memorized[i][j] = memorized[i - 1][j - 1] + 1;
					}
					if (memorized[i][j] > max) {
						max = memorized[i][j];
					}
				}
			}
		}
		return max;

	}

	@Test
	public void reverseTest() {
		String a = "12345678a hello world han hui ";
		// System.out.println(reverse(a));
		//
		// System.out.println(reviserStringBuilder(a));
		// System.out.println(isUniqueString(a));
		//System.out.println(reverseWords(a));
		System.out.println(longestPublicSubString("1hanhui345","hanhui000"));

	}
}
