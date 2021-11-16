package com.apiMuni.apirest.business

import com.apiMuni.apirest.dao.PersonaRepository
import com.apiMuni.apirest.exception.BusinessException
import com.apiMuni.apirest.exception.NotFoundException
import com.apiMuni.apirest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class PersonaBusiness : IPersonaBusiness {
    @Autowired
    val personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Persona> {
        try {
            return personaRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun cargar(idPersona: Long): Persona {
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la persona con ID: $idPersona")
        }
        return op.get()

    }
    }
