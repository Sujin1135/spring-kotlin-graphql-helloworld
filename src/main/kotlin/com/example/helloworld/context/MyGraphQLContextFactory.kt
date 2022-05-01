package com.example.helloworld.context

import com.expediagroup.graphql.server.spring.execution.DefaultSpringGraphQLContextFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest

@Component
class MyGraphQLContextFactory : DefaultSpringGraphQLContextFactory() {
    override suspend fun generateContextMap(request: ServerRequest): Map<*, Any> = super.generateContextMap(request) + mapOf(
        "myCustomValue" to (request.headers().firstHeader("MyHeader") ?: "defaultContext")
    )
}
