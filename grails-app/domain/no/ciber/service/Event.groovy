package no.ciber.service

class Event {

    String name
    Date createdDate = new Date()
    String description
    Date startDate
    Date endDate
    String location
    static hasMany = [ users: String]

    static constraints = {
        name blank: false
        description blank: false
        startDate blank: false
        endDate blank: false
        createdDate blank: false
        location blank: false
        users nullable: true
    }
}
