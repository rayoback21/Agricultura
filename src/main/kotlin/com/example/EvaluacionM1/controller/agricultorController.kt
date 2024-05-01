package com.example.EvaluacionM1.controller

import com.example.EvaluacionM1.model.Agricultor
import com.example.EvaluacionM1.service.agricultorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agricultor")
class agricultorController {
    @Autowired
    lateinit var agricultorService: agricultorService
    @GetMapping
    fun list(): List<Agricultor>{
        return agricultorService.list()
    }
    @PostMapping
    fun save(@RequestBody agricultor: Agricultor): Agricultor{
        return agricultorService.save(agricultor)
    }
    @PutMapping
    fun update(@RequestBody agricultor: Agricultor): ResponseEntity<Agricultor>{
        return ResponseEntity(agricultorService.update(agricultor), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName(@RequestBody agricultor: Agricultor):ResponseEntity<Agricultor>{
        return ResponseEntity(agricultorService.updateName(agricultor), HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String>{
        agricultorService.delete(id)
        return ResponseEntity("Agricultor Eliminado",HttpStatus.OK)
    }
}