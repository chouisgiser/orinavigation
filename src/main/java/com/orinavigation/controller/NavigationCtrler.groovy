package com.orinavigation.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Chou on 2017/8/1.
 */
@RestController
class NavigationCtrler {
    @RequestMapping (value = '/hello')
    String getIndex(){
        //String str = "hello world"
        return "index.html"
    }
}
