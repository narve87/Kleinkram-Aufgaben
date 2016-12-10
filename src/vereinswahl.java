import java.util.Scanner;
public class vereinswahl {

	public static void main(String[] args) {
		int[] Array = new int[40];
		for (int i=0; i<Array.length; i++) {
			Array[i]=0;
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
					Array[wahl]++;
					goodvote++;
				}
			}
			
			
		}
		for (int i=0; i<Array.length; i++) {
			if(Array[i]>0) {
				System.out.println("Der Kandidat " + i + " erhielt " + Array[i] + " Stimmen.");
			}
			
		}
		System.out.println("Es wurden " + goodvote + " gültige Stimmen abgegeben");
		System.out.println("Es wurden " + badvote + " ungültige Stimmen abgegeben");
	sc.close();
	}

}
