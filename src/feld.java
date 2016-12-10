/*
 * feld.java
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

public class feld {
	
	public static void anzeigen(int[] feld) {
		for (int i=0; i<feld.length; i++) {
			System.out.println("Array[" + i + "] = " + feld[i]);
		}
	}

	public static void anzeigenrueckwaerts(int[] feld) {
		for (int i=feld.length-1; i>=0; i--){
			System.out.println("Array[" + i + "] = " + feld[i]);
			}	
	}

	public static int maximum(int[] feld) {
	int gross=0;
	for (int i=0; i<feld.length; i++) {
		if (feld[i]>gross) {
			gross=feld[i];
			}
		}
	return gross;
	}
	
	public static int minimum(int[] feld) {
	int klein=feld[0];
	for (int i=0; i<feld.length; i++) {
		if (feld[i]<klein) {
			klein=feld[i];
			}
		}
	return klein;
	}
	
	public static double durchschnitt(int[] feld) {
		int allval=0;
		for (int i=0; i<feld.length; i++) {
			allval=allval+feld[i];
		}
		double	avg=allval/feld.length;
		return avg;	
	}
	
	public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Wie viele Werte sollen ins Array?");
	int groesse = sc.nextInt();
	int min;
	int max;
	do {
	System.out.println("Höchster Wert, der ins Array soll?");
	max=sc.nextInt();
	System.out.println("Niedrigster Wert, der ins Array soll`");
	min=sc.nextInt();
	}
	while (min>max);
	SecureRandom random = new SecureRandom();
	sc.close();
	int[] Array = new int[groesse]; //Deklaration und Erzeugung des Arrays
	for (int i=0; i<Array.length; i++){
		Array[i] =(random.nextInt((max-min+1))+(min));
		}
	anzeigen(Array);
	anzeigenrueckwaerts(Array);
	System.out.println("Durchschnittswert: " + durchschnitt(Array));	
	System.out.println("Maximum: " + maximum(Array));
	System.out.println("Minimum: " + minimum(Array));
	}
}

