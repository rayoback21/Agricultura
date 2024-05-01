package com.example.EvaluacionM1.service

import com.example.EvaluacionM1.model.Agricultor
import com.example.EvaluacionM1.repository.agricultorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class agricultorService {
    @Autowired
    lateinit var agricultorRepository: agricultorRepository

    fun list(): List<Agricultor> {
        return agricultorRepository.findAll()
    }

    fun save(agricultor: Agricultor): Agricultor {
        return agricultorRepository.save(agricultor)
    }

    fun update(agricultor: Agricultor): Agricultor {
        try {
            agricultorRepository.findById(agricultor.id) ?: throw Exception("Existe este ID")
            return agricultorRepository.save(agricultor)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(agricultor: Agricultor): Agricultor {
        try {
            var response = agricultorRepository.findById(agricultor.id) ?: throw Exception("Existe ID")
            response.apply {
                nickname = agricultor.nickname
            }
            return agricultorRepository.save(response)
        } catch (ex: ResponseStatusException) {

            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }
        fun delete(id: Long) {
            try {
                var response = agricultorRepository.findById(id).orElseThrow {
                    throw ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "El agricultor existe en el Id: $id"
                    )
                }
                agricultorRepository.delete(response)
            } catch (ex: Exception) {
                throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error eliminandi agricultorr", ex)
            }
        }
    }









