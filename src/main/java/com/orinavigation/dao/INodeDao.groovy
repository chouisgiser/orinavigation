package com.orinavigation.dao

import com.orinavigation.entity.NodeBean
import org.springframework.stereotype.Repository

/**
 * Created by Chou on 2017/8/2.
 */
@Repository
interface INodeDao {
    List<NodeBean> getNodes()
    NodeBean getNode(int nodeid)
}