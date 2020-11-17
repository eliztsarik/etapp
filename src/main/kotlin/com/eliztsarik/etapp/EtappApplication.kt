package com.eliztsarik.etapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EtappApplication

fun main(args: Array<String>) {
    runApplication<EtappApplication>(*args)
}
