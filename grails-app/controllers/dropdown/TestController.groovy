package dropdown

import org.grails.web.converters.Converter

class TestController {

    def index() { }

    def categoryChanged(long categoryId) {
        City category = City.get(categoryId)
        def subCategories = []
        if ( category != null ) {
            subCategories = Team.findAllByCity(category, [order:'name'])
        }
        render (text:g.select(id:'subCategory', name:'subCategory.id',
                from:subCategories, optionKey:'id', noSelection:[null:' '])
        )
    }
}
