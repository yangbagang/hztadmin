package com.ybg.hzt.objectMarshaller

import com.ybg.hzt.device.UserBattery
import grails.converters.JSON
import org.grails.web.converters.exceptions.ConverterException
import org.grails.web.converters.marshaller.ObjectMarshaller
import org.grails.web.json.JSONWriter

class UserBatteryObjectMarshaller implements ObjectMarshaller<JSON> {

    @Override
    boolean supports(Object object) {
        return object instanceof UserBattery
    }

    @Override
    void marshalObject(Object object, JSON converter) throws ConverterException {
        JSONWriter writer = converter.getWriter()
        writer.object()
        writer.key('id').value(object.id)
                .key("name").value(object.userInfo.name)
                .key('mobile').value(object.userInfo.mobile)
                .key('uid').value(object.uid)
        writer.endObject()
    }

}
