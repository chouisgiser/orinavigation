package com.orinavigation.utility;

import com.orinavigation.datatype.Edge;
import com.orinavigation.datatype.Network;
import com.orinavigation.datatype.Node;
import com.orinavigation.datatype.Path;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Chou on 2017/7/31.
 */
public class DijkstraPCImplByHeap implements IPathComputation{
    public static Comparator<Node> nodeComparator = new Comparator<Node>(){
        @Override
        public int compare(Node o1, Node o2) {
            return (int) (o1.getDis2st()-o2.getDis2st());
        }
    };

    @Override
    public Path shortestPath(Network network, Node stnode, Node endnode) {
        //int networkSize = network.getNum();
        //int[] pathrecord = new int[networkSize];

        PriorityQueue<Node> queue = new PriorityQueue<>(11,nodeComparator);
        stnode.setDis2st(0);
        queue.offer(stnode);

        while(!queue.isEmpty()){
            Node topnode = queue.poll();
            int preid = topnode.getFromid();
            if(topnode.getVisited())
                continue;
            topnode.setVisited(true);
            Edge tempEdge = topnode.getFirstEdge();
            while(tempEdge!=null){
                int destid = tempEdge.getDestid();
                Node nextnode = network.getNodeById(destid);
                double tempWeight = tempEdge.getWeight();
                if(!nextnode.getVisited() && (topnode.getDis2st()+tempWeight)<nextnode.getDis2st()){
                    nextnode.setDis2st(topnode.getDis2st()+tempWeight);
                    nextnode.setPreid(preid);
                    queue.offer(nextnode);
                }
                tempEdge = tempEdge.getNextEdge();
            }
        }

        Path path = new Path();
        path.nodesequence.addFirst(endnode);
        int preid = endnode.getPreid();
        while( preid > 0 && preid!=(stnode.getFromid())){
            Node preNode = network.getNodeById(preid);
            path.nodesequence.addFirst(preNode);
            preid = preNode.getPreid();
        }
        path.nodesequence.addFirst(stnode);
        path.distance = endnode.getDis2st();
        return path;
    }


/*    public double[] initNetwork (Network network,Node stnode,int[] pathrecord){
        int networkSize = network.getNum();
        double[] disArray = new double[networkSize];
        for(int i = 0; i<networkSize; i++){
            disArray[i] = Double.MAX_VALUE;
            pathrecord[i] = -1;
        }

        Edge tempEdge = stnode.getFirstEdge();
        while(tempEdge!=null){
            int destid = tempEdge.getDestid();
            disArray[destid-1] = tempEdge.getWeight();
            pathrecord[destid-1] = stnode.getFromid();
            tempEdge = tempEdge.getNextEdge();
        }

        return disArray;
    }*/
}
