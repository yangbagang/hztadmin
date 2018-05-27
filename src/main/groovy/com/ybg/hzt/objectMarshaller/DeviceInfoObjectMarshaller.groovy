package com.ybg.hzt.objectMarshaller

import com.ybg.hzt.device.DeviceInfo
import grails.converters.JSON
import org.grails.web.converters.exceptions.ConverterException
import org.grails.web.converters.marshaller.ObjectMarshaller
import org.grails.web.json.JSONWriter

class DeviceInfoObjectMarshaller implements ObjectMarshaller<JSON> {

    @Override
    boolean supports(Object object) {
        return object instanceof DeviceInfo
    }

    @Override
    void marshalObject(Object object, JSON converter) throws ConverterException {
        JSONWriter writer = converter.getWriter()
        writer.object()
        writer.key('id').value(object.id)
                .key("uid").value(object.uid)
                .key('name').value(object.name)
                .key('installedCapacity').value(object.installedCapacity)
                .key('catalogName').value(object.deviceCatalog?.name)
        writer.endObject()
    }

}
