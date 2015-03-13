package no.ciber.service

import grails.rest.RestfulController

import grails.transaction.Transactional
import org.joda.time.DateTime

@Transactional(readOnly = true)
class EventController extends RestfulController {
    static responseFormats = ['json', 'xml']

    EventController() {
        super(Event)
    }

    def index(Integer max, String intervalStart, String intervalEnd) {
        List<Event> result = getResult(intervalStart, intervalEnd, max)
        respond result, model: [("${resourceName}Count".toString()): countResources()]
    }

    def getResult(String intervalStart, String intervalEnd, Integer max) {
        List<Event> result
        if (intervalStart && intervalEnd && max) {
            Date startDate = DateTime.parse(intervalStart).toDate()
            Date endDate = DateTime.parse(intervalEnd).toDate()
            result = Event.findAllByEventDateBetween(startDate, endDate)
            if (result.size() > max) {
                result = result.subList(0, max)
            }
        } else if (intervalStart && intervalEnd && !max) {
            Date startDate = DateTime.parse(intervalStart).toDate()
            Date endDate = DateTime.parse(intervalEnd).toDate()
            result = Event.findAllByEventDateBetween(startDate, endDate)
        } else {
            params.max = Math.min(max ?: 10, 100)
            result = listAllResources(params)
        }
        result
    }

}
