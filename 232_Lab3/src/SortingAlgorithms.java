
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

		int[][] adjMatrix = {{0,50,-1,80,-1},{-1,0,60,90,-1},{-1,-1,0,-1,40},{-1,-1,20,0,70},{-1,50,-1,-1,0}};
		int length = aj.getLength();
		boolean[][] adjMatrixLowestWeight = new boolean[adjMatrix.length][adjMatrix[0].length];
		int row = 0;
		int col = 0;
		int lowestWeight = 100000;
		boolean complete = false;
		while (complete == false) {
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix[i].length; j++) {
					if (adjMatrix[i][j] < lowestWeight && adjMatrixLowestWeight[i][j] != true && adjMatrix[i][j] > 0) {
						lowestWeight = adjMatrix[i][j];
						row = i;
						col = j;
						
					}
				}
			}
			adjMatrixLowestWeight[row][col] = true;
			if(aj.wasVisited(row) == false || aj.wasVisited(col) == false){
				System.out.println(aj.getVertex(row) + "->" + aj.getVertex(col) + "weight: " + adjMatrix[row][col] );
				aj.setVisited(row, true);
				aj.setVisited(col, true);
			}
			for(int i = 0; i < length; i++){
				int count = 0;
				if(aj.wasVisited(i) == true){
					count++;
				}
				if(length == count){
					complete = true;
				}
			}
			
			lowestWeight = 100000;
		}
		for (int i = 0; i < length; i++) {
			aj.setVisited(i, false); // clears all vertices from being visited
		}

	}

	private void floydWarshallsAlgorithm() {
		System.out.println("Floyd's Algorithm");

	}
}