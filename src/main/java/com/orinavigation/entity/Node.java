package com.orinavigation.entity;

public class Node {
    private int fromid; //the start node id of the edge

    private Edge firstEdge; //the first edge whose start node is fromid

    private boolean visited; //tag whether the node is visited

    public Node (int fromid){
        this.fromid = fromid;
        this.firstEdge = null;
        this.visited = false;
    }

    public int getFromid(){
        return fromid;
    }

    public Edge getFirstEdge(){
        return firstEdge;
    }

    public boolean getVisited(){
        return visited;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }
}
