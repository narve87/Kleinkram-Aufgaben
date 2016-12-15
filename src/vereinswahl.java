import java.io.IOException;
import java.util.Scanner;
public class vereinswahl {

	public static void main(String[] args) throws SecurityException, IOException {
		int[][] Array = new int[40][2];
		for (int i=0; i<Array.length; i++) {
			Array[i][1]=0;
			Array[i][0]=i;
		}
		Scanner sc = new Scanner(System.in);
		int wahl=0;
		int badvote=0;
		int goodvote=0;
		while (true) {
			System.out.println("Wen willst'n Wählen?");
			wahl=sc.nextInt();
			if(wahl==100) {
				break;
			
			}
			else {
				if(wahl>=40) {
					badvote++;
				}
				else {
					Array[wahl][1]++;
					goodvote++;
				}
			}
			
			
		}
		Array=bubblewahl.bubble(Array);
		for (int i=Array.length-1; i>Array.length-6; i--) {
			if(Array[i][1]>0) {
				System.out.println("Der Kandidat " + Array[i][0] + " erhielt " + Array[i][1] + " Stimmen.");
			}
			
		}
		System.out.println("Es wurden " + goodvote + " gültige Stimmen abgegeben");
		System.out.println("Es wurden " + badvote + " ungültige Stimmen abgegeben");
	sc.close();
	}

}
