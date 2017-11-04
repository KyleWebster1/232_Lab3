/**
 * Created by kylewebster1 on 10/30/17.
 */
public class SortingAlgorithms {
    AdjacencyMatrix aj;
    public SortingAlgorithms(AdjacencyMatrix a) {
        this.aj = a;
        primsAlgorithm();
        kruskalsAlgorithm();
        floydWarshallsAlgorithm();
    }

    private void primsAlgorithm()
    {
        System.out.println("Prim's Algorithm Minimum Spanning Tree:");
        int[][] am = aj.getAdjacencyMatrix();
        int length = aj.getLength();
        int y = 0;
        int x = 0;
        aj.setVisited(x, true);
        for(int l = 0; l < length-1; l++) //always 1 edge less then the vertices for Prim's Algorithm
        {
            int shortest = 999999999; //999999999 is the largest an integer can be, leaving shortest to keep looking for the smaller integer
            for(int i = 0; i < length; i++)
            {
                if (aj.wasVisited(i)) {

                    for (int j = 0; j < 5; j++) {

                        if (!aj.wasVisited(j)) {

                            if (shortest > am[i][j] && am[i][j]!=0 && am[i][j]!=-1) {
                                y = j;//keeps track of minimum y value
                                x = i;//keeps track of minimum x value
                                shortest = am[i][j];
                            }
                        }
                    }
                }
            }
            System.out.println(aj.getVertex(x) + "->" + aj.getVertex(y) + " weight: " + shortest);
            am[x][y] = 999999999; //sets smallest point to the largest integer
            aj.setVisited(y, true);
        }
        for(int i = 0; i < length; i++)
        {
            aj.setVisited(i, false); //clears all vertices from being visited
        }
    }

    private void kruskalsAlgorithm()
    {}

    private void floydWarshallsAlgorithm()
    {}
}
