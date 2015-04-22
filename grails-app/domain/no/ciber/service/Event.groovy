package no.ciber.service

import org.jadira.usertype.dateandtime.joda.PersistentInstantAsMillisLong
import org.joda.time.DateTime
import org.joda.time.Instant

class Event {

    String name
    Instant createdDate = new Instant()
    String description
    Instant startDate
    Instant endDate
    Integer location
    static hasMany = [ users: Integer]

    static mapping = {
        createdDate type: PersistentInstantAsMillisLong
        startDate type: PersistentInstantAsMillisLong
        endDate type: PersistentInstantAsMillisLong
    }

    static constraints = {
        name blank: false
        description blank: false
        description size: 0..1000
        startDate nullable: false
        endDate nullable: false
        createdDate nullable: false
        location nullable: false
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
