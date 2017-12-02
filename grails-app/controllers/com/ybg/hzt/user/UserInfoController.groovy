package com.ybg.hzt.user

import com.ybg.hzt.device.UserBattery
import com.ybg.hzt.vo.AjaxPagingVo
import grails.converters.JSON
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class UserInfoController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def springSecurityService

    def index() {
        //render html for ajax
    }

    def list() {
        def data = UserInfo.list(params)
        def count = UserInfo.count()

        def result = new AjaxPagingVo()
        result.data = data
        result.draw = Integer.valueOf(params.draw)
        result.error = ""
        result.success = true
        result.recordsTotal = count
        result.recordsFiltered = count
        render result as JSON
    }

    def show(UserInfo userInfo) {
        render userInfo as JSON
    }

    @Transactional
    def save(UserInfo userInfo) {
        def result = [:]
        if (userInfo == null) {
            result.success = false
            result.msg = "userInfo is null."
            render result as JSON
            return
        }

        if (userInfo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            result.success = false
            result.msg = userInfo.errors
            render result as JSON
            return
        }

        userInfo.save flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }

    @Transactional
    def delete(UserInfo userInfo) {
        def result = [:]
        if (userInfo == null) {
            result.success = false
            result.msg = "systemRole is null."
            render result as JSON
            return
        }

        //删除与电池的关联
        def batteryList = UserBattery.findAllByUserInfo(userInfo)
        if (batteryList) {
            batteryList.each {
                it.delete flush: true
            }
        }
        //删除用户信息
        userInfo.delete flush:true

        result.success = true
        result.msg = ""
        render result as JSON
    }
}
