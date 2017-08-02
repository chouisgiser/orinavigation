package com.orinavigation.entity

import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by Chou on 2017/8/2.
 */
@XmlRootElement (name = 'nodebean')
class NodeBean {
    int nodeid;
    int buildingid;
    double x_cooridiante;
    double y_cooridiante;
    String type;
    int storeyid;
}
