import java.util.ArrayList;
import java.util.List;

/**
 * Created by dasom on 2016-09-28.
 */
public class Vertex<T> {
    private T vertex;
    private List<Edge> edges;

    public Vertex(T vertex) {
        this.vertex = vertex;
        this.edges = new ArrayList<>();
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public boolean insertEdge(Edge newEdge) {
        for(Edge e : edges){
            if(e.getVertex() == newEdge.getVertex()){
                return false;
            }
        }
        edges.add(newEdge);
        return true;
    }
}
