package myimplementation;

import lombok.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@RequiredArgsConstructor
public class Node implements Comparable {
    private final String name;
    private List<Node> shortestPath=new LinkedList<Node>();
    private int distance=Integer.MAX_VALUE;
    private Map<Node,Integer> adjacentNodes=new HashMap<>();
public void addAdjacentNode(Node node,int weight){
    adjacentNodes.put(node,weight);
}
    @Override
    public int compareTo(Object o) {
       return Integer.compare(this.distance, ((Node)o).getDistance());

    }
}
