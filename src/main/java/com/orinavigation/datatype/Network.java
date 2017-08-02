package com.orinavigation.datatype;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private int num; // the number of nodes in the network

    private ArrayList<Node> nodes; // the nodes list of the network

    public Network(ArrayList<Node> nodes){
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

//    public List<Node> getNodes(){
//        return nodes;
//    }

    public Node getNodeById(int nodeid){
        Node node = null;
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).getFromid() == nodeid)
               node =  nodes.get(i);
        }
        return node;
    }

}
