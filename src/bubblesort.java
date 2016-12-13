import java.security.SecureRandom;

public class bubblesort {

	public static int[] bubble(int[] zuSortieren) {
		int tmp;
		for (int a=zuSortieren.length; a>1; a--) {
			for (int b=0; b<a-1; b++) {
				if (zuSortieren[b]>zuSortieren[b+1]) {
					tmp = zuSortieren[b];
					zuSortieren[b] = zuSortieren[b+1];
					zuSortieren[b+1] = tmp;
				}
			}
		}
		return zuSortieren;
	}
	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		int[] werte = new int[100];
		for (int i=0; i<werte.length; i++) {
			werte[i]=random.nextInt(5000);			
		}
		for (int i=0; i<werte.length; i++) {
			System.out.println(i + ":" + werte[i]);			
		}
		werte=bubble(werte);
		for (int i=0; i<werte.length; i++) {
			System.out.println(i + ":" + werte[i]);			
		}
	}

}
