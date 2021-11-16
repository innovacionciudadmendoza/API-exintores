package com.apiMuni.apirest.business

import com.apiMuni.apirest.model.Persona

interface IPersonaBusiness {
    fun list(): List<Persona>
    fun cargar(idPersona:Long):Persona

}