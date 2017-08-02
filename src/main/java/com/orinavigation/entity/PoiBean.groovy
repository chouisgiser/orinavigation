package com.orinavigation.entity

import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by Chou on 2017/8/2.
 */
@XmlRootElement (name = 'poibean')
class PoiBean {
    int pid;
    int nid;
    String name;
}
