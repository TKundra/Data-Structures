package Graph;

// uses dynamic programing approach
/* Directed Weighted Graph */
public class FloydWarShall {

    static final int INF = 9999;
    int vertices;
    FloydWarShall(int vertices){
        this.vertices = vertices;
    }

    void floydW(int[][] graph){
        int[][] distance =  new int[vertices][vertices];
        int i,j,k;
        /* initialize solution matrix as input graph matrix */
        for (i=0; i<vertices; i++){
            for (j=0; j<vertices; j++){
                distance[i][j] = graph[i][j];
            }
        }
        for (k=0; k<vertices; k++){
            // pick all vertices as source one by one
            for (i=0; i<vertices; i++){
                for (j=0; j<vertices; j++){
                    if (distance[i][k] + distance[k][j] < distance[i][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
        printSolution(distance);
    }

    void printSolution(int[][] distance){
        for (int i=0; i<vertices; i++){
            for (int j=0; j<vertices; j++){
                if (distance[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] graph = {
                {0, 9, -4, INF},
                {6, 0, INF, 2},
                {INF, 5, 0, INF},
                {INF, INF, 1, 0}
        };
        FloydWarShall floyd = new FloydWarShall(graph.length);
        floyd.floydW(graph);
    }
}














