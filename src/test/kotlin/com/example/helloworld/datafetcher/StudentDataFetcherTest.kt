package com.example.helloworld.datafetcher

import com.example.helloworld.config.MongoConfig
import com.example.helloworld.entity.Student
import com.example.helloworld.repository.StudentRepository
import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DgsAutoConfiguration::class, MongoConfig::class, StudentRepository::class, StudentDataFetcher::class])
class StudentDataFetcherTest {
    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @Test
    fun students() {
        val cities : List<String> = dgsQueryExecutor.executeAndExtractJsonPath("""
            {
                students {
                    id,
                    city,
                    meta {
                        name
                    }
                }
            }
        """.trimIndent(), "data.students[*].city")

        assertThat(cities).contains("춘천")
    }
}