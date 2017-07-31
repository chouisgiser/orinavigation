package com.orinavigation.utility;

import com.orinavigation.entity.Network;
import com.orinavigation.entity.Node;
import com.orinavigation.entity.Path;

public interface IPathCompution {
    public Path shortestPath (Network network, Node stnode, Node endnode);
}
