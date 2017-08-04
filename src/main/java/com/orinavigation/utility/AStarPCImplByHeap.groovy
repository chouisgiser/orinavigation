package com.orinavigation.utility

import com.orinavigation.datatype.Edge
import com.orinavigation.datatype.Network
import com.orinavigation.datatype.Node
import com.orinavigation.datatype.Path
import com.vividsolutions.jts.geom.Coordinate

/**
 * Created by Chou on 2017/8/4.
 */
class AStarPCImplByHeap implements IPathComputation{
    public static Comparator<Node> nodeComparator = new Comparator<Node>(){
        @Override
        public int compare(Node o1, Node o2) {
            return (int) (o1.getTotalCost()-o2.getTotalCost());
        }
    };

    @Override
    Path shortestPath(Network network, Node stnode, Node endnode) {
        PriorityQueue<Node> queue = new PriorityQueue<>(11,nodeComparator)
        stnode.setDis2st(0)
        double manhattanDis = hFunManhattan(stnode.getCoordinate(),endnode.getCoordinate())
        stnode.setTotalCost(0+manhattanDis)
        queue.offer(stnode)

        while(!queue.isEmpty()){
            Node topnode = queue.poll()
            int preid = topnode.getFromid()
            if(topnode.getVisited())
                continue
            topnode.setVisited(true)

            Edge tempEdge = topnode.getFirstEdge()
            while(tempEdge!=null){
                int destid =tempEdge.getDestid()
                double tempWeight = tempEdge.getWeight()
                Node nextnode = network.getNodeById(destid)
                double tempManhanttanDis = hFunManhattan(nextnode.getCoordinate(),endnode.getCoordinate())
                double totalCost = tempWeight + tempManhanttanDis
                if(!nextnode.getVisited() && totalCost < nextnode.getTotalCost()) {
                    nextnode.setDis2st(topnode.getDis2st() + tempWeight)
                    nextnode.setTotalCost(totalCost)
                    nextnode.setPreid(preid)
                    queue.offer(nextnode)
                }
                tempEdge = tempEdge.getNextEdge()
            }
        }

        Path path = new Path()
        path.nodesequence.addFirst(endnode)
        int preid = endnode.getPreid()
        while( preid > 0 && preid!=(stnode.getFromid())){
            Node preNode = network.getNodeById(preid)
            path.nodesequence.addFirst(preNode)
            preid = preNode.getPreid()
        }
        path.nodesequence.addFirst(stnode)
        path.distance = endnode.getDis2st()
        return path
    }

    double hFunManhattan(Coordinate coordinateA, Coordinate coordinateB){
        double manhattanDis = Math.abs(coordinateA.x-coordinateB.x)+Math.abs(coordinateA.y-coordinateB.y)
        return manhattanDis
    }
}
