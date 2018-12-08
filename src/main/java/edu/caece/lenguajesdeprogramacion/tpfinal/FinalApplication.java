package edu.caece.lenguajesdeprogramacion.tpfinal;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.caece.lenguajesdeprogramacion.tpfinal.domain.Equation;
import edu.caece.lenguajesdeprogramacion.tpfinal.repository.EquationRepository;

@SpringBootApplication
public class FinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
	}

    @Bean
    ApplicationRunner init(EquationRepository repository) {
        return args -> {
            Stream.of("Lagrange", "Diferencias Divididas", "Regula Falsi", "Secante")
            .forEach(name -> {
                Equation equation = new Equation();
                equation.setName(name);
                repository.save(equation);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
