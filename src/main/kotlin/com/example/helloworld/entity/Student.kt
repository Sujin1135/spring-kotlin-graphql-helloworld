package com.example.helloworld.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("students")
data class Student (
    @Id
    @Field("_id")
    val id: ObjectId?,
    val city: String,
    val fname: String,
    @Field("meta")
    val meta: Meta?,
)

data class Meta (val name: String)
