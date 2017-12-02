package com.ybg.hzt.device

import com.ybg.hzt.vo.AjaxPagingVo
import grails.converters.JSON
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class BatteryController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index() {
        //render html for ajax
    }

    def list() {
        def data = Battery.list(params)
        def count = Battery.count()

        def result = new AjaxPagingVo()
        result.data = data
        result.draw = Integer.valueOf(params.draw)
        result.error = ""
        result.success = true
        result.recordsTotal = count
        result.recordsFiltered = count
        render result as JSON
    }

    def show(Battery battery) {
        render battery as JSON
    }

    @Transactional
    def save(Battery battery) {
        def result = [:]
        if (battery == null) {
            result.success = false
            result.msg = "battery is null."
            render result as JSON
            return
        }

        battery.createTime = new Date()

        if (battery.hasErrors()) {
            transactionStatus.setRollbackOnly()
            result.success = false
            result.msg = battery.errors
            render result as JSON
            return
        }

        battery.save flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

    @Transactional
    def delete(Battery battery) {
        def result = [:]
        if (battery == null) {
            result.success = false
            result.msg = "battery is null."
            render result as JSON
            return
        }

        battery.delete flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

}
