package javaCore;

import java.io.Serializable;
import java.util.Iterator;

public class MultiClass<E> implements Cloneable, Serializable, Iterator<E> {
	private static final long serialVersionUID = 1L;

	public boolean hasNext() {
		return false;
	}

	public E next() {
		return null;
	}

	public void remove() {

	}
}

interface MultiInterface<E> extends Cloneable, Serializable, Iterator<E> {

}
