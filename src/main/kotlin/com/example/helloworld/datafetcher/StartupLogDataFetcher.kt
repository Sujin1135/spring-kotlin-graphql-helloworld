package com.example.helloworld.datafetcher

import com.example.helloworld.entity.StartupLog
import com.example.helloworld.repository.StartupLogRepository
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux

@DgsComponent
class StartupLogDataFetcher {
    @Autowired
    lateinit var repository: StartupLogRepository

    @DgsQuery
    fun startupLogs(): Flux<StartupLog> {
        return repository.findAll()
    }
}
