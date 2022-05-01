package com.example.helloworld.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.scalars.ID
//import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

data class Widget(val id: ID, val value: String)

@Component
class WidgetQuery : Query {
    @GraphQLDescription("query that uses GraphQLContext widget")
    fun widget(id: ID): Widget = Widget(id, "테스트용")
}

//@Component
//class WidgetMutation : Mutation {
//    fun updateWidget(id: ID, value: String): Boolean = updateWidgetInDB(id, value)
//}
