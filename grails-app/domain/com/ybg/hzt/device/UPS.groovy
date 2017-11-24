package com.ybg.hzt.device

class UPS {

    static constraints = {
        siteInfo nullable: true
    }

    String upsId = ""
    String upsCode = ""
    SiteInfo siteInfo
}
