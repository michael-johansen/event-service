import grails.util.Environment
import no.ciber.service.Event

class BootStrap {

    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT) {
            new Event(name: "My first event", description: "This is an example event", startDate: new Date(), endDate: new Date(), location: "Grorud", createdDate: new Date()).save()
            new Event(name: "My second event", description: "This is annother example event", startDate: new Date(), endDate: new Date(), location: "Tomter", createdDate: new Date()).save()
        }
    }
    def destroy = {
    }
}
