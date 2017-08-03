package com.orinavigation.datatype;

public class Edge {

    private int destid; //the destination node id of the edge

    private Edge nextEdge; //the next edge having the same start node

    private double weight; //the weight of the edge

    public Edge(int destid,double weight){
        this.destid = destid;
        this.weight = weight;
        this.nextEdge = null;
    }

    public Edge(int destid,double weight, Edge edge){
        this.destid = destid;
        this.weight = weight;
        this.nextEdge = edge;
    }

    public int getDestid(){
        return destid;
    }

    public Edge getNextEdge(){
        return nextEdge;
    }

    public double getWeight(){
        return weight;
    }

    public void setNextEdge(Edge nextEdge){
        this.nextEdge = nextEdge;
    }

}
