package com.example.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

// TODO: DB 연결 후 DataSourceAutoConfiguration exclude 제거
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class HelloworldApplication

fun main(args: Array<String>) {
    runApplication<HelloworldApplication>(*args)
}
