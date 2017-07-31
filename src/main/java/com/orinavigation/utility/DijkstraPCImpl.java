package com.orinavigation.utility;

import com.orinavigation.entity.Edge;
import com.orinavigation.entity.Network;
import com.orinavigation.entity.Node;
import com.orinavigation.entity.Path;

/**
 * Created by Chou on 2017/7/31.
 */
public class DijkstraPCImpl implements IPathCompution{

    @Override
    public Path shortestPath(Network network, Node stnode, Node endnode) {
        int networkSize = network.getNum();
        int[] pathrecord = new int[networkSize];
        double[] disArray = initNetwork(network,stnode,pathrecord);

        disArray[stnode.getFromid()]=0;
        stnode.setVisited(true);
        for(int i = 0; i < networkSize-1;i++){
            Node localNode = stnode;
            Node localNearNode = getLocalNearest(network,localNode,disArray);
            int localNearid = localNearNode.getFromid();

            Edge tempEdge = localNearNode.getFirstEdge();
            while(tempEdge!=null){
                int tempid = tempEdge.getDestid();
                Node nextNode = network.getNodes().get(tempid);
                double tempWeight = tempEdge.getWeight();
                if(!nextNode.getVisited() && (disArray[localNearid]+tempWeight)<disArray[tempid]){
                    disArray[tempid] = disArray[localNearid]+tempWeight;
                    pathrecord[tempid] = localNearid;
                }
            }
        }

        Path path = new Path();
        path.nodesequence.addFirst(endnode);
        int preid = endnode.getFromid();
        while(preid!=stnode.getFromid()){
            Node preNode = network.getNodes().get(preid);
            path.nodesequence.addFirst(preNode);
        }
        path.nodesequence.addFirst(stnode);
        return path;
    }

    public double[] initNetwork (Network network,Node stnode,int[] pathrecord){
        int networkSize = network.getNum();
        double[] disArray = new double[networkSize];
        for(int i = 0; i<networkSize; i++){
            disArray[i] = Double.MAX_VALUE;
            pathrecord[i] = -1;
        }

        Edge tempEdge = stnode.getFirstEdge();
        while(tempEdge!=null){
            int destid = tempEdge.getDestid();
            disArray[destid] = tempEdge.getWeight();
            pathrecord[destid] = stnode.getFromid();
        }

        return disArray;
    }

    public Node getLocalNearest(Network network, Node localNode,double[] disArray){
        Edge tempEdge = localNode.getFirstEdge();
        double tempDis = Double.MAX_VALUE;
        Node tempNode = null;
        while(tempEdge!=null){
            int tempid = tempEdge.getDestid();
            if (!network.getNodes().get(tempid).getVisited() && disArray[tempid]<tempDis){
                tempDis = disArray[tempid];
                tempNode =  network.getNodes().get(tempid);
            }
        }
        tempNode.setVisited(true);
        return tempNode;
    }
}
