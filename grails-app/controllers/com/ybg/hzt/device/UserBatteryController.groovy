package com.ybg.hzt.device

import com.ybg.hzt.user.UserInfo
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
        def data = UserBattery.list(params)
        def count = UserBattery.count()

        def result = new AjaxPagingVo()
        result.data = data
        result.draw = Integer.valueOf(params.draw)
        result.error = ""
        result.success = true
        result.recordsTotal = count
        result.recordsFiltered = count
        render result as JSON
    }

    @Transactional
    def addUserBattery(Long userId) {
        def result = [:]

        userBatteryService.addUserBattery(userId, params.batteryList)

        result.success = true
        result.msg = ""
        render result as JSON
    }

    @Transactional
    def delete(Long userId, Long batteryId) {
        def result = [:]
        def userInfo = UserInfo.get(userId)
        def battery = Battery.get(batteryId)
        def userBattery = UserBattery.findByUserInfoAndBattery(userInfo, battery)
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
