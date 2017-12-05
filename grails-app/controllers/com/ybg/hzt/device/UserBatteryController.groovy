package com.ybg.hzt.device

import com.ybg.hzt.vo.AjaxPagingVo
import grails.converters.JSON
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class UserBatteryController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def userBatteryService

    def index() {
        //render html for ajax
    }

    def list() {
        def c = UserBattery.createCriteria()
        def data = c.list(max: params.length, offset: params.start) {
            or {
                userInfo {
                    like("mobile", "%" + params.name + "%")
                }
                like("uid", "%" + params.name + "%")
            }
            order("id", "desc")
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

    @Transactional
    def addUserBattery(String mobile, String uid) {
        def result = [:]

        userBatteryService.addUserBattery(mobile, uid)

        result.success = true
        result.msg = ""
        render result as JSON
    }

    @Transactional
    def delete(Long id) {
        def result = [:]
        def userBattery = UserBattery.get(id)
        if (userBattery == null) {
            result.success = false
            result.msg = "userBattery is null."
            render result as JSON
            return
        }

        userBattery.delete flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

}
