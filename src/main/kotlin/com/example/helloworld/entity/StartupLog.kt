package com.example.helloworld.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("startup_log")
data class StartupLog(
    @Id
    @Field("_id")
    val id: String,
    val hostname: String,
    val pid: Int,
)