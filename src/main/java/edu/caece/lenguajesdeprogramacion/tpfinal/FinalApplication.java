package edu.caece.lenguajesdeprogramacion.tpfinal;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import edu.caece.lenguajesdeprogramacion.tpfinal.domain.Equation;
import edu.caece.lenguajesdeprogramacion.tpfinal.repository.EquationRepository;

@SpringBootApplication(scanBasePackages= {
	"edu.caece.lenguajesdeprogramacion.tpfinal"
//	"edu.caece.lenguajesdeprogramacion.tpfinal.config",
//	"edu.caece.lenguajesdeprogramacion.tpfinal.config.security"
})
//@ComponentScan(basePackages = { 
//@EnableAutoConfiguration
//@Configuration
@Import({WebSecurity.class})
public class FinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
	}

	@Bean
	ApplicationRunner init(EquationRepository repository) {
		return args -> {
			Stream.of("Lagrange", "Diferencias Divididas", "Regula Falsi", "Secante").forEach(name -> {
				Equation equation = new Equation();
				equation.setName(name);
				repository.save(equation);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
