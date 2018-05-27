package com.ybg.hzt.device

import com.ybg.hzt.vo.AjaxPagingVo
import grails.converters.JSON
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class DeviceCatalogController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index() {
        //render html for ajax
    }

    def create() {

    }

    def list() {
        def data = DeviceCatalog.list(params)
        def count = DeviceCatalog.count()

        def result = new AjaxPagingVo()
        result.data = data
        result.draw = Integer.valueOf(params.draw)
        result.error = ""
        result.success = true
        result.recordsTotal = count
        result.recordsFiltered = count
        render result as JSON
    }

    def edit(DeviceCatalog deviceCatalog) {
        [deviceCatalog: deviceCatalog]
    }

    @Transactional
    def save(DeviceCatalog deviceCatalog) {
        def result = [:]
        if (deviceCatalog == null) {
            result.success = false
            result.msg = "deviceCatalog is null."
            render result as JSON
            return
        }

        if (deviceCatalog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            result.success = false
            result.msg = deviceCatalog.errors
            render result as JSON
            return
        }

        deviceCatalog.save flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

    @Transactional
    def delete(DeviceCatalog deviceCatalog) {
        def result = [:]
        if (deviceCatalog == null) {
            result.success = false
            result.msg = "deviceCatalog is null."
            render result as JSON
            return
        }

        //删除用户信息
        deviceCatalog.delete flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }
}
