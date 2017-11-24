package com.ybg.hzt.device

class Battery {

    static constraints = {
        siteInfo nullable: true
        ups nullable: true
    }

    String deviceId
    String deviceCode
    Float voltage//电压
    Float temperature//温度
    Float internalResistance//内阻
    Date createTime
    Short flag = 1 as Short
    SiteInfo siteInfo
    UPS ups
}
