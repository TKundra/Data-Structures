package Graph;
import java.util.LinkedList;

public class BridgeInGraph {

    int time = 0;
    int vertices;
    LinkedList<Integer>[] adjacent;
    BridgeInGraph(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    void addEdge(int source, int destination){
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    /*  A recursive function that finds and prints bridges
		using DFS traversal
		u --> The vertex to be visited next
		visited[] --> keeps tract of visited vertices
		disc[] --> Stores discovery times of visited vertices
        parent[] --> Stores parent vertices in DFS tree */
    void bridgeUtil(int u, boolean[] visited, int[] low, int[] disc, int[] parent){
        visited[u] = true;
        int children = 0;
        disc[u] = low[u] = ++time;
        /*
            if (!visited[neighbour]) is true
              * First, compare the low value of both nodes and assign minimum value 
                to parent of neighbour,
                of that neighbour who doesn't have further connected nodes.
                ex- 3 and 4
                    0--1
                   /   \
                  5--3--2
                    /
                   4
              * Secondly, we compare the low value of node 4 with disc value of node 3.
                if (low[neighbour]>disc[u])
                        System.out.println(u + " " + neighbour);
                This will decide whether the edge between nodes 3 and 4 is bridge or not.
			else if (neighbour != parent[u])
                compare low values and update with minimum value.
                ex-
                1---0
                \  /
                 2

                    0   1   2
               low  1   2   3

               when- u=2 , neighbour is 0 then
                low[u] = Math.min(low[u], disc[neighbour])

                    0   1   2
               low  1   2   1

               then low[u] = Math.min(low[u], low[neighbour])
                    0   1   2
               low  1   1   1
        */
        for (int neighbour : adjacent[u]){
            if (!visited[neighbour]){
                children++;
                parent[neighbour] = u;
                bridgeUtil(neighbour,visited,low,disc,parent);
                low[u] = Math.min(low[u], low[neighbour]);
                if (low[neighbour]>disc[u])
                    System.out.println(u + " " + neighbour);
            }else if (neighbour!=parent[u]){
                low[u] = Math.min(low[u], disc[neighbour]);
            }
        }
    }
    /*  DFS based function to find all bridges. It uses recursive
        function bridgeUtil() */
    void bridge(){
        /*  low value indicates whether there is some other early
		    node (based on disc) that can be visited by subtree
            rooted with that node */
        int[] low = new int[vertices];
        /* Stores discovery times of visited vertices */
        int[] disc = new int[vertices];
        /* Stores parent vertices in DFS tree */
        int[] parent = new int[vertices];
        /* keeps tract of visited vertices */
        boolean[] visited = new boolean[vertices];

        for (int i=0; i<vertices; i++){
            parent[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        /*  Call the recursive helper function to find Bridges
            in DFS tree rooted with vertex 'i' */
        for (int i=0; i<vertices; i++)
            if (!visited[i])
                bridgeUtil(i,visited,low,disc,parent);

    }

    public static void main(String[] args){
        BridgeInGraph bridge = new BridgeInGraph(6);
        bridge.addEdge(0,1);
        bridge.addEdge(1,2);
        bridge.addEdge(2,0);
        bridge.addEdge(0,3);
        bridge.addEdge(3,4);
        bridge.bridge();
    }
}
