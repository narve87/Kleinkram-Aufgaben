/*
 * pwgen.java
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
import java.security.SecureRandom;

public class pwgen {
	public static int[] randomize(int[] pwarray) {		
		SecureRandom random = new SecureRandom();
		for (int i=0; i<pwarray.length; i++) {
			int rnd=random.nextInt(pwarray.length);				//Array durchlaufen und jeden Wert gegen 
			int temp=pwarray[i];							 	//zufaelligen Wert aus dem Array tauschen
			pwarray[i]=pwarray[rnd];
			pwarray[rnd]=temp;	
		}
	return pwarray;
	}
	
	@SuppressWarnings("resource")
	public String create () {
		SecureRandom random = new SecureRandom();
		Scanner sc = new Scanner(System.in);
		System.out.println("Wie lang solls PW werden?");
		int arraylength=sc.nextInt();
//		sc.close();
		if (arraylength<1){
			System.out.println("Schlaukopf ... bitte nochmal mit positiver L�nge.");
			return create();
			}
		int pw[]= new int[arraylength];							//Array erzeugen
		for (int i=0; i<(arraylength/4); i++) {
			pw[i] = (random.nextInt(10)+48);					// 2 Zahlen generieren
			}
		for (int i=(arraylength/4); i<arraylength; i++) {		// 6 Buchstaben generieren mit:
			if (random.nextBoolean()){							// 50/50 Chance
				pw[i] = (random.nextInt(26)+65);				// zwischen Grossbuchstaben
				}
			else {
				pw[i] = (random.nextInt(26)+97);				// und Kleinbuchstaben
				}
			}
	//	for (int i=0; i<arraylength; i++) {
	//		System.out.print((char)pw[i]);
	//		}
		for(int i=0;i<(random.nextInt(100)+10);i++) {
			pw=randomize(pw);
		}														// Reinfolge verzufaelligen
	//	System.out.println();
		System.out.println("Dein PW: ");
		
		for (int i=0; i<arraylength; i++) {
			System.out.print((char)pw[i]);
		}
		System.out.println();
		String retour="";
		for (int a=0; a<pw.length; a++) {
			retour = retour+(char)pw[a];
		}
		return retour;
	}
	
	public static void main (String args[]) {
	//	create();
	}
}
