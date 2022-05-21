package com.example.helloworld.datafetcher

import com.example.helloworld.entity.Student
import com.example.helloworld.repository.StudentRepository
import com.example.helloworld.vo.Pagination
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@DgsComponent
class StudentDataFetcher : BaseDataFetcher() {

    @Autowired
    lateinit var repository: StudentRepository

    @DgsQuery
    fun students(@InputArgument pagination: Pagination): Flux<Student> {
        return repository.findAll().skip(pagination.skipped()).take(pagination.size)
    }

    @DgsQuery
    fun studentsByCity(@InputArgument city: String = "Seoul"): Flux<Student> {
        return repository.findByCity(city)
    }

    @DgsQuery
    fun student(@InputArgument id: String): Mono<Student> {
        return repository.findById(id)
    }

    @DgsMutation
    fun addStudent(@InputArgument studentInput: Student): Mono<Student> {
        return repository.insert(studentInput)
    }

    @DgsMutation
    fun deleteStudent(@InputArgument id: String): Mono<Boolean> {
        val student = repository.findById(id).toFuture().get()
        return repository.delete(student).thenReturn(true)
    }
}
