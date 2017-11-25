import java.lang.Math;

public class SortingAlgorithms {
	AdjacencyMatrix aj;

	public SortingAlgorithms(AdjacencyMatrix a) {
		this.aj = a;
		primsAlgorithm();
		kruskalsAlgorithm();
		floydWarshallsAlgorithm();
	}

	private void primsAlgorithm() {
		System.out.println("Prim's Algorithm Minimum Spanning Tree:");
		int[][] am = aj.getAdjacencyMatrix();
		int length = aj.getLength();
		int y = 0;
		int x = 0;
		aj.setVisited(x, true);
		for (int l = 0; l < length - 1; l++) // always 1 edge less then the
												// vertices for Prim's Algorithm
		{
			int shortest = 999999999; // 999999999 is the largest an integer can
										// be, leaving shortest to keep looking
										// for the smaller integer
			for (int i = 0; i < length; i++) {
				if (aj.wasVisited(i)) {

					for (int j = 0; j < 5; j++) {

						if (!aj.wasVisited(j)) {

							if (shortest > am[i][j] && am[i][j] != 0 && am[i][j] != -1) {
								y = j;// keeps track of minimum y value
								x = i;// keeps track of minimum x value
								shortest = am[i][j];
							}
						}
					}
				}
			}
			System.out.println(aj.getVertex(x) + "->" + aj.getVertex(y) + " weight: " + shortest);
			am[x][y] = 999999999; // sets smallest point to the largest integer
			aj.setVisited(y, true);
		}
		for (int i = 0; i < length; i++) {
			aj.setVisited(i, false); // clears all vertices from being visited
		}
	}

	private void kruskalsAlgorithm() {
		System.out.println("Kruskals Algorithm");
		AdjacencyMatrix newAdjMatrix = new AdjacencyMatrix();
		int[][] adjMatrix = newAdjMatrix.getAdjacencyMatrix();

		int length = aj.getLength(); // amount of vertices
		boolean[][] adjMatrixLowestWeight = new boolean[adjMatrix.length][adjMatrix[0].length]; // False
																								// True
																								// is
																								// take
																								// array
		int row = 0; // coordinates
		int col = 0;
		int lowestWeight = 100000; // comparable variable
		boolean complete = false; // while loop variable
		int edgeCount = 0; // counting the edges for an exit
		while (complete == false) {
			if (edgeCount == (length - 1)) { // Check for the right amount of
												// edges.
				complete = true;
				break;
			}
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix[i].length; j++) {
					if (adjMatrix[i][j] < lowestWeight && adjMatrixLowestWeight[i][j] != true && adjMatrix[i][j] > 0) {
						lowestWeight = adjMatrix[i][j];// This takes the lowest
														// weight and writes its
														// coordinates
						row = i;
						col = j;

					}
				}
			}
			adjMatrixLowestWeight[row][col] = true;// Sets the coordinates to
													// taken

			System.out.println(aj.getVertex(row) + "->" + aj.getVertex(col) + " weight: " + adjMatrix[row][col]); // Prints
																													// the
																													// edge
			aj.setVisited(row, true);// The vertices are visited
			aj.setVisited(col, true);

			edgeCount++;
			lowestWeight = 100000;
		}
		for (int i = 0; i < length; i++) {
			aj.setVisited(i, false); // clears all vertices from being visited
		}

	}

	private void floydWarshallsAlgorithm() {
		System.out.println("--------------");
		System.out.println();
		System.out.println("Floyd's Algorithm");
		// This is a mess....
		AdjacencyMatrix newAdjMatrix = new AdjacencyMatrix();
		int[][] adjMatrix = newAdjMatrix.getAdjacencyMatrix();

		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[i][j] == -1) {
					adjMatrix[i][j] = (int) Double.POSITIVE_INFINITY; // Sets
																		// all
																		// -1 to
																		// infinity
				}
			}
		}

		for (int h = 0; h < adjMatrix.length; h++) {
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix.length; j++) {
					if (adjMatrix[i][h] != (int) Double.POSITIVE_INFINITY
							&& adjMatrix[h][j] != (int) Double.POSITIVE_INFINITY) {
						if (adjMatrix[i][h] + adjMatrix[h][j] < adjMatrix[i][j]) { // Floyd's
																					// Algorithm
							adjMatrix[i][j] = adjMatrix[i][h] + adjMatrix[h][j];

						}

						// adjMatrix[i][j] = Math.min(adjMatrix[i][h]
						// +adjMatrix[h][j], adjMatrix[i][j]);
					}
				}
			}
			for (int k = 0; k < adjMatrix.length; k++) { // Printing.
				for (int l = 0; l < adjMatrix.length; l++) {
					if (adjMatrix[k][l] != (int) Double.POSITIVE_INFINITY) {
						System.out.print(adjMatrix[k][l] + " ");
					} else {
						System.out.print("INF ");
					}

				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("Shortest Path Matrix");
		for (int i = 0; i < adjMatrix.length; i++) { // Printing.
			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[i][j] != (int) Double.POSITIVE_INFINITY) {
					System.out.print(adjMatrix[i][j] + " ");
				} else {
					System.out.print("INF ");
				}

			}
			System.out.println();
		}

	}
}