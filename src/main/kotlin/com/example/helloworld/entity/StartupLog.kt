package com.example.helloworld.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("startup_log")
data class StartupLog(
    @Id
    @Field("_id")
    val id: String,
    val buildinfo: Any,
    val cmdLine: Any,
    val hostname: String,
    val pid: Int,
    val startTime: LocalDateTime,
    val startTimeLocal: String,
)