package javaCore;

public class CloneClass implements Cloneable {

	public static void main(String[] args) {

		CloneClass c = new CloneClass();
		CloneClass c2;
		try {
			c2 = (CloneClass) c.clone();
			System.out.println(c.equals(c2));
			System.out.println(c == c2);
			System.out.println(c.toString());

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
