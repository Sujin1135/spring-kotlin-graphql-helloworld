package com.example.helloworld.repository

import com.example.helloworld.entity.StartupLog
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface StartupLogRepository : ReactiveMongoRepository<StartupLog, String> {
}