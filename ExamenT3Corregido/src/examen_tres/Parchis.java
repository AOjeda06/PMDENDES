package examen_tres;

import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Clase del juego de mesa 'Parchís'
 */
public class Parchis {
	/**
	 * Variable que almacena el valor que identifica al jugador 2
	 */
	/* default */
	private static final int JUGADOR_2 = 2;
	/**
	 * Variable que almacena el valor que identifica al jugador 1
	 */
	/* default */
	private static final int JUGADOR_1 = 1;

	/**
	 * Tamaño del tablero del juego Parchís.
	 */
	public static final int TAM_TABLERO = 10;

	/**
	 * Logger para registrar mensajes informativos y de error.
	 */
	private static final Logger LOGGER = Logger.getLogger(Parchis.class.getName());

	/**
	 * Valores del dado 1
	 */
	/* default */
	static int dado1;

	/**
	 * Valor del dado 2
	 */
	/* default */
	static int dado2;

	/**
	 * Posición de la ficha del jugador 1
	 */
	/* default */
	int fichaJ1;

	/**
	 * Posición de la ficha del jugador 2
	 */
	/* default */
	int fichaJ2;

	/**
	 * Nombres del jugador 1.
	 */
	/* default */
	String nomJ1 = "";
	/**
	 * Nombre del jugador 2.
	 */
	/* default */
	String nomJ2 = "";

	/**
	 * Constructor por defecto de la clase Parchis.
	 */
	public Parchis() {
		super();
	}

	/**
	 * Constructor de la clase Parchis que inicializa los nombres de los jugadores.
	 *
	 * @param nomJ1 Nombre del jugador 1.
	 * @param nomJ2 Nombre del jugador 2.
	 */
	public Parchis(final String nomJ1, final String nomJ2) {
		super();
		this.nomJ1 = nomJ1;
		this.nomJ2 = nomJ2;
	}

	/**
	 * Método estático que simula el lanzamiento de los dados.
	 */
	public static void tiraDados() {
		final Random rand = new Random();
		dado1 = rand.nextInt(1, 7);
		dado2 = rand.nextInt(1, 7);
	}

	/**
	 * Método que pinta el tablero del juego en la consola.
	 */
	public void pintaTablero() {
		LOGGER.log(Level.INFO, "\tI");
		for (int i = 1; i < TAM_TABLERO; i++) {
			LOGGER.log(Level.INFO, "\t{0}", i);
		}
		LOGGER.log(Level.INFO, "\tF");

		LOGGER.log(Level.INFO, "{0}\tI", nomJ1);

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ1) {
				LOGGER.log(Level.INFO, "\tO");
			} else {
				LOGGER.log(Level.INFO, "\t");
			}
		}

		LOGGER.log(Level.INFO, "\tF");

		LOGGER.log(Level.INFO, "{0}\tI", nomJ2);

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ2) {
				LOGGER.log(Level.INFO, "\tO");
			} else {
				LOGGER.log(Level.INFO, "\t");
			}
		}
		LOGGER.log(Level.INFO, "\tF\n");

	}

	/**
	 * Método que avanza las posiciones de las fichas de los jugadores en el
	 * tablero.
	 *
	 * @param jugador Número del jugador (1 o 2) que avanza su ficha.
	 */
	public void avanzaPosiciones(final int jugador) {
		final int tirada = dado1 + dado2;

		if (jugador == JUGADOR_1) {
			fichaJ1 += tirada;

			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = TAM_TABLERO - (fichaJ1 - TAM_TABLERO);
			}
		} else if (jugador == JUGADOR_2) {
			fichaJ2 += tirada;

			if (fichaJ2 > TAM_TABLERO) {
				fichaJ2 = 2 * TAM_TABLERO - fichaJ2;
			}
		}
	}

	/**
	 * Método que imprime el estado de la carrera en la consola.
	 */
	public void estadoCarrera() {
		if (fichaJ1 > fichaJ2) {
			LOGGER.log(Level.INFO, "Va ganando {0}", nomJ1);
		} else if (fichaJ1 < fichaJ2) {
			LOGGER.log(Level.INFO, "Va ganando {0}", nomJ2);
		} else {
			LOGGER.log(Level.INFO, "Van empatados");
		}
		LOGGER.log(Level.INFO, "");
	}

	/**
	 * Método que determina el ganador del juego.
	 *
	 * @return Nombre del jugador ganador o una cadena vacía si no hay ganador.
	 */
	public String esGanador() {
		String ganador = "";
		if (fichaJ1 == TAM_TABLERO) {
			ganador = nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			ganador = nomJ2;
		}
		return ganador;
	}

}
