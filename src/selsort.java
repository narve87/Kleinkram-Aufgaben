import java.security.SecureRandom;
public class selsort {
	public static int[] select (int[] zuSortieren) {
		int selected;
		int temp=0;
		for (int i=0; i<zuSortieren.length; i++) {
			selected=i;
			for (int y=i; y<zuSortieren.length; y++) {
				if (zuSortieren[y]<zuSortieren[selected]){
					selected=y;
				}
			}
			temp = zuSortieren[i];
			zuSortieren[i] = zuSortieren[selected];
			zuSortieren[selected] = temp;
		}
		return zuSortieren;
	}
	public static void main(String[] args) {
		SecureRandom sc = new SecureRandom();
		int[] test = new int[10];
		for (int i=0; i<test.length; i++) {
			test[i]=sc.nextInt(50);
		}
		for (int i=0; i<test.length; i++) {
			System.out.print(i + ":" + test[i] + " ");
		}
		
		System.out.println();
		test=select(test);
		for (int i=0; i<test.length; i++) {
			System.out.print(i + ":" + test[i] + " ");
		}
		System.out.println();
	}

}
