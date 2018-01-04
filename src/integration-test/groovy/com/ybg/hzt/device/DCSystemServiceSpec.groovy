package com.ybg.hzt.device

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DCSystemServiceSpec extends Specification {

    DCSystemService DCSystemService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DCSystem(...).save(flush: true, failOnError: true)
        //new DCSystem(...).save(flush: true, failOnError: true)
        //DCSystem DCSystem = new DCSystem(...).save(flush: true, failOnError: true)
        //new DCSystem(...).save(flush: true, failOnError: true)
        //new DCSystem(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //DCSystem.id
    }

    void "test get"() {
        setupData()

        expect:
        DCSystemService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DCSystem> DCSystemList = DCSystemService.list(max: 2, offset: 2)

        then:
        DCSystemList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        DCSystemService.count() == 5
    }

    void "test delete"() {
        Long DCSystemId = setupData()

        expect:
        DCSystemService.count() == 5

        when:
        DCSystemService.delete(DCSystemId)
        sessionFactory.currentSession.flush()

        then:
        DCSystemService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DCSystem DCSystem = new DCSystem()
        DCSystemService.save(DCSystem)

        then:
        DCSystem.id != null
    }
}
