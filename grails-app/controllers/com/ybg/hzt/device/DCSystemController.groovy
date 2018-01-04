package com.ybg.hzt.device

import com.ybg.hzt.vo.AjaxPagingVo
import grails.converters.JSON

class DCSystemController {

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

}
