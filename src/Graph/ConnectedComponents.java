package Graph;
import java.util.LinkedList;

public class ConnectedComponents {

    int vertices;
    LinkedList<Integer>[] adjacent;
    ConnectedComponents(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        /*  create new list for each vertex
            such that adjacent node can be stored */
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    void addEdge(int source, int destination){
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    void util(int source, boolean[] visited){
        /* mark current node visited and print it */
        visited[source] = true;
        System.out.print(source+" ");
        for (int neighbour : adjacent[source]){
            if (!visited[neighbour])
                util(neighbour, visited);
        }
    }
    void components(){
        boolean[] visited = new boolean[vertices];
        for (int i=0; i<vertices; i++){
            if (!visited[i]){
                util(i, visited);
                System.out.println(); // for better results
            }
        }
    }

    public static void main(String[] args){
        /*
			  1       4
		    /   \      \
		   0    2       5
		   \   /              6 - 7
		     3                \  /
                               8          */
        ConnectedComponents components = new ConnectedComponents(9);
        components.addEdge(0,1);
        components.addEdge(1,2);
        components.addEdge(2,3);
        components.addEdge(0,3);
        components.addEdge(4,5);
        components.addEdge(6,7);
        components.addEdge(7,8);
        components.addEdge(8,6);
        components.components();
    }
}
