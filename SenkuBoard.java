package aima.core.environment.senku;

import aima.core.util.datastructure.XYLocation;

public class SenkuBoard {
	private int tam;
	private char[][] board;
	private int tipo;
	private int fichasRestantes;

	public SenkuBoard(SenkuBoard objboard) {
		this.tam = 7;
		this.board = new char[tam][tam];
		for (int i = 0; i < this.tam; i++) {
			for (int j = 0; j < this.tam; j++) {
				this.board[i][j] = objboard.board[i][j];
			}
		}
		this.fichasRestantes = objboard.fichasRestantes;
	}

	public SenkuBoard(int tipo) {
		this.tipo = tipo;
		switch (tipo) {
		case 1:
			this.fichasRestantes = 32;
			this.tam = 7;
			this.tam = 7;
			this.board = new char[tam][tam];

			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if ((i == 0 || i == 1 || i == 5 || i == 6)
							&& (j == 0 || j == 1 || j == 5 || j == 6))
						this.board[i][j] = 2;
					else
						this.board[i][j] = 1;
				}
			}
			this.board[3][3] = 0;
			break;
		case 2: // cruz
			this.fichasRestantes = 6;
			this.tam = 7;
			this.tam = 7;
			char[][] tab2 = { { 2, 2, 0, 0, 0, 2, 2 }, { 2, 2, 0, 1, 0, 2, 2 },
					{ 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
					{ 0, 0, 0, 1, 0, 0, 0 }, { 2, 2, 0, 0, 0, 2, 2 },
					{ 2, 2, 0, 0, 0, 2, 2 } };
			this.board = tab2;
			break;
		case 3:// signo mas
			this.fichasRestantes = 9;
			this.tam = 7;
			this.tam = 7;
			char[][] tab3 = { { 2, 2, 0, 0, 0, 2, 2 }, { 2, 2, 0, 1, 0, 2, 2 },
					{ 0, 0, 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0 },
					{ 0, 0, 0, 1, 0, 0, 0 }, { 2, 2, 0, 1, 0, 2, 2 },
					{ 2, 2, 0, 0, 0, 2, 2 } };
			this.board = tab3;
			break;
		case 4:// flecha
			this.fichasRestantes = 9;
			this.tam = 7;
			this.tam = 7;
			char[][] tab4 = { { 2, 2, 0, 1, 0, 2, 2 }, { 2, 2, 1, 1, 1, 2, 2 },
					{ 0, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
					{ 0, 0, 0, 1, 0, 0, 0 }, { 2, 2, 1, 1, 1, 2, 2 },
					{ 2, 2, 1, 1, 1, 2, 2 } };
			this.board = tab4;
			break;
		case 5:// calavera
			this.fichasRestantes = 25;
			this.tam = 7;
			this.tam = 7;
			char[][] tab5 = { { 2, 2, 1, 1, 1, 2, 2 }, { 2, 2, 1, 1, 1, 2, 2 },
					{ 0, 1, 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0 },
					{ 0, 1, 1, 1, 1, 1, 0 }, { 2, 2, 1, 1, 1, 2, 2 },
					{ 2, 2, 1, 1, 1, 2, 2 } };
			this.board = tab5;
			break;
		case 6:// piramide
			this.fichasRestantes = 16;
			this.tam = 7;
			this.tam = 7;
			char[][] tab6 = { { 2, 2, 0, 0, 0, 2, 2 }, { 2, 2, 0, 1, 0, 2, 2 },
					{ 0, 0, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1, 1, 1 }, { 2, 2, 0, 0, 0, 2, 2 },
					{ 2, 2, 0, 0, 0, 2, 2 } };
			this.board = tab6;
			break;
		case 7:// diamante
			this.fichasRestantes = 24;
			this.tam = 7;
			this.tam = 7;
			char[][] tab7 = { { 2, 2, 0, 1, 0, 2, 2 }, { 2, 2, 1, 1, 1, 2, 2 },
					{ 0, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 0, 1, 1, 1 },
					{ 0, 1, 1, 1, 1, 1, 0 }, { 2, 2, 1, 1, 1, 2, 2 },
					{ 2, 2, 0, 1, 0, 2, 2 } };
			this.board = tab7;
			break;
		}
	}

