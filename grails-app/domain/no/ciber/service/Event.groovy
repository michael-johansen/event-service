package no.ciber.service

class Event {

    String name
    Date createdDate = new Date()
    String description
    Date eventDate
    static hasMany = [ users: String]

    static constraints = {
        name blank: false
        description blank: false
        eventDate blank: false
        createdDate blank: false
        users nullable: true
    }
}
