package com.orinavigation.utility;

import com.orinavigation.entity.Network;
import com.orinavigation.entity.Node;

public interface IPathCompution {
    void shortestPath (Network network, Node stnode, Node endnode);
}