	public int obtenerTipo() {
		return this.tipo;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public void setFichasRestantes(int fRestantes) {
		this.fichasRestantes = fRestantes;
	}

	/**
	 * DESC: Otorga valor al atributo board PRE: La instancia debe estar creada
	 * correctamente POST: El atributo board obtiene el valor pasado por
	 * parametro PARAM: board de tipo char[][] COMP: O(1)
	 */

	public void setboard(char[][] board) {
		for (int i = 0; i < this.tam; i++) {
			for (int j = 0; j < this.tam; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}

	public int getTam() {
		return this.tam;
	}

	public int getFichasRestantes() {
		return this.fichasRestantes;
	}

	public char[][] getBoard() {
		char[][] boardaux = new char[this.tam][this.tam];
		for (int i = 0; i < this.tam; i++) {
			for (int j = 0; j < this.tam; j++) {
				boardaux[i][j] = this.board[i][j];
			}
		}
		return boardaux;
	}

	public boolean puedemoverIzquierda(XYLocation posicion) {
		if (posicion.getYCoOrdinate() > 1
				&& posicion.getXCoOrdinate() < this.tam
				&& posicion.getYCoOrdinate() < this.tam
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] == 1)
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() - 1] == 1)
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() - 2] == 0)) {
			return true;
		}
		return false;
	}

	public boolean puedemoverArriba(XYLocation posicion) {
		if (posicion.getXCoOrdinate() > 1
				&& posicion.getXCoOrdinate() < this.tam
				&& posicion.getYCoOrdinate() < this.tam
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] == 1)
				&& (board[posicion.getXCoOrdinate() - 1][posicion
						.getYCoOrdinate()] == 1)
				&& (board[posicion.getXCoOrdinate() - 2][posicion
						.getYCoOrdinate()] == 0)) {
			return true;
		}
		return false;
	}

	public boolean puedemoverAbajo(XYLocation posicion) {
		if (posicion.getXCoOrdinate() < (this.tam - 2)
				&& posicion.getYCoOrdinate() < this.tam
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] == 1)
				&& (board[posicion.getXCoOrdinate() + 1][posicion
						.getYCoOrdinate()] == 1)
				&& (board[posicion.getXCoOrdinate() + 2][posicion
						.getYCoOrdinate()] == 0)) {
			return true;
		}
		return false;
	}

	public boolean puedemoverDerecha(XYLocation posicion) {
		if (posicion.getXCoOrdinate() < this.tam
				&& posicion.getYCoOrdinate() < (this.tam - 2)
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] == 1)
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() + 1] == 1)
				&& (board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() + 2] == 0)) {
			return true;
		}
		return false;

	}

	public void moverIzquierda(XYLocation posicion) {
		this.fichasRestantes--;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] = 0;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() - 1] = 0;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() - 2] = 1;
	}

	public void moverDerecha(XYLocation posicion) {
		this.fichasRestantes--;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] = 0;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() + 1] = 0;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate() + 2] = 1;
	}

	public void moverAbajo(XYLocation posicion) {
		this.fichasRestantes--;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] = 0;
		this.board[posicion.getXCoOrdinate() + 1][posicion.getYCoOrdinate()] = 0;
		this.board[posicion.getXCoOrdinate() + 2][posicion.getYCoOrdinate()] = 1;
	}

	public void moverArriba(XYLocation posicion) {
		this.fichasRestantes--;
		this.board[posicion.getXCoOrdinate()][posicion.getYCoOrdinate()] = 0;
		this.board[posicion.getXCoOrdinate() - 1][posicion.getYCoOrdinate()] = 0;
		this.board[posicion.getXCoOrdinate() - 2][posicion.getYCoOrdinate()] = 1;
	}

	public int hashCode() {
		int result = 17;
		for (int i = 0; i < this.tam; i++) {
			for (int j = 0; j < this.tam; j++) {
				if (this.board[i][j] == 1)
					result = 37 * result + new XYLocation(i, j).hashCode();
			}
		}
		return result;
	}

	public boolean equals(Object o) {
		char board2[][] = ((SenkuBoard) o).board;
		for (int x = 0; x < this.tam; x++) {
			for (int y = 0; y < this.tam; y++) {
				if (board2[x][y] != this.board[x][y])
					return false;
			}
		}

		return true;

	}

}