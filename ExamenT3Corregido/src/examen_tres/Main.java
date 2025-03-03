package examen_tres;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Parchis parchis;
		String nomJ1;
		String nomJ2;
		String ganador = "";
		int turno = 1;

		logger.log(Level.INFO, "BIENVENIDO AL PARCHÍS DEL IES NERVIÓN =D");

		logger.log(Level.INFO, "Introduzca el nombre del jugador 1");
		nomJ1 = sc.nextLine();

		do {
			logger.log(Level.INFO, "Introduzca el nombre del jugador 2. Tiene que ser distinto al del jugador 1.");
			nomJ2 = sc.nextLine();
		} while (nomJ2.equals(nomJ1));

		parchis = new Parchis(nomJ1, nomJ2);

		ganador = parchis.esGanador();
		while (ganador.equals("")) {
			logger.log(Level.INFO, "Pulse una tecla para avanzar");
			sc.nextLine();

			turno(parchis, turno);
			if (Parchis.dado1 != Parchis.dado2) {
				turno = turno == 1 ? 2 : 1;
			}

			ganador = parchis.esGanador();
		}

		logger.log(Level.INFO, () -> String.format("¡ENHORABUENA %s, HAS GANADO!", parchis.nomJ1));
	}

	public static void turno(Parchis parchis, int jugador) {
		logger.log(Level.INFO, () -> String.format("Turno de %s", (jugador == 1 ? parchis.nomJ1 : parchis.nomJ2)));
		Parchis.tiraDados();
		logger.log(Level.INFO, () -> String.format("La tirada ha sido %d y %d", Parchis.dado1, Parchis.dado2));
		parchis.avanzaPosiciones(jugador);
		parchis.pintaTablero();
		parchis.estadoCarrera();
	}
}
