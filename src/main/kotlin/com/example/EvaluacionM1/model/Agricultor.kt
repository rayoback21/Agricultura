package com.example.EvaluacionM1.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "agricultor")
class Agricultor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nickname: String? = null
    var address: String? = null
    var email: String? = null
    var phonenumber: String? = null
    var age: Int? = null
}