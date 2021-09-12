package Graph;

public class Dijkstra {

    void dijkstra(int[][] graph, int source){
        int length = graph.length;
        int[] distance = new int[length];
        boolean[] visited = new boolean[length];

        /*  Initialize all distances as INFINITE and visited[] as false
            Distance of source vertex from itself is always 0 */
        for (int i=0; i<length; i++){
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[source] = 0;

        /* Update the distance between neighbouring vertex and source vertex */
        for (int i=0; i<length; i++){
            int u = findMinimumDistance(distance, visited);
            visited[u] = true;
            for (int v=0; v<length; v++){
                if (!visited[v] && graph[u][v] !=0 && (distance[u] + graph[u][v] < distance[v]))
                    distance[v] = distance[u] + graph[u][v];
            }
        }

        for (int i=0; i<length; i++)
            System.out.printf("distance from %s to %s is %s", source,i,distance[i]+"\n");

    }

    // find minimum distance
    static int findMinimumDistance(int[] distance, boolean[] visited){
        int minimumDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int i=0; i<distance.length; i++){
            if (!visited[i] && distance[i]<minimumDistance){
                minimumDistance = distance[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        /*
                        DISTANCE ARRAY
                        0   1   2   3   4
         u=0, v=1, v=2  0   4   1   I   I
         u=2, v=1, v=3  0   3   1   I   7
         u=1, v=3       0   3   1   4   7
         u=3, v=4       0   3   1   4   7
        */
        int[][] graph = {
                {0,4,1,0,0},
                {0,0,0,1,0},
                {0,2,0,5,0},
                {0,0,0,0,3},
                {0,0,0,0,0}
        };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 0);
    }
}
