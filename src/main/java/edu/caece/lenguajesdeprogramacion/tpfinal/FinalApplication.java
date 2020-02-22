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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
			repository.save(new Equation("Lagrange", "", ""));
			repository.save(new Equation("Diferencias Divididas", "", null));
			repository.save(new Equation("Regula Falsi", "", "<m v=\"1.2.0\"><e></e><f type=\"subscript\" group=\"functions\"><b p=\"latex\">{<r ref=\"1\"/>}_{<r ref=\"2\"/>}</b><b p=\"asciimath\"><r ref=\"1\"/><r ref=\"2\"/></b><c down=\"2\" bracket=\"yes\" delete=\"1\" name=\"base\"><e>c</e></c><c up=\"1\" delete=\"1\" name=\"subscript\" small=\"yes\"><e>k</e></c></f><e></e><f group=\"operations\" type=\"=\" ast_type=\"operator\"><b p=\"latex\">=</b><b p=\"asciimath\"> = </b></f><e></e><f type=\"fraction\" group=\"functions\"><b p=\"latex\">\\dfrac{<r ref=\"1\"/>}{<r ref=\"2\"/>}</b><b p=\"small_latex\">\\frac{<r ref=\"1\"/>}{<r ref=\"2\"/>}</b><b p=\"asciimath\">(<r ref=\"1\"/>)/(<r ref=\"2\"/>)</b><c up=\"1\" down=\"2\" name=\"numerator\"><e></e><f type=\"subscript\" group=\"functions\"><b p=\"latex\">{<r ref=\"1\"/>}_{<r ref=\"2\"/>}</b><b p=\"asciimath\"><r ref=\"1\"/><r ref=\"2\"/></b><c down=\"2\" bracket=\"yes\" delete=\"1\" name=\"base\"><e>a</e></c><c up=\"1\" delete=\"1\" name=\"subscript\" small=\"yes\"><e>k</e></c></f><e>+</e><f type=\"subscript\" group=\"functions\"><b p=\"latex\">{<r ref=\"1\"/>}_{<r ref=\"2\"/>}</b><b p=\"asciimath\"><r ref=\"1\"/><r ref=\"2\"/></b><c down=\"2\" bracket=\"yes\" delete=\"1\" name=\"base\"><e>b</e></c><c up=\"1\" delete=\"1\" name=\"subscript\" small=\"yes\"><e>k</e></c></f><e></e></c><c up=\"1\" down=\"2\" delete=\"1\" name=\"denominator\"><e>2</e></c></f><e></e></m>"));
			repository.save(new Equation("Secante", "", null));
			repository.findAll().forEach(System.out::println);
		};
	}
}
