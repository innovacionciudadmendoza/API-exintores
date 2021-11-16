package com.apiMuni.apirest.web

import com.apiMuni.apirest.business.IPersonaBusiness
import com.apiMuni.apirest.exception.BusinessException
import com.apiMuni.apirest.model.Persona
import com.apiMuni.apirest.utils.Constantes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constantes.URL_BASE_PERSONAS)
class PersonaRestController {
@Autowired
val personaBussines:IPersonaBusiness?=null
    @GetMapping("")
    fun list():ResponseEntity<List<Persona>>{

        return try {
            ResponseEntity(personaBussines!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping("/{id}")
    fun cargar(@PathVariable("id")idPersona:Long):ResponseEntity<Persona>{
        return try {
            ResponseEntity(personaBussines!!.cargar(idPersona), HttpStatus.OK)

        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)

        }catch (e:Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)

        }

    }
}