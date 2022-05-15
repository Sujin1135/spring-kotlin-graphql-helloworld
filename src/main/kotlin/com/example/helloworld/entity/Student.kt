package com.example.helloworld.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("students")
data class Student (
    @Id
    @Field("_id")
    val id: String,
    val city: String,
    val fname: String,
)