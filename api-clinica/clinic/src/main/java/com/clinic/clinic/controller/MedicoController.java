package com.clinic.clinic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.clinic.model.Medico;
import com.clinic.clinic.repositorio.MedicoRepository;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class MedicoController {
	
	
	public MedicoRepository medicoRepository;
	
	 MedicoController(MedicoRepository repository) {
		    this.medicoRepository = repository;
		  }
	
	@GetMapping("/medicos")
	public ResponseEntity<List<Medico>>  listaTodosMedicos(){
			
		//return medicoRepository.findAll();
		try {
			List<Medico> list = medicoRepository.findAll();
			return ResponseEntity.ok().body(list);
		}catch(Exception e){
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/medico/{id}")
	public Medico ListaMedicoId(@PathVariable Long id){
		return medicoRepository.findById(id).get();
	}
	
	@PostMapping("/medico")
	public Medico atualizaMedico(@RequestBody Medico medico) {
		return medicoRepository.save(medico);
	}
	
	@PutMapping
	public Medico insereMedico(@RequestBody Medico medico) {
		return medicoRepository.save(medico);
	}
	
	@DeleteMapping("/medico/{id}")
	public void deletaMedicoId(@PathVariable Long id) {
		medicoRepository.deleteById(id);
	}
}
