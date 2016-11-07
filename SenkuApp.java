package aima.gui.applications.search.games;

import aima.core.agent.Action;
import aima.core.environment.senku.HeuristicaBordes;
import aima.core.environment.senku.HeuristicaFichasNoMovibles;
import aima.core.environment.senku.SenkuBoard;
import aima.core.environment.senku.SenkuFunctionFactory;
import aima.core.environment.senku.SenkuGoalTest;
import aima.core.environment.senku.HeuristicaDistancia;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.UniformCostSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.local.SimulatedAnnealingSearch;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class SenkuApp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		System.out.println("Tablero en cruz");

		SenkuWithDepthFirstSearchTree(2);
		SenkuWithDepthFirstSearchGraph(2);
		SenkuBreadthFirstSearchTree(2);
		SenkuBreadthFirstSearchGraph(2);
		SenkuWithUniformCostTree(2);
		SenkuWithUniformCostGraph(2);
		SenkuConDepthLimitedSearch(5, 2);
		SenkuIterativeDeepeningSearch(2);

		SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(2);
		SenkuGreedyBestFirstSearchTreeHeuristicaBordes(2);
		SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(2);

		SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(2);
		SenkuGreedyBestFirstSearchGraphHeuristicaBordes(2);
		SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(2);

		SenkuAStarTreeHeuristicaDistancia(2);
		SenkuAStarTreeHeuristicaBordes(2);
		SenkuAStarTreeHeuristicaNoMovibles(2);

		SenkuAStarGraphHeuristicaDistancia(2);
		SenkuAStarGraphHeuristicaBordes(2);
		SenkuAStarGraphHeuristicaNoMovibles(2);

		SenkuHillClimbingHeuristicaDistancia(2);
		SenkuHillClimbingHeuristicaBordes(2);
		SenkuHillClimbingHeuristicaNoMovibles(2);

		SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(2);
		SenkuWithSimulatedAnnealingSearchHeuristicaBordes(2);
		SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(2);

		System.out.println();

		System.out.println("Tablero en signo mas");

		SenkuWithDepthFirstSearchTree(3);
		SenkuWithDepthFirstSearchGraph(3);
		SenkuBreadthFirstSearchTree(3);
		SenkuBreadthFirstSearchGraph(3);
		SenkuWithUniformCostTree(3);
		SenkuWithUniformCostGraph(3);
		SenkuConDepthLimitedSearch(8, 3);
		SenkuIterativeDeepeningSearch(3);

		SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(3);
		SenkuGreedyBestFirstSearchTreeHeuristicaBordes(3);
		SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(3);

		SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(3);
		SenkuGreedyBestFirstSearchGraphHeuristicaBordes(3);
		SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(3);

		SenkuAStarTreeHeuristicaDistancia(3);
		SenkuAStarTreeHeuristicaBordes(3);
		SenkuAStarTreeHeuristicaNoMovibles(3);

		SenkuAStarGraphHeuristicaDistancia(3);
		SenkuAStarGraphHeuristicaBordes(3);
		SenkuAStarGraphHeuristicaNoMovibles(3);

		SenkuHillClimbingHeuristicaDistancia(3);
		SenkuHillClimbingHeuristicaBordes(3);
		SenkuHillClimbingHeuristicaNoMovibles(3);

		SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(3);
		SenkuWithSimulatedAnnealingSearchHeuristicaBordes(3);
		SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(3);

		System.out.println();
		System.out.println("Tablero en flecha");

		SenkuWithDepthFirstSearchTree(4);
		SenkuWithDepthFirstSearchGraph(4);
		// SenkuBreadthFirstSearchTree(4); se queda sin memoria
		SenkuBreadthFirstSearchGraph(4);
		// SenkuWithUniformCostTree(4); se queda sin memoria
		SenkuWithUniformCostGraph(4);
		SenkuConDepthLimitedSearch(16, 4);
		SenkuIterativeDeepeningSearch(4);

		SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(4);
		SenkuGreedyBestFirstSearchTreeHeuristicaBordes(4);
		SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(4);

		SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(4);
		SenkuGreedyBestFirstSearchGraphHeuristicaBordes(4);
		SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(4);

		SenkuAStarTreeHeuristicaDistancia(4);
		// SenkuAStarTreeHeuristicaBordes(4); parado durante ejecucion porque
		// no devuelve nada
		SenkuAStarTreeHeuristicaNoMovibles(4);

		SenkuAStarGraphHeuristicaDistancia(4);
		SenkuAStarGraphHeuristicaBordes(4);
		SenkuAStarGraphHeuristicaNoMovibles(4);

		SenkuHillClimbingHeuristicaDistancia(4);
		SenkuHillClimbingHeuristicaBordes(4);
		SenkuHillClimbingHeuristicaNoMovibles(4);

		SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(4);
		SenkuWithSimulatedAnnealingSearchHeuristicaBordes(4);
		SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(4);

		System.out.println();
		System.out.println("Tablero en calavera");

		SenkuWithDepthFirstSearchTree(5);
		SenkuWithDepthFirstSearchGraph(5);
		// SenkuBreadthFirstSearchTree(5); se queda sin memoria
		// SenkuBreadthFirstSearchGraph(5); se queda sin memoria
		// SenkuWithUniformCostTree(5); se queda sin memoria
		// SenkuWithUniformCostGraph(5); se queda sin memoria
		// SenkuConDepthLimitedSearch(24, 5); parado durante ejecucion porque no
		// devuelve nada
		// SenkuIterativeDeepeningSearch(5); parado durante ejecucion porque
		// no devuelve nada

		SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(5);
		// SenkuGreedyBestFirstSearchTreeHeuristicaBordes(5); parado durante
		// ejecucion porque no devuelve nada
		// SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(5); parado durante
		// ejecucion porque no devuelve nada

		SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(5);
		SenkuGreedyBestFirstSearchGraphHeuristicaBordes(5);
		// SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(5); parado
		// durante ejecucion porque no devuelve nada

		// SenkuAStarTreeHeuristicaDistancia(5);
		// SenkuAStarTreeHeuristicaBordes(5); parado durante ejecucion
		// porque no devuelve nada
		// SenkuAStarTreeHeuristicaNoMovibles(5); parado durante ejecucion
		// porque no devuelve nada

		SenkuAStarGraphHeuristicaDistancia(5);
		// SenkuAStarGraphHeuristicaBordes(5);se queda sin memoria
		// SenkuAStarGraphHeuristicaNoMovibles(5); parado durante ejecucion

		SenkuHillClimbingHeuristicaDistancia(5);
		SenkuHillClimbingHeuristicaBordes(5);
		SenkuHillClimbingHeuristicaNoMovibles(5);

		SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(5);
		SenkuWithSimulatedAnnealingSearchHeuristicaBordes(5);
		SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(5);

		System.out.println();

		System.out.println("Tablero en piramide");

		SenkuWithDepthFirstSearchTree(6);
		SenkuWithDepthFirstSearchGraph(6);
		// SenkuBreadthFirstSearchTree(6); se queda sin memoria
		SenkuBreadthFirstSearchGraph(6);
		// SenkuWithUniformCostTree(6); se queda sin memoria
		SenkuWithUniformCostGraph(6);
		SenkuConDepthLimitedSearch(15, 6);
		// SenkuIterativeDeepeningSearch(6); parado durante ejecucion porque
		// no devuelve nada

		SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(6);
		SenkuGreedyBestFirstSearchTreeHeuristicaBordes(6);
		// SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(6); parado
		// durante ejecucion porque no devuelve nada

		SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(6);
		SenkuGreedyBestFirstSearchGraphHeuristicaBordes(6);
		SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(6);

		SenkuAStarTreeHeuristicaDistancia(6);
		// SenkuAStarTreeHeuristicaBordes(6); parado durante ejecucion porque
		// no devuelve nada
		// SenkuAStarTreeHeuristicaNoMovibles(6); parado durante ejecucion
		// porque no devuelve nada

		SenkuAStarGraphHeuristicaDistancia(6);
		// SenkuAStarGraphHeuristicaBordes(6); parado durante ejecucion porque
		// no devuelve nada
		SenkuAStarGraphHeuristicaNoMovibles(6);

		SenkuHillClimbingHeuristicaDistancia(6);
		SenkuHillClimbingHeuristicaBordes(6);
		SenkuHillClimbingHeuristicaNoMovibles(6);

		SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(6);
		SenkuWithSimulatedAnnealingSearchHeuristicaBordes(6);
		SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(6);

		System.out.println();

		System.out.println("Tablero en diamante");

		SenkuWithDepthFirstSearchTree(7);
		SenkuWithDepthFirstSearchGraph(7);
		// SenkuBreadthFirstSearchTree(7); sin memoria
		// SenkuBreadthFirstSearchGraph(7); sin memoria
		// SenkuWithUniformCostTree(7); sin memoria
		// SenkuWithUniformCostGraph(7); sin memoria
		SenkuConDepthLimitedSearch(23, 7);
		// SenkuIterativeDeepeningSearch(7); parado durante ejecucion porque
		// no devuelve nada

		SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(7);
		SenkuGreedyBestFirstSearchTreeHeuristicaBordes(7);
		// SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(7); parado
		// durante ejecucion porque no devuelve nada

		SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(7);
		SenkuGreedyBestFirstSearchGraphHeuristicaBordes(7);
		// SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(7); parado
		// durante ejecucion porque no devuelve nada

		// SenkuAStarTreeHeuristicaDistancia(7); parado durante ejecucion
		// porque no devuelve nada
		// SenkuAStarTreeHeuristicaBordes(7); parado durante ejecucion porque
		// no devuelve nada
		// SenkuAStarTreeHeuristicaNoMovibles(7); parado durante ejecucion
		// porque no devuelve nada

		// SenkuAStarGraphHeuristicaDistancia(7); parado durante ejecucion
		// porque no devuelve nada
		// SenkuAStarGraphHeuristicaBordes(7); parado durante ejecucion porque
		// no devuelve nada
		SenkuAStarGraphHeuristicaNoMovibles(7);

		SenkuHillClimbingHeuristicaDistancia(7);
		SenkuHillClimbingHeuristicaBordes(7);
		SenkuHillClimbingHeuristicaNoMovibles(7);

		SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(7);
		SenkuWithSimulatedAnnealingSearchHeuristicaBordes(7);
		SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(7);
		System.out.println();
		System.out.println("Tablero completo");

		SenkuWithDepthFirstSearchTree(1);
		SenkuWithDepthFirstSearchGraph(1);
		// SenkuBreadthFirstSearchTree(1); sin memoria
		// SenkuBreadthFirstSearchGraph(1); sin memoria
		// SenkuWithUniformCostTree(1); sin memoria
		// SenkuWithUniformCostGraph(1); sin memoria
		SenkuConDepthLimitedSearch(31, 1);
		// SenkuIterativeDeepeningSearch(1); parado durante ejecucion porque
		// no
		// devuelve nada

		// SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(1); parado
		// durante
		// ejecucion porque no devuelve nada
		// SenkuGreedyBestFirstSearchTreeHeuristicaBordes(1); parado durante
		// ejecucion porque no devuelve nada
		// SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(1); parado
		// durante
		// ejecucion porque no devuelve nada

		// SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(1);parado
		// durante
		// ejecucion porque no devuelve nada
		// SenkuGreedyBestFirstSearchGraphHeuristicaBordes(1); parado durante
		// ejecucion porque no devuelve nada
		// SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(1); parado
		// durante ejecucion porque no devuelve nada

		// SenkuAStarTreeHeuristicaDistancia(1); parado porque no devuelve
		// nada
		// SenkuAStarTreeHeuristicaBordes(1); parado porque no devuelve nada
		// SenkuAStarTreeHeuristicaNoMovibles(1); parado durante ejecucion
		// porque no devuelve nada

		SenkuAStarGraphHeuristicaDistancia(1);
		// SenkuAStarGraphHeuristicaBordes(1); parado durante ejecucion
		// porque
		// no devuelve nada
		// SenkuAStarGraphHeuristicaNoMovibles(1); parado durante ejecucion
		// porque no devuelve nada

		SenkuHillClimbingHeuristicaDistancia(1);
		SenkuHillClimbingHeuristicaBordes(1);
		SenkuHillClimbingHeuristicaNoMovibles(1);

		SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(1);
		SenkuWithSimulatedAnnealingSearchHeuristicaBordes(1);
		SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(1);

		System.out.println("FIN");
	}

	// Busqueda en profundidad en arbol

	private static void SenkuWithDepthFirstSearchTree(int idTablero) {
		try {
			System.out.println("SenkuPegsDemo DFS (Tree)");

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new DepthFirstSearch(new TreeSearch());
			long timeI = System.currentTimeMillis();
			SearchAgent agent2 = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent2.getActions());
			printInstrumentation(agent2.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	private static void SenkuWithDepthFirstSearchGraph(int idTablero) {
		System.out.println("SenkuPegsDemo DFS (Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new DepthFirstSearch(new GraphSearch());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// busqueda en anchura en arbol

	private static void SenkuBreadthFirstSearchTree(int idTablero) {
		System.out.println("SenkuPegsDemo BFS (Tree)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new BreadthFirstSearch(new TreeSearch());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// busqueda en anchura en grafo

	private static void SenkuBreadthFirstSearchGraph(int idTablero) {
		System.out.println("SenkuPegsDemo BFS (Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new BreadthFirstSearch(new GraphSearch());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Busqueda en profundidad en grafo

	private static void SenkuWithUniformCostTree(int idTablero) {
		try {
			System.out.println("SenkuPegsDemo UC (Tree)");
			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new UniformCostSearch(new TreeSearch());
			long timeI = System.currentTimeMillis();
			SearchAgent agent2 = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent2.getActions());
			printInstrumentation(agent2.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	private static void SenkuWithUniformCostGraph(int idTablero) {
		try {
			System.out.println("SenkuPegsDemo UC (Graph)");
			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new UniformCostSearch(new GraphSearch());
			long timeI = System.currentTimeMillis();
			SearchAgent agent2 = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent2.getActions());
			printInstrumentation(agent2.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	private static void SenkuConDepthLimitedSearch(int limite, int idTablero) {
		try {
			System.out.println("SenkuPegsDemo DLS (" + limite + ")");

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new DepthLimitedSearch(limite);
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// busqueda por profundidad iterativa

	private static void SenkuIterativeDeepeningSearch(int idTablero) {
		System.out.println("SenkuDemo Iterative DS");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new IterativeDeepeningSearch();
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Greedy Best First Search Distancia Tree

	private static void SenkuGreedyBestFirstSearchTreeHeuristicaDistancia(
			int idTablero) {
		System.out
				.println("SenkuPegsDemo Greedy Best First Search (Heuristica Distancia)(Tree)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new GreedyBestFirstSearch(new TreeSearch(),
					new HeuristicaDistancia());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Greedy Best First Search Bordes Tree

	private static void SenkuGreedyBestFirstSearchTreeHeuristicaBordes(
			int idTablero) {
		System.out
				.println("SenkuPegsDemo Greedy Best First Search (Heuristica Bordes)(Tree)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new GreedyBestFirstSearch(new TreeSearch(),
					new HeuristicaBordes());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Greedy Best First Search FichasNoMovibles Tree

	private static void SenkuGreedyBestFirstSearchTreeHeuristicaNoMovibles(
			int idTablero) {
		System.out
				.println("SenkuPegsDemo Greedy Best First Search (Heuristica Fichas No Movibles)(Tree)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new GreedyBestFirstSearch(new TreeSearch(),
					new HeuristicaFichasNoMovibles());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Greedy Best First Search Distancia Graph

	private static void SenkuGreedyBestFirstSearchGraphHeuristicaDistancia(
			int idTablero) {
		System.out
				.println("SenkuPegsDemo Greedy Best First Search (Heuristica Distancia)(Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new GreedyBestFirstSearch(new GraphSearch(),
					new HeuristicaDistancia());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Greedy Best First Search Bordes Graph

	private static void SenkuGreedyBestFirstSearchGraphHeuristicaBordes(
			int idTablero) {
		System.out
				.println("SenkuPegsDemo Greedy Best First Search (Heuristica Bordes)(Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new GreedyBestFirstSearch(new GraphSearch(),
					new HeuristicaBordes());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Greedy Best First Search FichasNoMovibles Graph

	private static void SenkuGreedyBestFirstSearchGraphHeuristicaNoMovibles(
			int idTablero) {
		System.out
				.println("SenkuPegsDemo Greedy Best First Search (Heuristica Fichas No Movibles)(Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new GreedyBestFirstSearch(new GraphSearch(),
					new HeuristicaFichasNoMovibles());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A Star Distancia Tree

	private static void SenkuAStarTreeHeuristicaDistancia(int idTablero) {
		System.out
				.println("SenkuPegsDemo AStar Search (Heuristica Distancia)(Tree)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new AStarSearch(new TreeSearch(),
					new HeuristicaDistancia());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A Star Bordes Tree

	private static void SenkuAStarTreeHeuristicaBordes(int idTablero) {
		System.out
				.println("SenkuPegsDemo AStar Search (Heuristica Bordes)(Tree)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new AStarSearch(new TreeSearch(),
					new HeuristicaBordes());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A Star Fichas No Movibles Tree

	private static void SenkuAStarTreeHeuristicaNoMovibles(int idTablero) {
		System.out
				.println("SenkuPegsDemo AStar Search (Heuristica Fichas No Movibles)(Tree)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new AStarSearch(new TreeSearch(),
					new HeuristicaFichasNoMovibles());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A Star Distancia Graph

	private static void SenkuAStarGraphHeuristicaDistancia(int idTablero) {
		System.out
				.println("SenkuPegsDemo AStar Search (Heuristica Distancia)(Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new AStarSearch(new GraphSearch(),
					new HeuristicaDistancia());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A Star Bordes Graph

	private static void SenkuAStarGraphHeuristicaBordes(int idTablero) {
		System.out
				.println("SenkuPegsDemo AStar Search (Heuristica Bordes)(Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new AStarSearch(new GraphSearch(),
					new HeuristicaBordes());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// A Star FichasNoMoviles Graph

	private static void SenkuAStarGraphHeuristicaNoMovibles(int idTablero) {
		System.out
				.println("SenkuPegsDemo AStar Search (Heuristica Fichas No Movibles)(Graph)");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			Search search = new AStarSearch(new GraphSearch(),
					new HeuristicaFichasNoMovibles());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// HillClimbing Distancia

	private static void SenkuHillClimbingHeuristicaDistancia(int idTablero) {
		System.out.println("Senku Escalada con heuristica Distancia");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			HillClimbingSearch search = new HillClimbingSearch(
					new HeuristicaDistancia());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// HillClimbing Bordes

	private static void SenkuHillClimbingHeuristicaBordes(int idTablero) {
		System.out.println("Senku Escalada con heuristica Bordes");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			HillClimbingSearch search = new HillClimbingSearch(
					new HeuristicaBordes());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// HillClimbing FichasNoMovibles

	private static void SenkuHillClimbingHeuristicaNoMovibles(int idTablero) {
		System.out.println("Senku Escalada con heuristica Fichas No Movibles");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			HillClimbingSearch search = new HillClimbingSearch(
					new HeuristicaFichasNoMovibles());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Simulated Annealing Distancia

	private static void SenkuWithSimulatedAnnealingSearchHeuristicaDistancia(
			int idTablero) {
		System.out
				.println("Senku SimulatedAnnealingSearch con Heuristica Distancia");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(
					new HeuristicaDistancia());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Simulated Annealing Bordes

	private static void SenkuWithSimulatedAnnealingSearchHeuristicaBordes(
			int idTablero) {
		System.out
				.println("Senku SimulatedAnnealingSearch con Heuristica Bordes");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(
					new HeuristicaBordes());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Simulated Annealing FichasNoMovibles

	private static void SenkuWithSimulatedAnnealingSearchHeuristicaNoMovibles(
			int idTablero) {
		System.out
				.println("Senku SimulatedAnnealingSearch con Heuristica Fichas No Movibles");
		try {

			Problem problem = new Problem(new SenkuBoard(idTablero),
					SenkuFunctionFactory.getActionsFunction(),
					SenkuFunctionFactory.getResultFunction(),
					new SenkuGoalTest());

			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(
					new HeuristicaFichasNoMovibles());
			long timeI = System.currentTimeMillis();
			SearchAgent agent = new SearchAgent(problem, search);
			long timeF = System.currentTimeMillis();
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
			printTimeExecution(timeI, timeF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		System.out.println("\nprintInstrumentation  -->");
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List<Action> actions) {
		System.out.println("\nprintActions  -->");
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}

	private static void printTimeExecution(long timeI, long timeF) {
		long milisegundos = timeF - timeI;
		long hora = milisegundos / 3600000;
		long restohora = milisegundos % 3600000;
		long minuto = restohora / 60000;
		long restominuto = restohora % 60000;
		long segundo = restominuto / 1000;
		long restosegundo = restominuto % 1000;
		System.out.println("\nTimeExecution---> " + hora + ":" + minuto + ":"
				+ segundo + "." + restosegundo);
	}

}
