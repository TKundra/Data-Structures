package Graph;
import java.util.LinkedList;

public class ArticulationPoints {

    static final int NIL = -1;
    int time = 0;
    int vertices;
    LinkedList<Integer>[] adjacent;
    ArticulationPoints(int vertices){
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
    void bridgeUtil(int u, boolean[] visited, int[] low, int[] disc, int[] parent, boolean[] ap){
        visited[u] = true;
        int children = 0;
        disc[u] = low[u] = ++time;
        for (int neighbour : adjacent[u]){
            if (!visited[neighbour]){
                children++;
                parent[neighbour] = u;
                bridgeUtil(neighbour,visited,low,disc,parent,ap);
                low[u] = Math.min(low[u], low[neighbour]);

                /* u is an articulation point in following cases
                    (1) u is root of DFS tree and has two or more children. */
                if (parent[u] == NIL && children > 1)
                    ap[u] = true;
                /*  (2) If u is not root and low value of one of its child
                    is more than discovery value of u */
                if (parent[u] != NIL && low[neighbour]>=disc[u])
                    ap[u] = true;

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
        /* store articulation points */
        boolean[] ap = new boolean[vertices];

        for (int i=0; i<vertices; i++){
            parent[i] = NIL;
            ap[i] = false;
            visited[i] = false;
        }

        /*  Call the recursive helper function to find Bridges
            in DFS tree rooted with vertex 'i' */
        for (int i=0; i<vertices; i++) {
            if (!visited[i])
                bridgeUtil(i, visited, low, disc, parent, ap);
        }

        /* Now ap[] contains articulation points, print them */
        for (int i=0; i<vertices; i++){
            if (ap[i])
                System.out.print(i+" ");
        }

    }

    public static void main(String[] args){
        ArticulationPoints points = new ArticulationPoints(6);
        points.addEdge(0,1);
        points.addEdge(1,2);
        points.addEdge(2,0);
        points.addEdge(0,3);
        points.addEdge(3,4);
        points.bridge();
    }
}
