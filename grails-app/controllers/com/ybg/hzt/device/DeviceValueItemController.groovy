package com.ybg.hzt.device

import com.ybg.hzt.vo.AjaxPagingVo
import grails.converters.JSON

class DeviceValueItemController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index() {
        [catalogList: DeviceCatalog.all]
    }

    def create(Long catalogId) {
        [catalogId: catalogId]
    }

    def list(Long catalogId) {
        def c = DeviceValueItem.createCriteria()
        def data = c.list(max: params.length, offset: params.start) {
            deviceCatalog {
                eq("id", catalogId)
            }
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

    def edit(DeviceValueItem deviceValueItem) {
        [deviceValueItem: deviceValueItem]
    }

    def save(DeviceValueItem deviceValueItem) {
        def result = [:]
        if (deviceValueItem == null) {
            result.success = false
            result.msg = "deviceValueItem is null."
            render result as JSON
            return
        }

        if (deviceValueItem.hasErrors()) {
            result.success = false
            result.msg = deviceValueItem.errors
            render result as JSON
            return
        }

        deviceValueItem.save flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

    def delete(DeviceValueItem deviceValueItem) {
        def result = [:]
        if (deviceValueItem == null) {
            result.success = false
            result.msg = "deviceValueItem is null."
            render result as JSON
            return
        }

        //删除用户信息
        deviceValueItem.delete flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

}
