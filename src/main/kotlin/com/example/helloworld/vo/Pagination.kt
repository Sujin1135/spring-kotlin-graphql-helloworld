package com.example.helloworld.vo

data class Pagination (val page: Long = 1, val size: Long = 5) {
    fun skipped(): Long {
        return (page - 1) * size
    }
}
