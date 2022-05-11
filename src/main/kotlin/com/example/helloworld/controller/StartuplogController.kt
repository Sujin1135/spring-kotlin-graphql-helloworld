package com.example.helloworld.controller

import com.example.helloworld.repository.StartupLogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class StartuplogController {
    @Autowired
    lateinit var startupLogRepository: StartupLogRepository

    @GetMapping("get")
    fun get() = startupLogRepository.findAll()
}