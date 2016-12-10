/*
 * iban.java
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
import java.math.BigInteger;
import java.util.Scanner;

public class iban {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte einen KtNr eingeben:");
		int ktnru = sc.nextInt();
		String ktnr = String.format("%010d", ktnru);
		System.out.println("Bitte eine BLz eingeben:");
		int blzu = sc.nextInt();
		sc.close();
		String blz = String.format("%08d", blzu);
		String bban =  blz + ktnr;
		String calc =  blz + ktnr + "131400";
	//	System.out.println("bigint: " + calc);
		BigInteger intcalc = new BigInteger(calc);
		BigInteger siebenundneunzig = new BigInteger("97");
		BigInteger achtundneunzig = new BigInteger("98");
		BigInteger mod = intcalc.mod(siebenundneunzig);
		BigInteger sub = achtundneunzig.subtract(mod);
	//	System.out.println("bigint: " + sub);
		String csum = String.format("%02d", sub);
	//	System.out.println("bigint: " + csum);
		System.out.println("IBAN: DE" + csum + bban);
	}
}

