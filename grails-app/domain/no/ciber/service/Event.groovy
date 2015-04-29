package no.ciber.service

import org.joda.time.DateTime
import org.joda.time.Instant

class Event {

    String name
    Long createdDate = new Instant().millis
    String description
    Long startDate
    Long endDate
    Integer location
    static hasMany = [ users: Integer]

    static constraints = {
        name blank: false
        description blank: false
        description size: 0..1000
        startDate nullable: false
        endDate nullable: false
        createdDate nullable: false
        location nullable: false
        users nullable: true
        users blank: true
    }

    static namedQueries = {


        filterOnStartDate{
            String inStartDate ->
                if(inStartDate){
                    gt('startDate', DateTime.parse(inStartDate).toDateTime())
                }
        }
        filterOnEndDate{
            String inEndDate ->
                if(inEndDate){
                    gt('endDate', DateTime.parse(inEndDate).toDateTime())
                }
        }
        filterOnIds{
            List<Long> ids ->
                if(ids){
                    inList('id', ids)
                }
        }
    }
}
