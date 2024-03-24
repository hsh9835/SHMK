package org.shmk.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    // SQL 파일을 읽어서 실행
//    val sql = String(Files.readAllBytes(Paths.get("src/main/resources/schema.sql")))
    // JdbcTemplate 생성
//    val jdbcTemplate = JdbcTemplate()
    // SQL 실행
//    jdbcTemplate.execute(sql)
    runApplication<BackendApplication>(*args)
}