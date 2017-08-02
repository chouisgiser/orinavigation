package com.orinavigation.utility;

import com.orinavigation.datatype.Network;
import com.orinavigation.datatype.Node;
import com.orinavigation.datatype.Path;

public interface IPathComputation {
    Path shortestPath (Network network, Node stnode, Node endnode);
}
