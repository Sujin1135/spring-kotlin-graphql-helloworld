package com.example.helloworld.datafetcher

import com.example.helloworld.entity.Student
import com.example.helloworld.repository.StudentRepository
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux

@DgsComponent
class StartupLogDataFetcher {
    @Autowired
    lateinit var repository: StudentRepository

    private val shows = listOf(
        Show("Stranger Things", 2016),
        Show("Ozark", 2017),
        Show("The Crown", 2016),
        Show("Dead to Me", 2019),
        Show("Orange is the New Black", 2013),
    )

    @DgsQuery
    fun shows(@InputArgument titleFilter : String?): List<Show> {
        println("*** called findAllStartupLogs")

        return if(titleFilter != null) {
            shows.filter { it.title.contains(titleFilter) }
        } else {
            shows
        }
    }

    data class Show(val title: String, val releaseYear: Int)

    @DgsQuery
    fun students(@InputArgument titleFilter : String?): Flux<Student> {
        return repository.findAll()
    }
}
