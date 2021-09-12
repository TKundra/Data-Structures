package Graph;

public class Prim_sAlgorithm {

    static void prim_s(int[][] graph){
        int length = graph.length;
        // array to store vertices where minimum value is
        int[] vertex = new int[length];
        // key value use to pick minimum edge weight
        int[] key = new int[length];
        // represent set of vertices included in MST
        boolean[] visited = new boolean[length];

        for (int i=0; i<length; i++){
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        key[0] = 0;
        vertex[0] = -1;

        for (int i=0; i<length-1; i++){
            int u = findMinimumKey(key, visited);
            visited[u] = true;
            /*  Update key value and parent index of the adjacent
			    vertices of the picked vertex. Consider only those
                vertices which are not yet included in MST */
            for (int v=0; v<length; v++){
                /*  graph[u][v] is non zero only for adjacent vertices of m
			        mstSet[v] is false for vertices not yet included in MST
                    Update the key only if graph[u][v] is smaller than key[v] */
                if (!visited[v] && graph[u][v] != 0 && (graph[u][v]<key[v])){
                    key[v] = graph[u][v];
                    vertex[v] = u;
                }
            }
        }
        System.out.println("edge \tweight");
        for (int i=1; i<length; i++)
            System.out.println(vertex[i] + "-" + i + "\t\t" + key[i]);
            /* also System.out.println(vertex[i] + "-" + i + "\t\t" + graph[i][vertex[i]]); */
    }

    // find minimum key
    static int findMinimumKey(int[] key, boolean[] visited){
        int minimumDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int i=0; i<key.length; i++){
            if (!visited[i] && key[i]<minimumDistance){
                minimumDistance = key[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[][] graph = {
                {0,7,8,0,0,0},
                {7,0,3,6,0,0},
                {2,3,0,4,3,0},
                {0,6,4,0,2,5},
                {0,0,3,2,0,2},
                {0,0,0,5,2,0}
        };
        prim_s(graph);
    }
}
