package aima.core.environment.senku;

import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;
import aima.core.environment.senku.SenkuBoard;

public class HeuristicaDistancia implements HeuristicFunction {

	public double h(Object state) {
		int contFichas = 0;
		SenkuBoard tablero = (SenkuBoard) state;
		for (int i = 0; i < tablero.getTam(); i++) {
			for (int j = 0; j < tablero.getTam(); j++) {
				if (tablero.getBoard()[i][j] == 1) {
					if ((!tablero.puedemoverAbajo(new XYLocation(i, j)))
							&& (!tablero.puedemoverArriba(new XYLocation(i, j)))
							&& (!tablero
									.puedemoverDerecha(new XYLocation(i, j)))
							&& (!tablero.puedemoverIzquierda(new XYLocation(i,
									j))))

						contFichas = contFichas + Math.abs(3 - i)
								+ Math.abs(3 - j);
				}
			}

		}
		return contFichas;
	}
}