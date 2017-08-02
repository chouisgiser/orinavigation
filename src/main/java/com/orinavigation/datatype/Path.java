package com.orinavigation.datatype;

import java.util.LinkedList;

/**
 * Created by Chou on 2017/7/31.
 */
public class Path {
    public LinkedList<Node> nodesequence;
    public double distance;

    public Path(){
        this.nodesequence = new LinkedList<Node>();
        this.distance = 0;
    }
}
