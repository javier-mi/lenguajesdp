package edu.caece.lenguajesdeprogramacion.tpfinal.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.caece.lenguajesdeprogramacion.tpfinal.domain.Equation;
import edu.caece.lenguajesdeprogramacion.tpfinal.repository.EquationRepository;

@RestController
@CrossOrigin(origins = "*")
public class EquationsController {
	
	@Autowired
	private EquationRepository equationRepository;
	
	@GetMapping("/get/{id}")
	public Equation getEquation(@PathVariable Long id) throws NotFoundException {
		return equationRepository.findById(id).orElseThrow(NotFoundException::new);
	}
	
	@GetMapping("/getAll")
	public Collection<Equation> getEquations() {
		return StreamSupport.stream(equationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}
	
	@PostMapping("/save")
	@Transactional
	public void save(@RequestBody Equation equation) throws NotFoundException {
		Equation equationToSave = equation;
		if (equation.getId()!=null) {
			equationToSave = this.equationRepository.findById(equation.getId()).orElseThrow(NotFoundException::new);
			BeanUtils.copyProperties(equation, equationToSave);
		}
		this.equationRepository.save(equationToSave);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		equationRepository.deleteById(id);
	}
}
