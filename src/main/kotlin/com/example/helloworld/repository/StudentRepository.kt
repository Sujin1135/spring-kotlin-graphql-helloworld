package com.example.helloworld.repository

import com.example.helloworld.entity.Student
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface StudentRepository : ReactiveMongoRepository<Student, String> {
}