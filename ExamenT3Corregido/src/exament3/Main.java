package exament3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Parchis parchis;
		String nomJ1, nomJ2;
		String ganador = "";
		int turno = 1;

		System.out.println("BIENVENIDO AL PARCHÕçS DEL IES NERVI”N =D");

		System.out.println("Introduzca el nombre del jugador 1");
		nomJ1 = sc.nextLine();

		do {
			System.out.println("Introduzca el nombre del jugador 2. Tiene que ser distinto al del jugador 1.");
			nomJ2 = sc.nextLine();
		} while (nomJ2.equals(nomJ1));

		parchis = new Parchis(nomJ1, nomJ2);

		ganador = parchis.esGanador();
		while (ganador.equals("") == true) {
			System.out.println("Pulse una tecla para avanzar");
			sc.nextLine();

			turno(parchis, turno);
			if(Parchis.dado1 != Parchis.dado2) {
				turno = turno==1 ? 2 : 1;
			}

			ganador = parchis.esGanador();
		}

		System.out.println("°ENHORABUENA " + parchis.nomJ1 + ", HAS GANADO!");

	}

	public static void turno(Parchis parchis, int jugador) {

		System.out.println("Turno de " + (jugador==1 ? parchis.nomJ1 : parchis.nomJ2));
		Parchis.tiraDados();
		System.out.println("La tirada ha sido " + Parchis.dado1 + " y " + Parchis.dado2);
		parchis.avanzaPosiciones(jugador);
		parchis.pintaTablero();
		parchis.estadoCarrera();

	}

}
