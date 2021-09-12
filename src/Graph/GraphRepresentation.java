package Graph;
import java.util.LinkedList;

public class GraphRepresentation {

    /* List Representation */
    int vertices;
    LinkedList<Integer>[] adjacent;

    GraphRepresentation(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        /*
            0 -> 1 -> 2 -> 3
            1 -> 0 -> 2
            2 -> 0 -> 1
            3 -> 0
        */
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    void addEdge(int source, int destination){
        /* undirected graph */
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    void print(){
        for (int i=0; i<vertices; i++){
            System.out.print(i+" -> ");
            for (int j=0; j<adjacent[i].size(); j++)
                System.out.print(adjacent[i].get(j)+" ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        GraphRepresentation graph = new GraphRepresentation(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.print();
    }
}
