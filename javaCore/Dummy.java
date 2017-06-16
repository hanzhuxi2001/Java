package javaCore;

public class Dummy {

	public static void main(String args[]) {
		test();
	}

	public static int test() {
//		if(1==1){
//			System.out.println("out side of the try...");
//			return 1;
//
//		}
		try {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("try....");
			//System.exit(1);
			return 2;
		} finally {
			System.out.println("fianlly....");
		}
	}
}
