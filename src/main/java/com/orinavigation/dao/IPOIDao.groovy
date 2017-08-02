package com.orinavigation.dao

import com.orinavigation.entity.PoiBean
import org.springframework.stereotype.Repository

/**
 * Created by wangrui1 on 2017/6/6.
 */
@Repository
interface IPOIDao {
    List<PoiBean> getPOILikeName(String name)
    PoiBean getPOI(int pid)
    PoiBean getPOIByName(String name)
}