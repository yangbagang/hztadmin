package com.ybg.hzt.device

import com.ybg.hzt.user.UserInfo
import grails.events.annotation.gorm.Listener
import groovy.transform.CompileStatic
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEvent
import org.grails.datastore.mapping.engine.event.PostDeleteEvent
import org.grails.datastore.mapping.engine.event.PostInsertEvent
import org.grails.datastore.mapping.engine.event.PostUpdateEvent

class UserBatteryUpdateListener {

    @Listener(UserBattery)
    void onPostDeleteEvent(PostDeleteEvent event) {
        updateForEvent(event)
    }

    @Listener(UserBattery)
    void onPostInsertEvent(PostInsertEvent event) {
        updateForEvent(event)
    }

    @Listener(UserBattery)
    void onPostUpdateEvent(PostUpdateEvent event) {
        updateForEvent(event)
    }

    private void updateForEvent(AbstractPersistenceEvent event) {
        if (event.entity instanceof UserBattery) {
            UserBattery userBattery = event.entity as UserBattery
            UserInfo userInfo = userBattery.userInfo
            userInfo.sideNum = 0
            userInfo.installedCapacity = 0
            def list = UserBattery.findAllByUserInfo(userInfo)*.uid
            list.each {
                def deviceInfo = DeviceInfo.findByUid(it)
                userInfo.sideNum += 1
                userInfo.installedCapacity += deviceInfo.installedCapacity
            }
            userInfo.save flush: true
        }
    }
}
