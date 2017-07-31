package com.orinavigation.entity;

import java.util.List;

public class Network {
    private int num; // the number of nodes in the network

    private List<Node> nodes; // the nodes list of the network

    public Network(List<Node> nodes){
        this.nodes = nodes;
        this.num = nodes.size();
    }

    public void BFS(Node stnode){

    }

    public void DFS(Node stnode){

    }

    public int getNum(){
        return  num;
    }

    public List<Node> getNodes(){
        return nodes;
    }

}
