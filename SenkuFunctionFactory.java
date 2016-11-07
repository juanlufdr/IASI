package aima.core.environment.senku;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import aima.core.util.datastructure.XYLocation;

public class SenkuFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;
	
	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new SenkuActionFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new SenkuResultFunction();
		}
		return _resultFunction;
	}

	private static class SenkuActionFunction implements ActionsFunction {

		public Set<Action> actions(Object state) {
			SenkuBoard board = (SenkuBoard) state;
			Set<Action> acciones = new LinkedHashSet<Action>();
			for (int x = 0; x < board.getTam(); x++) {
				for (int y = 0; y < board.getTam(); y++) {
					if (board.puedemoverAbajo(new XYLocation(x, y))) {
						acciones.add(new SenkuAction(SenkuAction.MOV_ABAJO,
								new XYLocation(x, y)));
					}
					if (board.puedemoverArriba(new XYLocation(x, y))) {
						acciones.add(new SenkuAction(SenkuAction.MOV_ARRIBA,
								new XYLocation(x, y)));
					}
					if (board.puedemoverDerecha(new XYLocation(x, y))) {
						acciones.add(new SenkuAction(SenkuAction.MOV_DCHA,
								new XYLocation(x, y)));
					}
					if (board.puedemoverIzquierda(new XYLocation(x, y))) {
						acciones.add(new SenkuAction(SenkuAction.MOV_IZDA,
								new XYLocation(x, y)));
					}
				}
			}
			return acciones;
		}
	}

	private static class SenkuResultFunction implements ResultFunction {

		public Object result(Object s, Action a) {
			SenkuBoard tOrigen = new SenkuBoard((SenkuBoard) s);
			SenkuBoard tDestino = new SenkuBoard(tOrigen);
			if (a instanceof SenkuAction) {
				SenkuAction sa = (SenkuAction) a;
				if (sa.getName() == SenkuAction.MOV_ARRIBA) {
					tDestino.moverArriba(sa.getLocation());
				} else if (sa.getName() == SenkuAction.MOV_ABAJO) {
					tDestino.moverAbajo(sa.getLocation());
				} else if (sa.getName() == SenkuAction.MOV_DCHA) {
					tDestino.moverDerecha(sa.getLocation());
				} else if (sa.getName() == SenkuAction.MOV_IZDA) {
					tDestino.moverIzquierda(sa.getLocation());
				} else {
					tDestino = tOrigen;
				}
			}
			return tDestino;
		}
	}
}
