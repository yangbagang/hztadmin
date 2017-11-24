package com.ybg.hzt.device

class BatteryHistoryData {

    static belongsTo = [battery: Battery]

    static constraints = {
    }

    Float voltage = 0f//电压
    Float temperature = 0f//温度
    Float internalResistance = 0f//内阻
    Float current = 0f//电流
    Date createTime = new Date()
    Integer createYear = 0//年
    Integer createMonth = 0//月
    Integer createDay = 0//日
    Integer createHour = 0//时
    Integer createMinute = 0//分
    Integer createSecond = 0//秒
    Integer dayInWeek = 0//星期几
    Integer weekInYear = 0//第几周
}
