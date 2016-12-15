import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.util.logging.FileHandler;

public class bubblewahl {
	private final static Logger Martin = Logger.getLogger(bubblewahl.class.getName());
	static private FileHandler Martina;
    static private SimpleFormatter formatterTxt;
	public static int[][] bubble(int[][] zuSortieren) throws SecurityException, IOException {
		Martin.setLevel(Level.FINER);
		Martina = new FileHandler("Logging.txt");
		formatterTxt = new SimpleFormatter();
		Martina.setFormatter(formatterTxt);
		Martin.addHandler(Martina);
		int tmp;
		for (int a=zuSortieren.length; a>1; a--) {
			boolean switched=false;
			for (int b=0; b<a-1; b++) {
				if (zuSortieren[b][1]>zuSortieren[b+1][1]) {
					for (int i=0; i<zuSortieren[b].length; i++) {
					tmp = zuSortieren[b][i];
					zuSortieren[b][i] = zuSortieren[b+1][i];
					zuSortieren[b+1][i] = tmp;
					tmp = b+1;
					Martin.fine("Switched Index " + b + " with Index " + tmp);
					switched=true;
						}
					} 
				else {
					Martin.fine("Kein Switch nötig.");
				}
			if(switched==false) {
				break;
				}
			}
		}
		return zuSortieren;
	}
	public static void main(String[] args) throws SecurityException, IOException {
		Martin.setLevel(Level.INFO);
		if (args.length!=0) {
			Martin.setLevel(Level.FINER);	
		}
		SecureRandom random = new SecureRandom();
		int[][] werte = new int[1000][2];
		for (int i=0; i<werte.length; i++) {
			werte[i][0]=random.nextInt(500000);			
		}
		for (int i=0; i<werte.length; i++) {
			System.out.println(i + ":" + werte[i][0]);			
		}
//		werte=bubble(werte);
		for (int i=0; i<werte.length; i++) {
			System.out.println(i + ":" + werte[i][0]);			
		}
	}
}
