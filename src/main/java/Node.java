import java.util.Map;

/**
 * Created by satheessh on 7/12/17.
 */
public class Node {

    String id;
    Map<Node, Integer> edges;

    public Node(String id) {
        this.id = id;
    }


    public void addEdge(Node node, int weight) {
        edges.put(node, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id.equals(node.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
