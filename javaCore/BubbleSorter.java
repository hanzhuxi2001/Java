package javaCore;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 冒泡排序
 * 
 * @author骆昊
 *
 */
public class BubbleSorter implements Sorter {
 
	public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
 
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
    public static void mian(String[] args){
		int[] input = { 4, 6, 2, 1, 10, 10, 20, 11, 9, -1 };
	    final Comparable[] list = null;

		BubbleSorter b=new BubbleSorter();
		b.sort(list);;
		//System.out.println(Arrays.toString(outPut));
    }
}

