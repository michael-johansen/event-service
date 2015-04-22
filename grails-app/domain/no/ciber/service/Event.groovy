package no.ciber.service

import org.joda.time.DateTime

class Event {

    String name
    DateTime createdDate = new DateTime()
    String description
    DateTime startDate
    DateTime endDate
    Integer location
    static hasMany = [ users: Integer]

    static constraints = {
        name blank: false
        description blank: false
        description size: 0..1000
        startDate blank: false
        endDate blank: false
        createdDate blank: false
        location blank: false
        users nullable: true
    }

    static namedQueries = {


        filterOnStartDate{
            String inStartDate ->
                if(inStartDate){
                    gt('startDate', DateTime.parse(inStartDate).toDateTime())
                }
        }
        filterOnEndDate{
            String inEndtDate ->
                if(inEndtDate){
                    gt('endDate', DateTime.parse(inEndtDate).toDateTime())
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
