package com.orinavigation.service

import com.orinavigation.dao.IEdgeDao
import com.orinavigation.dao.INodeDao
import com.orinavigation.dao.IPOIDao
import com.orinavigation.datatype.Edge
import com.orinavigation.datatype.Network
import com.orinavigation.datatype.Node
import com.orinavigation.datatype.Path
import com.orinavigation.entity.EdgeBean
import com.orinavigation.entity.NodeBean
import com.orinavigation.entity.PoiBean
import com.orinavigation.utility.DijkstraPCImplByHeap
import com.orinavigation.utility.IPathComputation
import com.vividsolutions.jts.geom.Coordinate
import net.sf.json.JSONArray
import net.sf.json.JSONObject
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * Created by Chou on 2017/8/2.
 */
@Service ('routingServiceImpl')
class RoutingServiceImpl implements IRoutingService {
    @Resource
    INodeDao iNodeDao
    @Resource
    IEdgeDao iEdgeDao
    @Resource
    IPOIDao iPoiDao

    @Override
    JSONObject routingByName(String startPlace, String endPlace) {
        JSONObject routingResult = new JSONObject()

        Network network = constructNetwork()
        PoiBean startPoi = iPoiDao.getPOIByName(startPlace)
        PoiBean endPoi = iPoiDao.getPOIByName(endPlace)
        if (startPoi == null || endPoi == null){
            routingResult.put("code",201)
            routingResult.put("message","Without such a place")
        }
        else{
            routingResult.put("code",200)
            Node startNode = network.getNodeById(startPoi.nid)
            Node endNode = network.getNodeById(endPoi.nid)
            IPathComputation iPathComputation = new DijkstraPCImplByHeap()
            Path path = iPathComputation.shortestPath(network,startNode,endNode)
            if(path== null){
                routingResult.put("message","These two places are not connected")
            }
            else{
                JSONObject jsonObject = new JSONObject()
                JSONArray jsonArray = new JSONArray()
                for (int m = 0; m < path.nodesequence.size(); m++){
                    NodeBean nodeBean = iNodeDao.getNode(path.nodesequence.get(m).getFromid())
                    jsonObject = JSONObject.fromObject(nodeBean)
                    jsonArray.add(jsonObject)
                }
                routingResult.put("data",jsonArray)
                routingResult.put("distance",path.distance)
            }
        }
        return routingResult
    }

    Network constructNetwork(){
        List<NodeBean> nodeBeanList = iNodeDao.getNodes()

        List<Node> nodeList = new ArrayList<Node>()
        for(int i=0; i < nodeBeanList.size(); i++){
            NodeBean nodeBean = nodeBeanList.get(i)
            Node node =  new Node(nodeBean.nodeid)
            Coordinate coordinate = new Coordinate(nodeBean.x_cooridiante,nodeBean.y_cooridiante)
            node.setCoordinate(coordinate)

            if(iEdgeDao.getEdgeByStart(nodeBean.nodeid).size() > 0){
                List<EdgeBean> edgeBeanList = iEdgeDao.getEdgeByStart(nodeBean.nodeid)
                Edge edge = new Edge(edgeBeanList.get(0).endnid,edgeBeanList.get(0).weight)
                node.setFirstEdge(edge)
                for(int j = 1; j < edgeBeanList.size(); j++){
                    Edge tempEdge = new Edge(edgeBeanList.get(j).endnid,edgeBeanList.get(j).weight)
                    edge.setNextEdge(tempEdge)
                    edge = tempEdge
                }
            }
            nodeList.add(node)
        }
        Network network = new Network(nodeList)
        return network
    }

}
