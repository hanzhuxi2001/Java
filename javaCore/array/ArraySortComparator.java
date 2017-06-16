package javaCore.array;

import java.util.Arrays;
import java.util.Comparator;

/*
  4、总结

总的来说，从Arrays.sort()中你应该了解到：
generic(范型)——super
策略模式
归并排序——nlog(n)时间复杂度
 java.util.Collections.sort(List<T>list, Comparator<?super T> c)类似于Arrays.sort
参考：Arrays.sort(T[], java.util.Comparator)

原文链接： programcreek 翻译： ImportNew.com - 刘志军
译文链接： http://www.importnew.com/8952.html
 * @author hd
 *
 */
class Animal {
	int size;
}

class Dog extends Animal {
	int weight;

	public Dog(int s, int w) {
		size = s;
		weight = w;
	}
}

class Cat extends Animal {
	int weight;

	public Cat(int s, int w) {
		size = s;
		weight = w;
	}
}

class AnimalSizeComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.size - o2.size;
	}

}

class DogSizeComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.size - o2.size;
	}
}

class DogWieghtCompartor implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.weight - o2.weight;
	}

}

public class ArraySortComparator {

	public static void main(String[] args) {
		Dog d1 = new Dog(2, 90);
		Dog d2 = new Dog(1, 56);
		Dog d3 = new Dog(3, 37);
		Dog d4 = new Dog(3, 70);

		Dog[] dogArray = { d1, d2, d3, d4 };
		printDogs(dogArray);

		// Arrays.sort(dogArray, new DogSizeComparator());
		Arrays.sort(dogArray, new DogWieghtCompartor());

		Cat c1 = new Cat(2, 90);
		Cat c2 = new Cat(1, 56);
		Cat c3 = new Cat(3, 37);
		Cat c4 = new Cat(3, 70);

		Cat[] catArray = { c1, c2, c3, c4 };
		printAnimal(catArray);

		// Arrays.sort(dogArray, new DogSizeComparator());
		Arrays.sort(dogArray, new AnimalSizeComparator());

		printAnimal(dogArray);
	}

	public static void printDogs(Dog[] dogs) {
		for (Dog d : dogs) {
			System.out.print("size:" + d.size + " ");
			System.out.print("weight:" + d.weight + " ");
		}

		System.out.println();
	}

	public static void printAnimal(Animal[] animal) {
		for (Animal a : animal) {
			System.out.print("size:" + a.size + " ");
		}

		System.out.println();
	}
}