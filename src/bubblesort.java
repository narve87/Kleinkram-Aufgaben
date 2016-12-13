import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.util.logging.FileHandler;

public class bubblesort {
	private final static Logger Martin = Logger.getLogger(bubblesort.class.getName());
	static private FileHandler Martina;
    static private SimpleFormatter formatterTxt;
	public static int[] bubble(int[] zuSortieren) throws SecurityException, IOException {
		Martin.setLevel(Level.FINER);
		Martina = new FileHandler("Logging.txt");
		formatterTxt = new SimpleFormatter();
		Martina.setFormatter(formatterTxt);
		Martin.addHandler(Martina);
		int tmp;
		for (int a=zuSortieren.length; a>1; a--) {
			for (int b=0; b<a-1; b++) {
				if (zuSortieren[b]>zuSortieren[b+1]) {
					tmp = zuSortieren[b];
					zuSortieren[b] = zuSortieren[b+1];
					zuSortieren[b+1] = tmp;
					tmp = b+1;
					Martin.fine("Switched Index " + b + ":" + zuSortieren[b+1] + " with Index " + tmp + ":" + zuSortieren[b]);
				}
				else {
					tmp=b+1;
					Martin.fine("Kein Switch nötig. Index " + b + ":" + zuSortieren[b] + " ist bereits größer als Index " + tmp +
							":" + zuSortieren[tmp]);
				}
			}
		}
		return zuSortieren;
	}
	public static void main(String[] args) throws SecurityException, IOException {
		SecureRandom random = new SecureRandom();
		int[] werte = new int[1000];
		for (int i=0; i<werte.length; i++) {
			werte[i]=random.nextInt(500000);			
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
