import grails.util.Environment
import no.ciber.service.Event

class BootStrap {

    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT) {
            new Event(name: "My first event", description: "This is an example event", eventDate: new Date(), createdDate: new Date()).save()
            new Event(name: "My second event", description: "This is annother example event", eventDate: new Date(), createdDate: new Date()).save()
        }
    }
    def destroy = {
    }
}
