package com.apiMuni.apirest

import com.apiMuni.apirest.dao.PersonaRepository
import com.apiMuni.apirest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApirestApplication:CommandLineRunner{
	@Autowired
	val personaRepository:PersonaRepository?=null
	override fun run(vararg args: String?) {
		val persona1 = 	Persona("Maxi","123")
	}

}

fun main(args: Array<String>) {
	runApplication<ApirestApplication>(*args)
}
