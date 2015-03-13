package no.ciber.service

import grails.rest.Resource

@Resource(uri = '/events', formats = ['json', 'xml'])
class Event {

    String name
    Date createdDate = new Date()
    String description
    Date eventDate

    static constraints = {
        name blank: false
        description blank: false
        eventDate blank: false
        createdDate blank: false
    }
}
