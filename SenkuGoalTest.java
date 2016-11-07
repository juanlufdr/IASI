package aima.core.environment.senku;

import aima.core.search.framework.GoalTest;

public class SenkuGoalTest implements GoalTest {

	public boolean isGoalState(Object state) {
		SenkuBoard tablero = (SenkuBoard) state;

		return (tablero.getBoard()[3][3] == 1 && tablero.getFichasRestantes() == 1);
	}
}
