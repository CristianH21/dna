package com.example.dna;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dna.entity.DNA;
import com.example.dna.service.DNAService;

@SpringBootTest
class DnaApplicationTests {
	
	DNAService dnaService = new DNAService();

	@Test
	public void has_mutation_test1 () {
		String[] array = {"AAAAGA","CAGTAC","TTAAGT","AGCCAG","CGCCTA","TCACTG"};
		DNA dna = new DNA(array);
		boolean expected = true;
		 
		Assertions.assertEquals(expected, dnaService.checkMutation(dna));
	}
	
	@Test
	public void has_mutation_test2 () {
		String[] array = {"AAACGA","CAGTAC","TTAAGT","AGCCAG","CGCCTA","TCACTG"};
		DNA dna = new DNA(array);
		boolean expected = false;
		 
		Assertions.assertEquals(expected, dnaService.checkMutation(dna));
	}

}
