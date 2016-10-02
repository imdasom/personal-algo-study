import java.util.List;

/**
 * Created by dasom on 2016-09-28.
 */
public class Main {

    public static void main(String[] args){
        DirectedGraph directedGraph = new DirectedGraph();
        /*directedGraph.insertVertext("A");
        directedGraph.insertVertext("B");
        directedGraph.insertVertext("C");
        directedGraph.insertVertext("D");
        directedGraph.insertVertext("E");

        directedGraph.insertEdge("A", new Edge("B", 4));
        directedGraph.insertEdge("A", new Edge("C", 1));
        directedGraph.insertEdge("B", new Edge("E", 4));
        directedGraph.insertEdge("C", new Edge("B", 2));
        directedGraph.insertEdge("C", new Edge("D", 4));
        directedGraph.insertEdge("D", new Edge("E", 4));*/


        directedGraph.insertVertext(1);
        directedGraph.insertVertext(2);
        directedGraph.insertVertext(3);
        directedGraph.insertVertext(4);
        directedGraph.insertVertext(5);
        directedGraph.insertVertext(6);
        directedGraph.insertVertext(7);
        directedGraph.insertVertext(8);
        directedGraph.insertEdge(1, new Edge(2, 1));
        directedGraph.insertEdge(1, new Edge(3, 2));
        directedGraph.insertEdge(1, new Edge(5, 7));
        directedGraph.insertEdge(2, new Edge(1, 1));
        directedGraph.insertEdge(2, new Edge(4, 2));
        directedGraph.insertEdge(2, new Edge(7, 4));
        directedGraph.insertEdge(3, new Edge(1, 2));
        directedGraph.insertEdge(3, new Edge(6, 5));
        directedGraph.insertEdge(4, new Edge(2, 2));
        directedGraph.insertEdge(4, new Edge(7, 1));
        directedGraph.insertEdge(5, new Edge(1, 7));
        directedGraph.insertEdge(5, new Edge(6, 3));
        directedGraph.insertEdge(5, new Edge(7, 2));
        directedGraph.insertEdge(6, new Edge(3, 5));
        directedGraph.insertEdge(6, new Edge(5, 3));
        directedGraph.insertEdge(6, new Edge(8, 2));
        directedGraph.insertEdge(7, new Edge(2, 4));
        directedGraph.insertEdge(7, new Edge(4, 1));
        directedGraph.insertEdge(7, new Edge(5, 2));
        directedGraph.insertEdge(8, new Edge(6, 2));
        directedGraph.insertEdge(8, new Edge(7, 6));

        int         vertexSize = directedGraph.getVertexSize();
        int[]       weights = new int[vertexSize];
        boolean[]   visited = new boolean[vertexSize];

        for(int i=0; i<vertexSize; i++){
            weights[i] = 999;
            visited[i] = false;
        }

        String    visitedRecord =  "";
        int      startVertex  = 1;
        int      endVertex    = 8;
        //int         targetVertex = (int)valueOf(startVertex);
        int      targetVertex = startVertex;

        while(isNotFinished(visited)){
            // 첫번째, 방문한다.
            visited[targetVertex-1] = true;
            visitedRecord = visitedRecord + " -> " + /*(String)valueOf(targetVertex)*/targetVertex;
            System.out.println("경로   : " + visitedRecord);

            // 두번째, 인전한 정점에 가중치를 더한다(체크한다)
            List<Edge> edges = directedGraph.getEdgeList(/*(String)valueOf(targetVertex)*/targetVertex);
            int targetWeight = 0;
            if(weights[targetVertex-1] == 999){
                targetWeight = 0;
            }else{
                targetWeight = weights[targetVertex-1];
            }

            for(Edge e : edges){
                // 새로 찾은 가중치가 더 작으면 변경한다.
                int newWeight = targetWeight + e.getWeight();
                int oldWeight = weights[/*(int)valueOf(e.getVertex())*/(int)e.getVertex()-1];
                if(newWeight < oldWeight){
                    weights[/*(int)valueOf(e.getVertex())*/(int)e.getVertex()-1] = newWeight;
                }

                System.out.println("인접정점     : " + e.getVertex());
                System.out.println("토탈 가중치  : " + weights[/*(int)valueOf(e.getVertex())*/(int)e.getVertex()-1]);
            }

            // 세번째, 인접한 정점 중 Total 가중치가 가장 작은 정점을 찾는다.
            // 단, 방문하지 않은 정점이어야 한다.
            int MIN_VERTEX = 0;
            int MIN_WEIGHT = 0;

            try{
                MIN_VERTEX = /*(int)valueOf(edges.get(0).getVertex())*/(int)edges.get(0).getVertex();
                MIN_WEIGHT = edges.get(0).getWeight();

            }catch (IndexOutOfBoundsException e){
                break;
            }

            for(Edge e : edges){
                int i = /*(int)valueOf(e.getVertex())*/(int)e.getVertex() - 1;
                System.out.println("최소 가중치 찾는 중 : "+e.getVertex()+", "+visited[i]);
                if(!visited[i]){
                    if(weights[i] < MIN_WEIGHT){
                        MIN_VERTEX = i;
                        MIN_WEIGHT = weights[i];
                    }
                }
            }

            targetVertex = MIN_VERTEX;

        }

        System.out.println("------끝------");
        System.out.println("경로   : " + visitedRecord);
        System.out.println("가중치 : " + weights[/*(int)valueOf(endVertex)*/endVertex-1]);
    }

    public static boolean isNotFinished(boolean[] visited){
        for(int i=0; i<visited.length; i++){
            if(!visited[i]) return true;
        }
        return false;
    }

    public static Object valueOf(Object o){
        if(o instanceof String){
            switch ((String)o){
                case "A": return 0;
                case "B": return 1;
                case "C": return 2;
                case "D": return 3;
                case "E": return 4;
                default:  return -1;
            }
        }

        else if(o instanceof Integer){
            switch ((Integer)o){
                case 0: return "A";
                case 1: return "B";
                case 2: return "C";
                case 3: return "D";
                case 4: return "E";
                default:  return "";
            }
        }

        return -1;
    }

    public static void dijkstra(){

    }
}
