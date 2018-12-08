package edu.caece.lenguajesdeprogramacion.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.caece.lenguajesdeprogramacion.tpfinal.domain.Equation;

public interface EquationRepository extends JpaRepository<Equation, String> {

}
