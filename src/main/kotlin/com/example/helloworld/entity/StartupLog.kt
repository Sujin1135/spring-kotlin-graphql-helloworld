package com.example.helloworld.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("startup_log")
data class StartupLog(
    @Id
    val _id: String
)