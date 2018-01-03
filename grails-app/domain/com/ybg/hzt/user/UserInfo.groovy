package com.ybg.hzt.user

import org.apache.commons.codec.digest.DigestUtils

class UserInfo {

    static constraints = {
    }

    String name//用户名称
    String mobile//手机号
    String password//密码
    String appToken = ""//推送消息预留
    String email = ""//Email
    String company = ""//公司名称

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = DigestUtils.sha256Hex(password)
    }
}
