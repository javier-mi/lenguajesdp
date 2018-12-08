package edu.caece.lenguajesdeprogramacion.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.caece.lenguajesdeprogramacion.tpfinal.domain.Equation;

@RepositoryRestResource(collectionResourceRel = "equations", path = "equations")
@CrossOrigin(origins = "http://localhost:4200")
public interface EquationRepository extends JpaRepository<Equation, String> {

}
