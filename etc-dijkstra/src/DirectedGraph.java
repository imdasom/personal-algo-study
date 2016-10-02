import java.util.ArrayList;
import java.util.List;

/**
 * Created by dasom on 2016-09-28.
 */
public class DirectedGraph<T> {
    private List<Vertex> vertices;
    private int vertexSize;
    private int edgeSize;


    public DirectedGraph(){
        createDirectedGraph();
    }


    public void createDirectedGraph(){
        vertices = new ArrayList<Vertex>();
        vertexSize = 0;
        edgeSize = 0;
    }

    public boolean isEmpty(){
        return vertices.isEmpty();
    }

    public int getVertexSize() {
        return vertexSize;
    }

    public int getEdgeSize() {
        return edgeSize;
    }

    public boolean insertVertext(final T vertex){
        for(Vertex v : vertices){
            if(v.getVertex() == vertex){
                return false;
            }
        }

        vertices.add(new Vertex(vertex));
        vertexSize++;
        return true;
    }

    public boolean insertEdge(T targetVertex, Edge newEdge){
        Vertex targetVertext = null;
        for(Vertex v : vertices){
            if(v.getVertex() == targetVertex){
                targetVertext = v;
                break;
            }
        }
        if(targetVertext == null) return false;

        targetVertext.insertEdge(newEdge);
        edgeSize++;
        return true;
    }

    public List<Edge> getEdgeList(T vertextStr) {
        Vertex targetVertex = null;
        for(Vertex v : vertices){
            if(v.getVertex() == vertextStr){
                targetVertex = v;
                break;
            }
        }
        if(targetVertex == null) return null;
        return targetVertex.getEdges();
    }
}
