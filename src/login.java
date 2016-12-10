/*
 * login.java
 * 
 * Copyright 2016 Narve <>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
 import java.util.Scanner;
// import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;

public class login {
	
	public static String[][] increase_size(String array[][], int newsize) {
		String tmp[][] = new String[newsize][2];
		for (int i=0; i<array.length; i++) {
			for (int y=0; y<2; y++) {
				tmp[i][y]=array[i][y];
				}
			}
		return tmp;
		}
	public static String[][] reduce_size(String array[][], int newsize) {
		String tmp[][] = new String[newsize][2];
		for (int i=0; i<newsize; i++) {
			for (int y=0; y<2; y++) {
				tmp[i][y]=array[i][y];
				}
			}
	return tmp;
	}
	
	public static boolean check_credentials(String user, String password, String Credentials[][]) {
		for (int i=0;i<Credentials.length;i++){
			if(user.equals(Credentials[i][0]) && password.equals(Credentials[i][1])) {
			return true;
			}
		}
		return false;	
	}
	public static int check_uname(String user, String Credentials[][]) {
		for (int i=0;i<Credentials.length;i++){
			if(user.equals(Credentials[i][0])) {
			return i;
			}
		}
		return 0;
	}
	
	public static void main (String[] args){ // throws NoSuchAlgorithmException {
//		MessageDigest md = MessageDigest.getInstance("SHA-512");
		Scanner sc = new Scanner(System.in);
		String[][] Credentials = new String[1][2]; //Deklaration und Erzeugung des Arrays
		Credentials[0][0]="root";
		Credentials[0][1]="root";
		boolean loggedin=false;
		int tester=0;
		int acccount=1;								//Counts existing accounts.
		int menuvar=0;
		String cuser="guest";						// Current User
		String muser="guest";						//modifiedUser
		String pass="1";
		while (true) {
			if (!loggedin) {
				System.out.println("Menü:");
				System.out.println("1: Login");
				System.out.println("0: Exit");
				System.out.println("Bitte wählen.");
				menuvar=sc.nextInt();
				switch (menuvar) {
					case 0: 
						System.out.println("Tschuess!");
						sc.close();
						return;
					case 1:
						int logincount=0;
						while (logincount<=2) {
							System.out.println("Bitte Username eingeben:");
							String puser = sc.next();
							System.out.println("Bitte Passwort eingeben:");
							pass = sc.next();
							if (check_credentials(puser, pass, Credentials)) {
								cuser=puser;
								loggedin=true;
								System.out.println("Login erfolgreich.");
								sc.next();
								break;
								}
							else {
								logincount++;
								System.out.println("Login incorrect.");
								}
							if (logincount==3) {
								System.out.println("Login failed.");
								return;
								}
							}
					//	System.out.println("Login NYI.");
						break;
					default:
						System.out.println("Doofer Wert.");
					}
				}
			else {
				System.out.println("Hallo " + cuser + "! Dein Menü:");
				System.out.println("1: Account löschen.");
				System.out.println("2: Passwort anderer User ändern");
				System.out.println("3: eigenes Passwort ändern");
				System.out.println("4: Account erstellen");
				System.out.println("9: Exit");
				System.out.println("0: Logout");
				System.out.println("Bitte wählen.");
				menuvar=(int)sc.nextInt();
				switch (menuvar) {
					case 0: 
						System.out.println("Ausgelogged.");
						loggedin=false;
						cuser="guest";
						break;
					case 1:
						System.out.println("Bitte zu löschenden Usernamen eingeben:");
						muser=sc.next();
						tester=check_uname(muser, Credentials);
						if(tester>0) {
							Credentials[tester][0]=Credentials[acccount-1][0];
							Credentials[tester][1]=Credentials[acccount-1][1];
							acccount--;
							Credentials=reduce_size(Credentials, acccount);
							System.out.println("Account wurde erfolgreich gelöscht.");
							break;
							}
						System.out.println("Username existiert nicht.");
						//		System.out.println("NYI.");
						break;
					case 2:
						System.out.println("Bitte Username eingeben:");
						muser=sc.next();
						tester=check_uname(muser, Credentials);
						if(tester>0) {
							System.out.println("Bitte neues Passwort eingeben:");
							Credentials[tester][1]=sc.next();
							System.out.println("Passwort wurde erfolgreich geändert.");
							break;
							}
						System.out.println("Username exisitiert nicht.");
						break;
					case 3:
						tester=check_uname(cuser, Credentials);
						System.out.println("Bitte neues PW eingeben:");
						Credentials[tester][1]=sc.next();
						break;
					case 4:
						if (acccount==Credentials.length) {
							Credentials=increase_size(Credentials, (Credentials.length+1));
						}
						System.out.println("Bitte Username eingeben.");
						String nuser=sc.next();
						if (check_uname(nuser, Credentials)==0) {
							System.out.println("Bitte Passwort eingeben:");
							Credentials[acccount][0]=nuser;
							Credentials[acccount][1]=sc.next();
							acccount++;
							System.out.println("Benutzer erfolgreich angelegt.");
							break;
						}
						else {
							System.out.println("Benutzer existiert bereits.");							
						}
						sc.next();
						break;
					case 9:
						System.out.println("Tschuess!");
						sc.close();
						return;
					default:
						System.out.println("Doofer Wert.");
					}
				}
			}
	}
}
