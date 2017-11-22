package com.ybg.hzt.user

import org.apache.commons.codec.digest.DigestUtils

class UserInfo {

    static constraints = {
    }

    String name
    String mobile
    String password
    String appToken = ""

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
