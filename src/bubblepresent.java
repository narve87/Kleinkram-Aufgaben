import java.security.SecureRandom;

public class bubblepresent {
	public static int[] bubble(int[] zuSortieren) {
		int tmp;
		for (int a=zuSortieren.length; a>1; a--) {
//			boolean switched=false;
			for (int b=0; b<a-1; b++) {
				if (zuSortieren[b]>zuSortieren[b+1]) {
					tmp = zuSortieren[b];
					zuSortieren[b] = zuSortieren[b+1];
					zuSortieren[b+1] = tmp;
					tmp = b+1;
//					switched=true;
				}
			}
//			if(switched==false) {
//				break;
//				}
		}
		return zuSortieren;
	}
	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		int[] werte = new int[100000];
		for (int i=0; i<werte.length; i++) {
			werte[i]=random.nextInt(1000000);			
		}
		for (int i=0; i<werte.length; i++) {
			System.out.print(i + ":" + werte[i] + " ");
		}
		System.out.println();
		werte=bubble(werte);
		for (int i=0; i<werte.length; i++) {
			System.out.print(i + ":" + werte[i] + " ");			
		}
		System.out.println();
	}
}
