package aima.core.environment.senku;

import aima.core.search.framework.HeuristicFunction;
import aima.core.environment.senku.SenkuBoard;

public class HeuristicaBordes implements HeuristicFunction {

	public double h(Object state) {

		int cont = 0;
		for (int i = 0; i < ((SenkuBoard) state).getTam(); i++) {
			for (int j = 0; j < ((SenkuBoard) state).getTam(); j++) {

				if (((SenkuBoard) state).getBoard()[i][j] == 1
						&& (i == 0 || i == ((SenkuBoard) state).getTam() - 1
								|| j == 0 || j == ((SenkuBoard) state).getTam() - 1))
					cont++;

				else if ((i == 2 && ((SenkuBoard) state).getBoard()[i - 1][j] == 2)
						|| (i == 4 && ((SenkuBoard) state).getBoard()[i + 1][j] == 2)
						|| (j == 2 && ((SenkuBoard) state).getBoard()[i][j - 1] == 2)
						|| (j == 4 && ((SenkuBoard) state).getBoard()[i][j + 1] == 2)) {
					cont++;
				}
			}
		}
		return cont;
	}
}
