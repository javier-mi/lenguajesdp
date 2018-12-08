package edu.caece.lenguajesdeprogramacion.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.caece.lenguajesdeprogramacion.tpfinal.domain.Equation;

@RepositoryRestResource(collectionResourceRel = "equations", path = "equations")
public interface EquationRepository extends JpaRepository<Equation, String> {

}
