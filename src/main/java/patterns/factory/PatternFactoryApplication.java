package patterns.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import patterns.factory.service.FactoryService;

@SpringBootApplication
public class PatternFactoryApplication {

	public static void main(String[] args) {
		// Executar os exemplos do padrão Factory
		FactoryService factoryService = new FactoryService();
		factoryService.executarExemplos();

		// Iniciar a aplicação Spring Boot (se necessário)
		SpringApplication.run(PatternFactoryApplication.class, args);
	}

}
