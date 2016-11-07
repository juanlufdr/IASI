package aima.core.environment.senku;

import aima.core.agent.impl.DynamicAction;
import aima.core.util.datastructure.XYLocation;

public class SenkuAction extends DynamicAction {
	public static final String MOV_DCHA = "moverDerecha";
	public static final String MOV_IZDA = "moverIzquierda";
	public static final String MOV_ARRIBA = "moverArriba";
	public static final String MOV_ABAJO = "moverAbajo";
	public static final String SENKU_POS = "Posicion";
	
	public SenkuAction(String type, XYLocation loc) {
		super(type); //type es el nombre de la función 
		setAttribute(SENKU_POS, loc);
	}
	
	public XYLocation getLocation() {
		return (XYLocation) getAttribute(SENKU_POS);
	}

	
}
