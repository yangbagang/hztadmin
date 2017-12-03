package com.ybg.hzt.device

import com.ybg.hzt.user.UserInfo
import grails.gorm.transactions.Transactional

@Transactional
class UserBatteryService {

    def addUserBattery(String mobile, String uid) {
        if (mobile && uid) {
            def userInfo = UserInfo.findByMobile(mobile)
            if (userInfo) {
                def userBattery = UserBattery.findByUserInfoAndUid(userInfo, uid)
                if (!userBattery) {
                    userBattery = new UserBattery()
                    userBattery.userInfo = userInfo
                    userBattery.uid = uid

                    userBattery.save flush: true
                }
            }
        }
    }
}
