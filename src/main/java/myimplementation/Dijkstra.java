package myimplementation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dijkstra {
    public void calculateShortestPath(Node sourceNode){
        sourceNode.setDistance(0);
        Set<Node> settled=new HashSet<>();
        PriorityQueue<Node> unsettled=new PriorityQueue<>(Collections.singleton(sourceNode));
        while(!unsettled.isEmpty()){
           Node node= unsettled.poll();
           node.getAdjacentNodes().entrySet().stream()
                   .filter(entry->!settled.contains(entry.getKey()))
                   .forEach(entry->{
                       evaluateDistanceAndShortestPath(entry.getKey(),entry.getValue(),node);
                       unsettled.add(entry.getKey());
                   });
           settled.add(node);
        }
    }

    private void evaluateDistanceAndShortestPath(Node adjacentNode, Integer edgeweight,Node sourceNode) {
        int newDistance=sourceNode.getDistance()+edgeweight;
        if(newDistance<adjacentNode.getDistance()){
            adjacentNode.setDistance(newDistance);
//            List<Node> shortestPath = sourceNode.getShortestPath();
//            shortestPath.add(adjacentNode);
//            adjacentNode.setShortestPath(shortestPath);
            adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList());

        }
    }

    public void printPaths(List<Node> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getName).map(Objects::toString)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()))
            );
        });
    }


}
