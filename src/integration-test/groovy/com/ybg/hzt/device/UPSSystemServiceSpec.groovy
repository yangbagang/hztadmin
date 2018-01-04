package com.ybg.hzt.device

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UPSSystemServiceSpec extends Specification {

    UPSSystemService UPSSystemService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UPSSystem(...).save(flush: true, failOnError: true)
        //new UPSSystem(...).save(flush: true, failOnError: true)
        //UPSSystem UPSSystem = new UPSSystem(...).save(flush: true, failOnError: true)
        //new UPSSystem(...).save(flush: true, failOnError: true)
        //new UPSSystem(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //UPSSystem.id
    }

    void "test get"() {
        setupData()

        expect:
        UPSSystemService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UPSSystem> UPSSystemList = UPSSystemService.list(max: 2, offset: 2)

        then:
        UPSSystemList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        UPSSystemService.count() == 5
    }

    void "test delete"() {
        Long UPSSystemId = setupData()

        expect:
        UPSSystemService.count() == 5

        when:
        UPSSystemService.delete(UPSSystemId)
        sessionFactory.currentSession.flush()

        then:
        UPSSystemService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UPSSystem UPSSystem = new UPSSystem()
        UPSSystemService.save(UPSSystem)

        then:
        UPSSystem.id != null
    }
}
