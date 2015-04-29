package no.ciber.service

import grails.rest.RestfulController
import no.ciber.utils.EventUtil

import grails.transaction.Transactional
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.web.servlet.HttpHeaders

import static org.springframework.http.HttpStatus.CREATED

@Transactional(readOnly = true)
class EventController extends RestfulController {
    private static final LOG = LogFactory.getLog(EventController.class)
    static responseFormats = ['json', 'xml']

    EventController() {
        super(Event)
    }

    def index(Integer max, Long intervalStart, Long intervalEnd, String events) {
        List<Event> result = getResult(intervalStart, intervalEnd, max, events)
        respond result, model: [("${resourceName}Count".toString()): countResources()]
    }

    def getResult(Long intervalStart, Long intervalEnd, Integer max, String events) {
        params.max = Math.min(max ?: 10, 100)
        return Event.filterOnStartDate(intervalStart).filterOnEndDate(intervalEnd).filterOnIds(EventUtil.getIdsFromEventsParameter(events)).list(params)
    }

    @Override
    @Transactional
    def save() {
        if(handleReadOnly()) {
            return
        }
        def event = createResource()

        event.validate()
        if (event.hasErrors()) {
            respond event.errors, view:'create' // STATUS CODE 422
            return
        }

        event.save flush:true

        if(event.users.empty) {
            LOG.info(String.format("Event with id: %S was saved without any users", event.id))
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: "${resourceName}.label".toString(), default: resourceClassName), event.id])
                redirect event
            }
            '*' {
                response.addHeader(HttpHeaders.LOCATION,
                        g.createLink(
                                resource: this.controllerName, action: 'show',id: event.id, absolute: true,
                                namespace: hasProperty('namespace') ? this.namespace : null ))
                respond event, [status: CREATED]
            }
        }

    }

    @Override
    protected Event createResource() {
        Event instance = Event.newInstance()
        bindData instance, getObjectToBind()
        instance
    }
}
