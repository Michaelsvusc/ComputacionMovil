package com.co.solarte.principal;

import java.util.Scanner;

import com.co.solarte.principal.implementaciones.Sumar;
import com.co.solarte.principal.uno.OperacionInterface;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public void mostarMenu() {

		System.out.println("Digite el número uno: ");
		double numUno = sc.nextDouble();

		System.out.println("Digite el número dos: ");
		double numDos = sc.nextDouble();

		System.out.println("Que operación desea hacer: ");
		int seleccion = sc.nextInt();

		switch (seleccion) {
		case 1:

			Sumar sm = new Sumar();
			System.out.println(sm.sumar(numUno, numDos);

			break;
		case 2:

			Sumar sm = new Sumar();
			sm.sumar(numUno, numDos);

			break;
		case 3:

			Sumar sm = new Sumar();
			sm.sumar(numUno, numDos);

			break;

		default:
			break;
		}

	}
}
