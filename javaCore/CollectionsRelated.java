package javaCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsRelated {
	public static void main(String args[]) {
		List al=new ArrayList();
		List ll=new LinkedList();
		//Decorate
		List a2=Collections.synchronizedList(al);
		List l2=Collections.synchronizedList(ll);

	}

}
