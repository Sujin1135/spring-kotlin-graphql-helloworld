package com.example.helloworld.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date

@Document("startup_log")
data class StartupLog(

    @Id
    @Field("_id")
    val id: String,
    val hostname: String,
    val pid: Int,
    val startTime: Date,

    @Field("buildinfo")
    val buildInfo: BuildInfo
)

data class BuildInfo(
    val debug: Boolean,
    val gitVersion: String,
    val javascriptEngine: String,
    val maxBsonObjectSize: Int,
    val sysInfo: String,
    val version: String,
    val versionArray: Array<String>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BuildInfo

        if (debug != other.debug) return false
        if (gitVersion != other.gitVersion) return false
        if (javascriptEngine != other.javascriptEngine) return false
        if (maxBsonObjectSize != other.maxBsonObjectSize) return false
        if (sysInfo != other.sysInfo) return false
        if (version != other.version) return false
        if (!versionArray.contentEquals(other.versionArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = debug.hashCode()
        result = 31 * result + gitVersion.hashCode()
        result = 31 * result + javascriptEngine.hashCode()
        result = 31 * result + maxBsonObjectSize
        result = 31 * result + sysInfo.hashCode()
        result = 31 * result + version.hashCode()
        result = 31 * result + versionArray.contentHashCode()
        return result
    }
}
