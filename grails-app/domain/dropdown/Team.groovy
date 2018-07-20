package dropdown

class Team {

    String name

    static belongsTo = City

    City city



    static constraints = {
    }

    String toString() {
        name
    }
}
