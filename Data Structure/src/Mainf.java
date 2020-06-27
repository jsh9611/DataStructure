
public class Mainf {

	public static void main(String[] args) {
		int[] a = {5,7,11,15};
		int[] b = a;
		b[1] = -7;
		
		//int c = new int [20];
		System.out.println(a[1] + b[1]);

	}

}
