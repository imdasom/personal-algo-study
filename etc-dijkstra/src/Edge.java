/**
 * Created by dasom on 2016-09-28.
 */
public class Edge<T> {
    private T vertex;
    private int weight;

    public Edge(T vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
