package no.ciber.service

import org.joda.time.DateTime

class Event {

    String name
    Date createdDate = new Date()
    String description
    Date startDate
    Date endDate
    Integer location
    static hasMany = [ users: String]

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
                    gt('startDate', DateTime.parse(inStartDate).toDate())
                }
        }
        filterOnEndDate{
            String inEndtDate ->
                if(inEndtDate){
                    gt('endDate', DateTime.parse(inEndtDate).toDate())
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
