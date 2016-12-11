/*
 * String2PW.java
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
public class String2PW {
	
	public static void main(String[] args) {
	int test=0;
	if (args.length!=0){
		//Duplikate wegfiltern
		for (int i=0; i<args.length; i++) {
			for (int y=0; y<args.length; y++) {
				if (!(i==y) && args[i].equals(args[y]) && !args[y].equals("")) {
					args[y]="";										
				}
			}	
		}
	// Werte werden so addiert, dass keine Additionsergebnisse doppelt vorkommen. 
		for (int i=0;i<args.length;i++) {
			if (args[i].equals("normal")) {
				test=test+8;
			}
			else if (args[i].equals("upper")) {
				test=test+4;
			}
			else if (args[i].equals("lower")) {
				test=test+2;
			}
			else if (args[i].equals("camel")) {
				test=test+1;
			}	
		}
	}
	if (test==0){
		System.out.println("Hilfe:");
		System.out.println("Starten sie das Programm mit den"
				+ " folgenden Argumenten, um verschieden"
				+ " strukturierte Passwörter zu generieren");
		System.out.println("normal : Upper/Lowercase werden nicht verändert.");			
		System.out.println("upper  : Alle Zeichen Upper-Case");
		System.out.println("lower  : 3x dürfen Sie raten..");
		System.out.println("camel    : Abwechselnd Upper/Lower/Upper");
		System.out.println("Die Argumente können auch beliebig kombiniert werden.");
		return;
	}
	Scanner sc = new Scanner(System.in);
	String input = sc.nextLine();														//Satz einlesen
	sc.close();
	char[] proto = input.toCharArray();													//Aus String ein char-Array machen.
	char[] pw = new char[input.length()];												//Array, in das das PW kommt.
	int counter=0;												
	if(!(proto[0]==' ')){
		pw[0]=proto[0];
		counter++;																		//erste Zeichen übernehmen,
		}																				//falls es kein Leerzeichen ist
	for (int i=0; i<proto.length; i++) {
		if (!(i+1==proto.length) && ' '==proto[i] && !(' '==proto[i+1])) {				//übelst krasse Fickzeile hier!
		pw[counter]=proto[i+1];															//Array durchlaufen, falls Space,
		counter++;																		//das nachfolgende Zeichen
		}																				//übernehmen		
	}
	if ((test-8)>=0){
		System.out.print("Das Passwort (so wie eingegeben) ist: ");
		for (int i=0; i<pw.length; i++){
			System.out.print(pw[i]);													//pw-Array ausgeben
		}
		System.out.println("");
		test-=8;
	}
	int hilfsvar;
	if ((test-4)>=0){
		System.out.print("Das Passwort (nur mit Großbuchstaben) ist: ");
		for (int i=0; i<pw.length; i++) {
			if ((int)pw[i]>=97 && (int)pw[i]<=122) {									//wenn Lower-Case
				hilfsvar=(int)(pw[i]-32);												//U-Case sind 32 Zeichen vor L-Case
				pw[i]=(char)hilfsvar;
			}
			System.out.print(pw[i]);
		}
		System.out.println("");
		test-=4;
	}
	if ((test-2)>=0){
		System.out.print("Das Passwort (nur mit Kleinbuchstaben) ist: ");
		for (int i=0; i<pw.length; i++) {
			if ((int)pw[i]>=65 && (int)pw[i]<=90) {										//wenn Upper-Case
				hilfsvar=(int)(pw[i]+32);												//L-C sind 32 Zeichen hinter U-C
				pw[i]=(char)hilfsvar;
			}
			System.out.print(pw[i]);
		}
		System.out.println("");
		test-=2;
	}
	if ((test-1)>=0){
		boolean gross=true;
		System.out.print("Das Passwort (abwechselnd groß/klein) ist: ");
		for (int i=0; i<pw.length; i++) {
			if (gross){
				gross=false;
				if ((int)pw[i]>=97 && (int)pw[i]<=122) {
					hilfsvar=(int)(pw[i]-32);
					pw[i]=(char)hilfsvar;												//boolean gross wechselt bei jedem
				}																		//Schleifendurchlauf die Verzweigung			
			}
			else {
				gross=true;
				if ((int)pw[i]>=65 && (int)pw[i]<=90) {
					hilfsvar=(int)(pw[i]+32);
					pw[i]=(char)hilfsvar;
					}
				}
			System.out.print(pw[i]);
			}
		System.out.println("");
		test-=1;
		}

	}
}
