package com.example.helloworld.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document("startup_log")
class StartupLog(val _id: String) {}