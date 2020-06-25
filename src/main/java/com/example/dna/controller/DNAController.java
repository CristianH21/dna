package com.example.dna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dna.entity.DNA;
import com.example.dna.service.DNAService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class DNAController {

	@Autowired
	private DNAService dnaService;
	
	
	@GetMapping("/stats")
	public ResponseEntity<?> getStats() {		
		return ResponseEntity.status(200).body(dnaService.getStats());
	}
	
	@PostMapping("/mutation")
	public ResponseEntity<?> hasMutation(@RequestBody DNA dna) {
		return dnaService.checkMutation(dna) ? 
				ResponseEntity.status(200).body("Has mutation.") : 
				ResponseEntity.status(403).body("Does not have mutation.");
	}
	
	
}
