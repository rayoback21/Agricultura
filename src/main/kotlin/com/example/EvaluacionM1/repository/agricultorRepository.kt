package com.example.EvaluacionM1.repository

import com.example.EvaluacionM1.model.Agricultor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface agricultorRepository: JpaRepository<Agricultor, Long> {
    fun findById(id: Long?): Agricultor?
}