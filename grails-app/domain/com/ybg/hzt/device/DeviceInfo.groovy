package com.ybg.hzt.device

class DeviceInfo {

    static belongsTo = [deviceCatalog: DeviceCatalog]

    static constraints = {
    }

    String uid
    String name
    Integer installedCapacity = 0//装机容量

}
