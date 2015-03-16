class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "500"(view:'/error')
        "/"(controller: "event"){
            action = [POST:"save"]
        }
        "/$id"(resource: "event")
	}
}
