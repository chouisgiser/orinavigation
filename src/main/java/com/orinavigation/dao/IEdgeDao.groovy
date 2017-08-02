package com.orinavigation.dao

import com.orinavigation.entity.EdgeBean
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * Created by Chou on 2017/8/2.
 */
@Repository
interface IEdgeDao {
    List<EdgeBean> getEdges()
    EdgeBean getEdge(int edgeid)
    List<EdgeBean> getEdgeByStart(@Param("startnid")int startnid)
    List<EdgeBean> getEdgeByNode(@Param("startnid")int startnid, @Param("endnid") int endnid)
}
