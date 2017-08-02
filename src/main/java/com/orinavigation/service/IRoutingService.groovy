package com.orinavigation.service

import net.sf.json.JSONObject

/**
 * Created by Chou on 2017/8/2.
 */

interface IRoutingService {
    JSONObject routingByName(String startPlace, String endPlace)
}