package com.ybg.hzt.device

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WarningMsgServiceSpec extends Specification {

    WarningMsgService warningMsgService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new WarningMsg(...).save(flush: true, failOnError: true)
        //new WarningMsg(...).save(flush: true, failOnError: true)
        //WarningMsg warningMsg = new WarningMsg(...).save(flush: true, failOnError: true)
        //new WarningMsg(...).save(flush: true, failOnError: true)
        //new WarningMsg(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //warningMsg.id
    }

    void "test get"() {
        setupData()

        expect:
        warningMsgService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<WarningMsg> warningMsgList = warningMsgService.list(max: 2, offset: 2)

        then:
        warningMsgList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        warningMsgService.count() == 5
    }

    void "test delete"() {
        Long warningMsgId = setupData()

        expect:
        warningMsgService.count() == 5

        when:
        warningMsgService.delete(warningMsgId)
        sessionFactory.currentSession.flush()

        then:
        warningMsgService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        WarningMsg warningMsg = new WarningMsg()
        warningMsgService.save(warningMsg)

        then:
        warningMsg.id != null
    }
}
