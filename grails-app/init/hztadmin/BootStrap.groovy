package hztadmin

import com.ybg.hzt.objectMarshaller.SystemUserRoleObjectMarshaller
import com.ybg.hzt.objectMarshaller.UserBatteryObjectMarshaller
import grails.converters.JSON

class BootStrap {

    def systemUserService

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Date) {
            return it?.format("yyyy-MM-dd HH:mm:ss")
        }
        JSON.registerObjectMarshaller(new SystemUserRoleObjectMarshaller(), 9999)
        JSON.registerObjectMarshaller(new UserBatteryObjectMarshaller(), 9999)
        systemUserService.initSystemUser()
    }

    def destroy = {
    }

}
