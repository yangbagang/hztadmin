package com.ybg.hzt.device

import com.ybg.hzt.user.UserInfo
import grails.gorm.transactions.Transactional

@Transactional
class UserBatteryService {

    def addUserBattery(Long userId, String[] batteryIds) {
        if (userId && batteryIds) {
            def userInfo = UserInfo.get(userId)
            for (String batteryId in batteryIds) {
                def battery = Battery.get(Long.valueOf(batteryId))
                def userBattery = UserBattery.findByUserInfoAndBattery(userInfo, battery)
                if (!userBattery) {
                    userBattery = new UserBattery()
                    userBattery.userInfo = userInfo
                    userBattery.battery = battery
                    userBattery.save flush: true
                }
            }
        }
    }
}
