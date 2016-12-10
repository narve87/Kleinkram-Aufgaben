/*
 * pwgen.cpp
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
#include <iostream>
#include <random>
using namespace std;

int main()
{
	random_device rd;
	cout << "Wie lang soll das PW sein?" << endl;
	int arraylength=0;
	cin >> arraylength;
	if(arraylength==0){
		cout << "Witzbold..." << endl;
		return 1;
		}
	int array[arraylength]= { 0 };
	for (int i=0; i<(arraylength/4); i++) {
		array[i]=((rd()%10)+48);
	}
	for (int i=(arraylength/4);i<arraylength;i++) {
		if((rd()%2==0)) {
			array[i]=((rd()%26)+65);
		}
		else {
			array[i]=((rd()%26)+97);
		}
	}
	int tmp=0;
	int rnd;
	for (unsigned int i=0; i<(rd()%100);i++) {

		for (int i=0;i<arraylength; i++) {
			rnd = (rd()%arraylength);
			tmp = array[i];
			array[i]=array[rnd];
			array[rnd]=tmp;
		}
	}
	cout << "Das Passwort ist:" << endl;
	for (int i=0;i<arraylength;i++) {
		cout << (char)array[i];
	}
	cout << endl;
	return 0;
}
