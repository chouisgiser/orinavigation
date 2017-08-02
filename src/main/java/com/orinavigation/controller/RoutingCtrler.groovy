package com.orinavigation.controller

import com.orinavigation.service.IRoutingService
import net.sf.json.JSONObject
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * Created by Chou on 2017/8/1.
 */
@RestController
class RoutingCtrler {

    @Resource
    IRoutingService routingServiceImpl

    @RequestMapping (value = '/v1/chou/routing')
    JSONObject getRoute(
            @RequestParam("startLocation") String startLocation,
            @RequestParam("endLocation") String endLocaiton
    ){
        JSONObject routingResult = routingServiceImpl.routingByName(startLocation,endLocaiton)
        return routingResult
    }
}