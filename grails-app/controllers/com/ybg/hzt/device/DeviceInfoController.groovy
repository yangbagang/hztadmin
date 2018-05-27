package com.ybg.hzt.device

import com.ybg.hzt.vo.AjaxPagingVo
import grails.converters.JSON

class DeviceInfoController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index() {
        [catalogList: DeviceCatalog.all]
    }

    def create() {
        [catalogList: DeviceCatalog.all]
    }

    def list(String uid) {
        def c = DeviceInfo.createCriteria()
        def data = c.list(max: params.length, offset: params.start) {
            ilike("uid", "%" + uid + "%")
            order("id", "asc")
        }

        def result = new AjaxPagingVo()
        result.data = data
        result.draw = Integer.valueOf(params.draw)
        result.error = ""
        result.success = true
        result.recordsTotal = data.totalCount
        result.recordsFiltered = data.totalCount
        render result as JSON
    }

    def edit(DeviceInfo deviceInfo) {
        [deviceInfo: deviceInfo, catalogList: DeviceCatalog.all]
    }

    def save(DeviceInfo deviceInfo) {
        def result = [:]
        if (deviceInfo == null) {
            result.success = false
            result.msg = "deviceInfo is null."
            render result as JSON
            return
        }

        if (deviceInfo.hasErrors()) {
            result.success = false
            result.msg = deviceInfo.errors
            render result as JSON
            return
        }

        deviceInfo.save flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

    def delete(DeviceInfo deviceInfo) {
        def result = [:]
        if (deviceInfo == null) {
            result.success = false
            result.msg = "deviceInfo is null."
            render result as JSON
            return
        }

        //删除用户信息
        deviceInfo.delete flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

}
