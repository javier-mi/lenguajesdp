package edu.caece.lenguajesdeprogramacion.tpfinal.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.caece.lenguajesdeprogramacion.tpfinal.domain.Equation;
import edu.caece.lenguajesdeprogramacion.tpfinal.repository.EquationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquationsController {
	
	@Autowired
	private EquationRepository equationRepository;
	
	@GetMapping("/equations")
	public Collection<Equation> equations() {
		return equationRepository.findAll().stream()
                .collect(Collectors.toList());
	}
	
	@PostMapping("/equations/save")
	public void save(@RequestBody Equation equation) {
		this.equationRepository.save(equation);
	}
	
	@DeleteMapping("/equations/delete/{id}")
	public void delete(Long id) {
		// TODO
	}
	
	

}
