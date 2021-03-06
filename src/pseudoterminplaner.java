import java.util.Scanner;
public class pseudoterminplaner {

	@SuppressWarnings("resource")
	public static int get_day() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tag?");
		System.out.println("1: Montag");
		System.out.println("2: Dienstag");
		System.out.println("3: Mittwoch");
		System.out.println("4: Donnerstag");
		System.out.println("5: Freitag");
		System.out.println("6: Samstag");
		System.out.println("7: Sonntag");
		int day=(sc.nextInt()-1);
		if (day>=0 && day<=6) {
			return day;
		}
		else {
			System.out.println("Bitte korrekten Tag wählen.");
			return get_day();
		}
	}
	
	public static void main(String[] args) {
		String[][] termine = new String[7][25];
		for (int i=0;i<7;i++) {
			for (int y=0;y<24;y++) {
				termine[i][y]="";
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Terminplaner:");
		termine[0][24]="Montag";
		termine[1][24]="Dienstag";
		termine[2][24]="Mittwoch";
		termine[3][24]="Donnerstag";
		termine[4][24]="Freitag";
		termine[5][24]="Samstag";
		termine[6][24]="Sonntag";
		int stunde=0;
		int tag=0;
		int menuvar=0;
		boolean submenu=false;
		boolean exit=false;
		while (!exit){
			System.out.println("Hauptmenü:");
			System.out.println("1: Neuen Termin anlegen");
			System.out.println("2: Termin löschen");
			System.out.println("3: Wochenkalender einsehen");
			System.out.println("0: Exit");
			menuvar=sc.nextInt();
			switch(menuvar){
			case 0:
				exit=true;
				break;
			case 1:
				tag=get_day();
				if(tag>=0 && tag<=6) {
					System.out.println("In welcher Stunde?");
					stunde=sc.nextInt();
					if (stunde<=23 && stunde>=0) {
						System.out.println("Was liegt an?");
						termine[tag][stunde]=sc.next();
					}
				}
				break;
			case 2:
				tag=get_day();
				System.out.println("In welcher Stunde?");
				stunde=sc.nextInt();
				if (stunde<=23 && stunde>=0) {
					termine[tag][stunde]="";
				}
				break;
			case 3:
				submenu=true;
				do  {
					System.out.println("Welchen Tag willst sehen?");
					tag=get_day();
					System.out.println("Am " + termine[tag][24] + 
						" liegt folgendes an:");
					for (int i=0;i<24;i++) {
						System.out.println(i + " Uhr: " + termine[tag][i]);
						}
					System.out.println("Weiteren Tag anzeigen? (Y/n)");
					String checker=sc.next();
					if(checker.equals("n") || checker.equals("N")) {
						submenu=false;
					}
				}
				while (submenu);
				break;
			default:
				System.out.println("Doofer Wert.");
			}
		}
		sc.close();
	}
}
