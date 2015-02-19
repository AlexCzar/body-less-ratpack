import ratpack.thymeleaf.ThymeleafModule

import static ratpack.groovy.Groovy.ratpack
import static ratpack.thymeleaf.Template.thymeleafTemplate

ratpack {
    bindings {
        add ThymeleafModule, { it.templatesMode('HTML5') }
    }
    handlers {
        prefix("") {
            handler {
                byMethod {
                    get {
                        render thymeleafTemplate('test', user: System.getProperty('user.name'))
                    }
                    post {
                        println "Received $request.body.text"
                        response.status(418) // I'm a tea pot but POST works
                        response.send(request.body.text)
                    }
                }
            }
        }
        assets 'assets'
    }
}


