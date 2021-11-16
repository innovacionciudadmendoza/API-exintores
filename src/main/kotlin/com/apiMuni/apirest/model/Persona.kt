package com.apiMuni.apirest.model

import org.hibernate.annotations.GeneratorType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Persona(val usuario:String, val clave : String) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0
}