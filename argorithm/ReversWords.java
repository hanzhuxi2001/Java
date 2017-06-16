package argorithm;

import java.util.Arrays;

public class ReversWords {
	public static void main(String[] args) {
		char[] chars = new String("How old are you !? I don't understand").toCharArray();
		System.out.println("the first:");
		System.out.println(chars);

		reverseWords2(chars); // 主要方法

		System.out.println("the second:");
		System.out.println(chars);
	}

	/**
	 * 会将数组里面的单词 倒序排列 例如 how old are you -> you are old how
	 * 
	 * @param chars
	 */
	public static void reverseWords(char[] chars) {
		reverseChars(chars, 0, chars.length - 1);
		int begin = -1;
		int end = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '\'') { // 简单的判断了一下是否是连续的单词
				if (begin == -1) {
					begin = i;
					end = i;
				} else {
					end = i;
					if (i == chars.length - 1) {
						reverseChars(chars, begin, end);
					}
				}
			} else {
				if (begin != -1) {
					reverseChars(chars, begin, end);
					begin = -1;
					end = 0;
				}
			}
		}
	}

	public static void reverseWords2(char[] chars) {
		reverseChars(chars, 0, chars.length - 1);
		int begin = 0;
		int end = 0;
		labelA:
		for (int i = 0; i < chars.length; i++) {
			for (int j = i ; j < chars.length; j++) {
				char c = chars[j];
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '\'') { // 简单的判断了一下是否是连续的单词
					begin=i;
					end=j;
					if(j==chars.length-1){
						System.out.println(Arrays.toString(chars));
						System.out.println(begin+":"+end);
						reverseChars(chars, begin, end);
						break labelA;
					}
				}else{
					begin = i;
					end = j-1;
					reverseChars(chars, begin, end);
					i=j;
					break;
				}
			}

		}
	}

	/**
	 * 将char 一定范围内的 字符 倒序排列 例如 hello -> olleh
	 * 
	 * @param chars
	 *            数组
	 * @param begin
	 *            开始位置
	 * @param end
	 *            结束位置
	 */
	public static void reverseChars(char[] chars, int begin, int end) {
		char temp = 0;
		while (begin < end) {
			temp = chars[begin];
			chars[begin] = chars[end];
			chars[end] = temp;
			begin++;
			end--;
		}
	}
}
