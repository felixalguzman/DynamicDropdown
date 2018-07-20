package dropdown

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CityController {

    CityService cityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cityService.list(params), model:[cityCount: cityService.count()]
    }

    def show(Long id) {
        respond cityService.get(id)
    }

    static scaffold = City

    // just navigation to the gsp
    def dynamicDropdown = {
    }

    def findTeamsForCity = {
        def city = City.get(params.city.id)
        render(template: 'teamSelection', model:  [teams: city.teams])
    }
}
