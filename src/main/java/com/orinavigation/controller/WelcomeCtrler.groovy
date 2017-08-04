package com.orinavigation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by Chou on 2017/8/4.
 */
@Controller
class WelcomeCtrler {

    @RequestMapping("/welcome")
    String index(){
        return 'index'
    }
}
