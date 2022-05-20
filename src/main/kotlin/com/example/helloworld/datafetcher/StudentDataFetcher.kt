package com.example.helloworld.datafetcher

import com.example.helloworld.entity.Student
import com.example.helloworld.repository.StudentRepository
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@DgsComponent
class StudentDataFetcher {
    @Autowired
    lateinit var repository: StudentRepository

    @DgsQuery
    fun students(@InputArgument titleFilter: String?): Flux<Student> {
        return repository.findAll()
    }

    @DgsMutation
    fun addStudent(@InputArgument("studentInput") studentInput: Student): Mono<Student> {
        return repository.insert(studentInput)
    }
}
