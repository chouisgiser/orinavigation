package com.orinavigation.entity

import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by Chou on 2017/8/2.
 */
@XmlRootElement (name = 'edgebean')
class EdgeBean {
    int edgeid;
    int startnid;
    int endnid;
    int storeyid;
    int weight;
}
