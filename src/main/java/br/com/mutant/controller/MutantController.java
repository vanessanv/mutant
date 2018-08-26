package br.com.mutant.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.mutant.validation.MutantValidation;

@Controller
public class MutantController {

	@PostMapping(path = "/mutant", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity verificarMutante(@RequestBody LinkedHashMap linkedHashMap) {

		boolean isMutant = false;

		ArrayList<String> arrayListDna = ((ArrayList<String>) linkedHashMap.get("dna"));
		String[] dna = new String[arrayListDna.size()];
		arrayListDna.toArray(dna);
		isMutant = new MutantValidation().isMutant(dna);

		if (isMutant) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

}
