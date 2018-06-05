package com.ybg.hzt.device

class DeviceInfo {

    static constraints = {
        deviceCatalog nullable: true
    }

    String uid = ""
    String name = ""
    Integer installedCapacity = 0//装机容量
    DeviceCatalog deviceCatalog

    def beforeInsert() {
        if (name == "") {
            name = uid
        }
    }

}
