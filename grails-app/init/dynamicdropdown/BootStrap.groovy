package dynamicdropdown

import dropdown.City
import dropdown.Team

class BootStrap {

    def init = { servletContext ->

        if (City.count() < 1 ){

            City city = new City(name: "Santiago").save()
            new Team(name: "Aguilas", city : city).save()
            City city1 = new City(name: "La Vega").save()
            new Team(name: "Los Reales", city:city1).save()
        }
    }
    def destroy = {
    }
}
