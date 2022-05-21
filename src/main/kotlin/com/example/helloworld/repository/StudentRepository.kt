package com.example.helloworld.repository

import com.example.helloworld.entity.Student
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface StudentRepository : ReactiveMongoRepository<Student, String> {
    fun findByCity(city: String): Flux<Student>
}